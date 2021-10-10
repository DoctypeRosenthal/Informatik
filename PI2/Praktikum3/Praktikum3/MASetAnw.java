package Praktikum3;

import utils.IO1;

import java.io.*;
import java.util.Arrays;

/**
 * Created by lorenz on 23.05.17.
 */
public class MASetAnw {

    public static void main() {
        MASet maset = new MASet();
        FileReader fr;
        BufferedReader br;

        try {
            fr = new FileReader("Praktikum3_Masch.txt");
            br = new BufferedReader(fr);

            maset.dat2set(br);
            String[] strArr = maset.set2Stringf(1);
            System.out.println(Arrays.toString(strArr));

            System.out.println("Diese CSV-Strings in eine Datei speichern? (j: ja)");
            if (IO1.einchar() == 'j') {
                // String-Array in Datei schreiben
                maschAus(strArr, "Praktikum3_MaschAus.txt");
                System.out.println("Datensätze in Datei geschrieben!");
            }

            br.close();
            fr.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Schreibt ein Array von Strings in eine Datei
     * @param maschS    Unser String-Array (besteht aus Maschinen-CSV-Strings)
     * @param das       Dateiname der Datei, in die geschrieben werden soll
     * @return
     * @throws IOException
     */
    static int maschAus(String[] maschS, String das) throws IOException {
        FileWriter fw = new FileWriter(das);
        PrintWriter pw = new PrintWriter(fw);
        for (String ma : maschS) {
            // schreibe in Datei
            pw.println(ma);
        }

        pw.close();
        fw.close();
        return 0;
    }
}
