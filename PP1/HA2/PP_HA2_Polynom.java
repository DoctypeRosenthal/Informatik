package com.company;

/**
 * Created by lorenz on 24.11.16.
 */
public class PP_HA2_Polynom {
    public static void main() {
        double  a, b, c,           // Koeffizienten
                x_links, x_rechts, // Intervallgrenzen
                tausch,            // Tauschvar.
                abstand,           // Abstand der Stützstellen
                x;                 // x-Wert d. Funktion

        int i = 0, // Laufindex
            k = 0; // Stützstellen

        System.out.println("Koeffizienten eingeben");
        System.out.print("a: ");
        a = IO1.eindouble();
        System.out.print("b: ");
        b = IO1.eindouble();
        System.out.print("c: ");
        c = IO1.eindouble();

        System.out.println("Intervallgrenzen eingeben");
        System.out.print("links: ");
        x_links = IO1.eindouble();
        System.out.print("rechts: ");
        x_rechts = IO1.eindouble();

        if (x_links > x_rechts) {
            tausch = x_links;
            x_links = x_rechts;
            x_rechts = tausch;
        }

        System.out.println("Anzahl der Stützstellen eingeben");
        k = IO1.einint();

        abstand = (x_rechts - x_links) / (k + 1);
        while (i <= k + 1) {
            x = x_links + i * abstand;
            System.out.println("f(" + x + ") = " + polynom(x, a, b, c));
            i ++;
        }

    }

    public static double polynom(double x, double a, double b, double c) {
        return a*Math.pow(x, 2) + b*x + c;
    }
}
