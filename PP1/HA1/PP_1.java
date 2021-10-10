package com.company;

import static java.lang.System.out;

/**
 * Created by lorenz on 03.11.16.
 */
public class PP_1 {
    public static void main() {
        zufallsZahl();
        flagWert();
        hashWert();
        ASCII();
        concatStrings();
    }

    public static void zufallsZahl() {
        int z = (int) (Math.random() * 10), // eine Pseudo-Zufallszahl
                a = 2, // Faktor
                b = 3, // Summand
                m = 4; // modulo Wert

        out.println("Die alte Zufallszahl ist " + z + ". Die nächste Zufallszahl ist " + (a*z + b) % m);
    }

    public static void hashWert() {
        char c1 = 'M', c2 = 'a', c3 = 'i', c4 = 's'; // einzelne Buchstaben eines vier-buchstabigen Wortes
        int m = 5; // der modulo zum Berechnen des Hashwertes des Wortes

        out.println("Der Hashwert des Wortes " + c1 + c2 + c3 + c4 + " ist " + (c1 + c2 + c3 + c4) % m);
    }

    public static void flagWert() {
        short flags = 64;                   // Repräsentiert eine "Lichterkette" mit 16 Lämpchen (bits)
        byte k = 6;                         // die byte-Position des Lämpchens, welches überprüft werden soll
        byte pot2 = (byte) Math.pow(2, k);  // die 2er-Potenz von k
        String b = "aus";                   // zeigt an, ob das k-te Lämpchen brennt oder nicht. Standardwert: "aus"

        if ((flags & pot2)/pot2 == 1) {
            // das k-te bit hat den wert 1 -> das Lämpchen brennt
            b = "an";
        }

        out.println("Das " + k + "te Lämpchen ist " + b);
    }

    public static void ASCII() {
        char c = 'Z'; // enhält einen Buchstaben von A-Z

        out.print("Der übernächste Buchstabe ist ");

        if (c == 'Y') {
            out.println("A");
        } else if (c == 'Z') {
            out.println("B");
        } else {
            // zeige den Buchstaben, der von c zwei weiter hinten im Alphabet steht
            out.println((char) ((int) c + 2));
        }
    }

    public static void concatStrings() {
        String s1 = "Hallo", // Wort 1
                s2 = "Dieter", // Wort 2
                s3 = s1 + " " + s2; // beide Wörter verkettet mit Leerzeichen dazwischen

        out.println(s3);
    }
}
