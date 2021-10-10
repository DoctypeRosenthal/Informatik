package HA3;

import utils.IO1;

/**
 * Created by lorenz on 14.12.16.
 */
public class HashFromString {
    public static void main() {
        char endProgram = 'n';
        do {
            System.out.println("Bitte eine Zeichenkette eingeben, um sie in einen Hash zu übersetzen.");
            String str = IO1.einstring();
            System.out.println("Der Hashwert der Zeichenkette ist " + makeHash(str));
            System.out.println("Programm beenden? y: ja, n: nein");
            endProgram = IO1.einchar();
        } while (endProgram != 'y');
    }

    static int makeHash(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += str.codePointAt(i);
        }
        return sum % 5;
    }
}
