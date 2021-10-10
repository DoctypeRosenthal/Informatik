package HA4;

import utils.IO1;

/**
 * Created by lorenz on 19.01.17.
 */
public class HashTable_Main {
    public static void main() {
        HashTable ht = new HashTable(6);
        int choice;
        String word;

        do {
            // show the hash table to the user
            System.out.print("Unsere hash tabelle: ");
            System.out.println(ht.print());

            System.out.println(
                    "Bitte wählen Sie aus:\n"
                    + "1) Neues Wort speichern\n"
                    + "2) Wort suchen\n"
                    + "3) Word löschen (falls vorhanden)\n"
                    + "0) Programm beenden"
            );
            choice = IO1.einint();

            if (choice != 0) {
                System.out.print("Bitte Wort eingeben: ");
                word = IO1.einstring();

                switch (choice) {
                    case 1:
                        if (ht.store(word) == false) {
                            System.out.println("Wort wurde nicht gespeichert, da Position schon besetzt!");
                        }
                        break;
                    case 2:
                        int foundAt = ht.search(word);
                        if (foundAt != -1) {
                            // note: classLoader couldn't get StringConcatFactory in the build. I don't know why...
                            // hence: everything has its own line
                            System.out.print("Wort wurde bei Index ");
                            System.out.print(foundAt);
                            System.out.println(" gefunden!");
                        } else {
                            System.out.println( "Wort wurde nicht gefunden!");
                        }
                        break;
                    case 3:
                        ht.delete(word);
                        break;
                }
            }
            System.out.println("--");

        } while (choice != 0);
    }
}
