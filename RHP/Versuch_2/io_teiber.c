#include "simuc.h"
#include "io_treiber.h"

typedef struct BHandle_Data {
    BYTE Board_allocated;   // 1=allocated, 0=free
    BYTE Port_A_Direction;  // 1=Output, 0=Input
    BYTE Port_B_Direction;
    BYTE Port_C_Direction;
    BYTE Port_D_Direction;
} BHandle;

BHandle BoardHandle_Data;
DSCB GlobalBoardHandle = &BoardHandle_Data;  // nur für debugging!


BYTE Init(DSCB BoardHandle, unsigned long int Steuerwort) {
    if (BoardHandle->Board_allocated) {
        // Hardware konnte nicht reserviert werden
        return 1;
    }

    // Dekodierung des Steuerwortes
    BoardHandle->Port_A_Direction = ~Steuerwort >> 4 & 1; // bit 5 des Steuerworts gibt die Richtung für PA
    BoardHandle->Port_B_Direction = ~Steuerwort >> 1 & 1; // bit 2 gibt die Richtung von PB
    BoardHandle->Port_C_Direction = ~Steuerwort >> 3 & 1; // bit 4 gibt die Richtung von PC
    BoardHandle->Port_D_Direction = ~Steuerwort & 1; // bit 1 gibt die Richtung von PD an

    // Aufteilung der physikalischen Portbits für die virtuellen Ports:
    // Port 1: 15 bis 8 = Port D, 7 bis 0 = Port C
    // Port 0: 15 bis 8 = Port B, 7 bis 0 = Port A
    io_out16(DIR1, BoardHandle->Port_D_Direction*0xFF00 | BoardHandle->Port_C_Direction*0x00FF);
    io_out16(DIR0, BoardHandle->Port_B_Direction*0xFF00 | BoardHandle->Port_A_Direction*0x00FF);

    BoardHandle->Board_allocated = 1;
    return 0;
}

BYTE InputByte(DSCB BoardHandle, BYTE Port, BYTE *DigitalValue) {

    switch (Port) {
        case PA:
            // prüfen, ob von A gelesen werden darf. Wenn nicht, mit 1 beenden!
            if (BoardHandle->Port_A_Direction) return 1; // Port steht auf "schreiben"
            // wir dürfen lesen
            *DigitalValue = io_in16(IN0);
            break;
        case PB:
            if (BoardHandle->Port_B_Direction) return 1;
            *DigitalValue = io_in16(IN0) >> 8;
            break;
        case PC:
            if (BoardHandle->Port_C_Direction) return 1;
            *DigitalValue = io_in16(IN1);
            break;
        case PD:
            if (BoardHandle->Port_D_Direction) return 1;
            *DigitalValue = io_in16(IN1) >> 8;
            break;
    }

    // behalte nur das niederwertige byte, lösche alles andere!
    //*DigitalValue = *DigitalValue & 0x00FF;
    return 0;
}

/**
 * @brief OutputByte    Schreibt ein bitmuster auf ein virtuelles Port
 * @param BoardHandle   Die Port-Konfiguration
 * @param Port          Das virtuelle Ziel-Port
 * @param DigitalValue  Das Bitmuster
 * @return              1 falls Fehler, sonst 0
 */
BYTE OutputByte(DSCB BoardHandle, BYTE Port, BYTE DigitalValue) {
    unsigned short int port_pattern; // enthält ein bitmuster, in dem nur die bits vom virtuellen Port neu gesetzt sind

    switch (Port) {
        case PA:
            // prüfen, ob auf A geschrieben werden darf. Wenn nicht, mit 1 beenden!
            if (!BoardHandle->Port_A_Direction) return 1;
            // wir dürfen schreiben
            // pattern bilden, was das byte von Port B erhält und nur Port A verändert
            // 1001 1010 0000 0000
            port_pattern = (io_in16(OUT0) & 0xFF00) | DigitalValue;
            break;
        case PB:
            if (!BoardHandle->Port_B_Direction) return 1;
            // pattern bilden, was das byte von Port A erhält und nur Port B verändert
            port_pattern = (DigitalValue << 8) | (io_in16(OUT0) & 0x00FF);
            break;
        case PC:
            if (!BoardHandle->Port_C_Direction) return 1;
            // pattern bilden, was das byte von Port D erhält und nur Port C verändert
            port_pattern = (io_in16(OUT1) & 0xFF00) | DigitalValue;
            break;
        case PD:
            if (!BoardHandle->Port_D_Direction) return 1;
            // pattern bilden, was das byte von Port C erhält und nur Port D verändert
            port_pattern = (DigitalValue << 8) | (io_in16(OUT1) & 0x00FF);
            break;
    }

    // auf das physische Port schreiben
    if (Port == PA || Port == PB) io_out16(OUT0, port_pattern);
    if (Port == PC || Port == PD) io_out16(OUT1, port_pattern);
    SYNC_SIM;
    return 0;
}

/**
 * @brief Free          Gibt die reservierte Hardware wieder frei
 * @param BoardHandle   Das BoardHandle, durch das die Hardware reserviert wurde
 * @return              1 falls Hardware schon freigegeben, 0 falls alles ok.
 */
BYTE Free(DSCB BoardHandle) {
    if (!BoardHandle->Board_allocated) {
        // ungültiges Boardhandle
        return 1;
    }

    BoardHandle->Board_allocated = 0;
    return 0;
}
