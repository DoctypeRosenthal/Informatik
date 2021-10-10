package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by group 24 on 24.11.16.
 */

public class PP_HA2_Caesar {
    public static void main() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer word; // das einzulesende Wort
        StringBuffer result = new StringBuffer(); // das Ergebnis der Ver-/Entschlüsselung
        byte direction; // ob die Zeichenkette verschlüsselt (1) oder entschlüsselt (2) werden soll
        int n; // die Anzahl an Positionen, um die jeder Buchstabe der Wortes im Alphabet verschoben wird
        byte i; // Laufindex
        char nextLetter; // der nächste verschlüsselte Buchstabe

        do {
            System.out.println("Bitte geben Sie eine Ver-/Entschlüsselungszahl zwischen 1 und 25 ein. Die Zahl gibt an, um wie viele Stellen jeder Buchstabe des Wortes verschoben wird");
            n = IO1.einint();
        } while (n < 1 || 25 < n);

        // einlesen des Wortes
        try {
            System.out.println("Bitte ein Wort eingeben");
            word = new StringBuffer(br.readLine());
        } catch (IOException err) {
            return;
        }

        System.out.println("1: Zeichenkette verschlüsseln");
        System.out.println("2: Zeichenkette entschlüsseln");

        do {
            System.out.println("Bitte eine der oben stehenden Nummern eingeben");
            direction = (byte) IO1.einint();
        } while (direction != 1 && direction != 2);

        if (direction == 2) {
            n = n * (-1); // entschlüsseln -> Verschieberichtung umkehren
        }

        for (i = 0; i < word.length(); i ++) {
            nextLetter = getNextLetter((int) word.charAt(i), n);
            result.append(nextLetter);
        }

        if (direction == 1) {
            System.out.println("Die verschlüsselte Zeichenkette: " + result);
        } else {
            System.out.println("Die entschlüsselte Zeichenkette: " + result);
        }
    }

    private static char getNextLetter(int charCode, int charDisplacement) {
        // char codes
        byte ug, og; // die untere und obere Grenze der Buchstaben-Zielmenge

        int charCodeSum = charCode + charDisplacement, // die summe aus aktueller Position und Verschiebe-Zahl
            nextCharCode; // die Position des neuen Buchstabens

        if ((byte) 'A' <= charCode && charCode <= (byte) 'Z') {
            // Menge der Großbuchstaben
            ug = (byte) 'A';
            og = (byte) 'Z';
        } else if ((byte) 'a' <= charCode && charCode <= (byte) 'z') {
            // Menge der Kleinbuchstaben
            ug = (byte) 'a';
            og = (byte) 'z';
        } else {
            // kein Buchstabe
            return (char) charCode;
        }

        if (charCodeSum < ug) {
            // wieder bei z (von oben) anfangen
            nextCharCode = og - (ug - charCodeSum);
        } else if (og < charCodeSum) {
            // wieder bei a (von unten) anfangen.
            // Wenn charCodeSum = 'Z' + 1 ist, ist der Wert einen über der og. Dann muss 'A' rauskommen.
            // Da ug == 'A', muss man also bei (ug - 1) wieder anfangen und nicht bei ug!
            nextCharCode = (ug - 1) + (charCodeSum - og);
        } else {
            // die Summe liegt schon in unserer Zielmenge
            nextCharCode = charCodeSum;
        }

        return (char) nextCharCode;
    }

}
