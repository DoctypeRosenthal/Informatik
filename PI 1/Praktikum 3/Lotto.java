/***************************************************************/
/* Verfasser: Gruppe 08                                         */
/* Source   : Lotto.java                                        */
/* Zweck    : Erzeugung von 6 Lottozahlen und Ziehung           */
/* Stand    : 6.12.2016                                         */
/* Gruppe 8 : Devrim Eker, Lorenz Rosenthal                     */
/***************************************************************/

package PI1.HA3;

import utils.IO1;
import java.util.Arrays;
import static java.lang.System.out;

public class Lotto {
    public static void main() {
        int beenden = 0; // stuert, ob Programm beendet werden soll
        int[] lottoz; // das Array an Lottozahlen

        while (beenden != 1) {
            lottoz = ziehLotto();
            out.println("Die Lottozahlen sind: " + Arrays.toString(lottoz));

            out.println("Programm beenden? 1: ja, 0: nein!");
            beenden = IO1.einint();
        }
    }

    /**
     * erzeugt eine Zufallszahl zwischen 0 und 49
     * @return Zufallszahl
     */
    static int zufallZ1T49() {
        return (int) (Math.random() * 49);
    }

    /**
     * Erstellt ein Array von unterschiedlichen Lottozahlen
     * @return Lottozahlen
     */
    static int[] ziehLotto() {
        int k;                      // nächste Zufallszahl
        int[] lottoz = new int[6];  // die Lottozahlen

        for (int i = 0; i < 6; i++) {
            do {
                k = zufallZ1T49();
            } while (kGefunden(lottoz, k)); // überprüfen, ob k schon im Array ist
            // k ist neu
            lottoz[i] = k;
        }
        return lottoz;
    }

    /**
     * Durchsucht ein Array arr nach der Zahl k und gibt zurück, ob sie
     * bereits in arr existiert.
     * @param arr Das zu durchsuchende Array
     * @param k Die Such-Zahl
     * @return true, wenn Zahl schon vorhanden, sonst false
     */
    static boolean kGefunden(int[] arr, int k) {
        boolean gefunden = false; // gibt an, ob k in arr gefunden wurde
        // arr nach k durchsuchen
        for (int i = 0; i < arr.length ; i++) {
            gefunden = arr[i] == k;
            if (gefunden) {
                break;
            }
        }
        return gefunden;
    }
}
