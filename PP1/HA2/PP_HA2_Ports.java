package com.company;

/**
 * Created by group 24 on 24.11.16.
 */

public class PP_HA2_Ports {
    public static void main() {
        byte ende; // die Abbruchsbedingung des Programms
        int nr; // die eingegebene Portnummer

        do {
            do {
                System.out.println("Bitte eine gültige Portnummer zwischen 0 und 65535 eingeben.");
                nr = IO1.einint();
            } while (nr < 0 || nr > 65535);

            System.out.println(getType(nr));

            System.out.println("Programm beenden (1 für ja, 0 für nein)?");
            ende = (byte) IO1.einint();
        } while (ende == 0);
    }

    private static String getType(int nr) {
        if (0 <= nr && nr <= 1023) {
            return "Typ: well-known. " + getService(nr);
        } else if (1024 <= nr && nr <= 49151) {
            return "Typ: registered.";
        }
        return "Typ: dynamic.";
    }

    private static String getService(int nr) {
        switch (nr) {
            case 21:
                return "Dienst: FTP.";
            case 23:
                return "Dienst: Telnet.";
            case 25:
                return "Dienst: SMTP.";
            case 80:
                return "Dienst: HTTP.";
            case 143:
                return "Dienst: IMAP.";
            default:
                return "Sonstiger Dienst.";
        }
    }
}
