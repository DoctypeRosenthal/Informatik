#include "simuc.h"
#include "io_treiber.h"

// Die Verwendung der folgenden Zustandsnamen ist verbindlich
typedef enum {Steht,StarteRunter,StarteRauf,Notaus,FahreRauf_MIT_OF,FahreRauf_OHNE_OF,FahreRunter_MIT_OF,FahreRunter_OHNE_OF} T_STATE;
typedef struct {
    T_STATE state;
    USHORT startpos;
    USHORT aktpos;
    USHORT endpos;

    BYTE M_Re;
    BYTE M_Li;
    BYTE M_An;
} ROLLTREPPE;


void steuerung(BYTE Betrieb, BYTE NotAus, BYTE ESR, BYTE ESL, ROLLTREPPE* t) {
    long int tmp_end; // enthält eine virtuelle, berechnete Endposition der Rolltreppe (kann < 0 sein!)
    if (t->state == Notaus && !Betrieb) return; // Notschalter ist gedrückt. Sofort abbrechen
    if (NotAus) {
        // Sonderfall: Notschalter wurde gedrückt
        t->state = Notaus;
        t->M_Li = 0;
        t->M_Re = 0;
        t->M_An = 0;
        putstring("Nottaster gedrückt!\n");
        return;
    }

    // Nottaster deaktiviert
    if (Betrieb) {
        // Betrieb wurde gedrückt
        t->state = Steht;
        t->M_Li = 0;
        t->M_Re = 0;
        t->M_An = 0;
        putstring("Betriebstaster gedrückt!\n");
    }

    switch (t->state) {
        case Steht:
            if (ESR) {
                // untere Lichtschranke durchbrochen
                t->state = StarteRauf;
            }

            if (ESL) {
                // obere Lichtschranke durchbrochen
                t->state = StarteRunter;
            }
            t->M_Li = 0;
            t->M_Re = 0;
            t->M_An = 0;
            break;

        case StarteRauf:
            tmp_end = (t->aktpos - 60000) % 65535; // Endposition berechnen (negativer Überlauf mögl.)
            if (tmp_end < 0) tmp_end = tmp_end + 65535; // Überlauf ausgleichen

            t->state = t->aktpos < tmp_end ? FahreRauf_MIT_OF : FahreRauf_OHNE_OF;
            t->startpos = t->aktpos;
            t->endpos = tmp_end;
            t->M_Li = 1;
            t->M_Re = 0;
            t->M_An = 1;
            break;

        case StarteRunter:
            tmp_end = (t->aktpos + 60000) % 65535; // Endposition berechnen

            t->state = t->aktpos > tmp_end ? FahreRunter_MIT_OF : FahreRunter_OHNE_OF;
            t->startpos = t->aktpos;
            t->endpos = tmp_end;
            t->M_Li = 0;
            t->M_Re = 1;
            t->M_An = 1;
            break;

        case FahreRauf_MIT_OF:
            if (ESR) {
                t->state = StarteRauf;
            }
            else if (t->aktpos < t->endpos && t->aktpos > t->startpos) {
                // anhalten
                t->state = Steht;
            }

            break;

        case FahreRauf_OHNE_OF:
            if (ESR) {
                t->state = StarteRauf;
            }
            else if (t->aktpos < t->endpos || t->aktpos > t->startpos) {
                // anhalten
                t->state = Steht;
            }

            break;

        case FahreRunter_MIT_OF:
            if (ESL) {
                t->state = StarteRunter;
            }
            else if (t->aktpos > t->endpos && t->aktpos < t->startpos) {
                // anhalten
                t->state = Steht;
            }

            break;

        case FahreRunter_OHNE_OF:
            if (ESL) {
                t->state = StarteRunter;
            }
            else if (t->aktpos > t->endpos || t->aktpos < t->startpos) {
                // anhalten
                t->state = Steht;
            }

            break;

        default:
            t->state = Steht;
            break;
    }
}


// Anmerkung:
// steht ein Port auf 0, so kann von ihm gelesen aber nicht geschrieben werden
// 1 bedeutet "schreiben"/es darf nicht gelesen werden
void test1(DSCB bh) {
    BYTE DigitalValue = 0;
    Init(bh, 0x81); // von Port D soll gelesen werden: D auf 0 setzen
    SYNC_SIM;
    if (InputByte(bh, PD, &DigitalValue))
        putstring("Fehler beim Lesen von D\n");
    else
        putstring("Lesen von D erfolgreich\n");
    Free(bh);

    Init(bh, 0x9A); // von Port A bis C lesen. A,B,C stehen auf 0, D steht auf 1
    SYNC_SIM;
    if (InputByte(bh, PC, &DigitalValue) || InputByte(bh, PB, &DigitalValue) || InputByte(bh, PA, &DigitalValue))
        putstring("Fehler beim Lesen von A, B, C!\n");
    else
        putstring("Lesen von A, B, C erfolgreich\n");

    Free(bh);
}

void test2(DSCB bh) {
    BYTE DigitalValue = 0xAF;
    Init(bh, 0x9A); // nach Port D soll schrieben werden: D auf 1 setzen
    SYNC_SIM;
    if (OutputByte(bh, PD, DigitalValue))
        putstring("Fehler beim Schreiben nach D\n");
    else
        putstring("Schreiben auf D erfolgreich\n");
    Free(bh);

    Init(bh, 0x81); // nach Port A bis C schreiben. A,B,C = 1, D = 0
    SYNC_SIM;

    if (OutputByte(bh, PC, DigitalValue) || OutputByte(bh, PB, DigitalValue) || OutputByte(bh, PA, DigitalValue))
        putstring("Fehler beim Schreiben nach A, B, C!\n");
    else
        putstring("Schreiben nach A, B, C erfolgreich\n");

    Free(bh);
}

// Die folgenden Defines muessen sinnvoll genutzt werden
#define BIT_T2      5
#define BIT_T1      4
#define BIT_ESR     3
#define BIT_ESL     2

#define BIT_M_Re    2
#define BIT_M_Li    1
#define BIT_M_An    0

void emain(void* arg) {
    BYTE DigitalValue = 0;
    unsigned long aktpos_b = 0;
    unsigned long aktpos_a = 0;
    DSCB bh = GlobalBoardHandle;
    ROLLTREPPE t = {Steht, 0, 0, 0, 0, 0, 0}; // eine nagelneue Rolltreppe erzeugen

    INIT_BM_WITH_REGISTER_UI; // Hier unbedingt einen Break-Point setzen !!!
    /*
     * TESTS
     */
    //test1(bh);
    //test2(bh);
    //Free(bh); // sicherheitshalber

    Init(bh, 0x88); // Port A, B und D zum schreiben initialisieren

    // Ab hier beginnt die Endlosschleife fuer den Automaten (Aufgabe 2)
    while(1) {

        SYNC_SIM;

        InputByte(bh, PC, &DigitalValue);
        InputByte(bh, PB, &aktpos_b);
        aktpos_b = aktpos_b << 8;
        InputByte(bh, PA, &aktpos_a);
        t.aktpos = aktpos_b | aktpos_a;
        steuerung((DigitalValue >> BIT_T2) & 1, (DigitalValue >> BIT_T1) & 1, (DigitalValue >> BIT_ESR) & 1, (DigitalValue >> BIT_ESL) & 1, &t);

        OutputByte(bh, PD, (t.M_Re << BIT_M_Re)|(t.M_Li << BIT_M_Li)|(t.M_An << BIT_M_An));
    } // while(1)..


}
