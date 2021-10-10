/***************************************************************/
/* Verfasser: Gruppe 08                                         */
/* Source   : Messwerte.java                                    */
/* Zweck    : Erzeugung/Einlesen von Messwerten und ermitteln   */
/*            von Minimum, Maximum und arithmetischem Mittel    */
/*            dieser Werte                                      */
/* Stand    : 19.12.2016                                         */
/* Gruppe 8 : Devrim Eker, Lorenz Rosenthal                     */
/***************************************************************/

package PI1.HA3;

import utils.IO1;
import java.util.Arrays;
import static java.lang.System.out;

public class Messwerte {
    public static void main() {
        int choice; // User-Auswahl: mit vorgegebenen Messfeld rechnen oder Messwerte eingegeben?
        int n; // Die Anzahl an Messwerten
        double[] messw = {}; // Das Feld der Messwerte

        out.println("Bitte auswählen:");
        out.println("1: vordefiniertes Array verwenden");
        out.println("2: Array selbst definierten");

        // User-Auswahl: vorgegebenes Messfeld oder selbst Zahlen eingeben?
        do {
            choice = einNat();
            if (choice != 1 && 2 != choice) {
                out.println("Bitte 1 oder 2 eingeben");
            }
        } while (choice != 1 && choice != 2);

        if (choice == 1) {
            // Vrgegebenes Messfeld
            messw = messEinK();
        } else if (choice == 2) {
            // User möchte selbst Werte eingeben
            out.println("Bitte die Array-Größe eingeben");
            n = einNat(); // Anzahl der Werte einlesen
            out.println("Bitte die Messwerte einen nach dem anderen eingeben");
            messw = messEinT(n); // Messwerte einlesen
        }

        // Feld und seine Eigenschaften ausgeben
        ausMessFeld(messw);
        out.println(" hat folgende Eigenschaften:");
        out.println("Betrag Kleinstes Element: " + minBet(messw));
        out.println("Betrag größtes Element: " + maxBet(messw));
        out.println("Arithmetisches Mittel: " + arithMittel(messw));
    }

    /**
     * ließt eine natürliche Zahl > 0 ein
     * @return eine natürliche Zahl
     */
    static int einNat() {
        int zahl; // die Zahl

        // Zahl > 0 einlesen
        do {
            zahl = IO1.einint();
        } while (zahl <= 0);

        return zahl;
    }

    /**
     * Ein Feld an Messwerten mit der Länge n einlesen
     * @param n Länge des Feldes
     * @return Feld mit Messwerten
     */
    static double[] messEinT(int n) {
        double[] messw = new double[n];

        for (int i = 0; i < n; i++) {
            messw[i] = IO1.eindouble();
        }
        return messw;
    }

    /**
     *
     * @return ein Feld mit vordefinierten Messwerten
     */
    static double[] messEinK() {
        return new double[]{-10, 2.5, 3, -3.24, 4, 5};
    }

    /**
     * Gibt das Feld messw auf der console aus
     * @param messw Das Messwert-Feld
     */
    static void ausMessFeld(double[] messw) {
        out.print(Arrays.toString(messw));
    }

    /**
     * Ermittelt den größten absoluten Betrag in einem Feld
     * @param messw Das Messwert-Feld
     * @return Der größte Betrag im Feld
     */
    static double maxBet(double[] messw) {
        double max = 0;

        for (int i = 0; i < messw.length; i++) {
            if (Math.abs(messw[i]) > max) {
                max = Math.abs(messw[i]);
            }
        }
        return max;
    }

    /**
     * Ermittelt den kleinsten Betrag im Feld messw
     * @param messw Die Messwerte
     * @return kleinster Betrag des Feldes
     */
    static double minBet(double[] messw) {
        double min = maxBet(messw);

        for (int i = 0; i < messw.length; i++) {
            if (Math.abs(messw[i]) < min) {
                min = Math.abs(messw[i]);
            }
        }
        return min;
    }

    /**
     * Berechnet das arithmetische Mittel aller Werte im Feld messw
     * @param messw Die Messwerte
     * @return Arithmetisches Mittel des Feldes
     */
    static double arithMittel(double[] messw) {
        double sum = 0.0;

        for (int i = 0; i < messw.length; i++) {
            sum += messw[i];
        }

        return sum / messw.length;
    }
}
