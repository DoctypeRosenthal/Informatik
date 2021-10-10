package HA3;

import utils.IO1;
/**
 * Created by lorenz on 14.12.16.
 */
public class SequenceRandNr {

    public static void main() {
        int a, b, m, randNr = 0;
        System.out.println("Bitte drei ganze Zahlen zur Berechnung einer RandNr eingeben");
        System.out.println("Faktor");
        a = IO1.einint();
        System.out.println("Summand");
        b = IO1.einint();
        System.out.println("Modulo-Restklasse");
        m = IO1.einint();

        System.out.println("Zufallszahlen:");
        for (int i = 1; i <= 20; i++) {
            randNr = RandNr.makeRandNr(randNr, a, b, m);
            System.out.println("#" + i + " = " + randNr);
        }
    }
}
