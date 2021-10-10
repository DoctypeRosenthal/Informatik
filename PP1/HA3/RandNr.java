package HA3;
import utils.IO1;
/**
 * Created by lorenz on 14.12.16.
 */
public class RandNr {
    public static void main() {
        int a, b, m, pseudoRandNr = (int) Math.random() * 10;
        System.out.println("Bitte drei ganze Zahlen zur Berechnung einer RandNr eingeben");
        System.out.println("Faktor");
        a = IO1.einint();
        System.out.println("Summand");
        b = IO1.einint();
        System.out.println("Modulo-Restklasse");
        m = IO1.einint();
        System.out.println("Die RandNr ist: " + makeRandNr(pseudoRandNr, a, b, m));
    }

    public static int makeRandNr(int nr, int a, int b, int m) {
        return (int) (a * nr + b) % m ; // eine RandNr
    }
}
