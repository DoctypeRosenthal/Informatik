package Praktikum3;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lorenz on 12.06.17.
 */
public class MaschSerAnw {
    public static void main() throws IOException, ClassNotFoundException {
        FileReader fr = new FileReader("Praktikum3_Masch.txt");
        BufferedReader br = new BufferedReader(fr);
        FileOutputStream fos = new FileOutputStream("Praktikum3_Masch.ser");
        ObjectOutputStream os = new ObjectOutputStream(fos);
        FileInputStream fis = new FileInputStream("Praktikum3_Masch.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<MaschineSer> maLst = new LinkedList<>();

        maschSerAus(br, os);
        maschSerEin(ois, maLst);

        System.out.println("Maschinen, die serialisiert eingelesen wurden:");
        for (MaschineSer ma : maLst) {
            ma.ausMasch();
        }

        ois.close();
        br.close();
        os.close();
        fr.close();
        fos.close();
        fis.close();
    }

    /**
     * Liest Maschinen als CSV-Strings aus einer Datei, konvertiert sie in MaschineSer-Instanzen und schreibt diese
     * Instanzen dann serialisiert in eine Datei.
     *
     * @param br1   BufferedReader einer CSV-Datei
     * @param ow1   OutputStream, der Maschinen serialisiert in eine Datei schreibt
     * @return      Anzahl der vollständigen Maschinen
     * @throws IOException
     * @throws ClassNotFoundException
     */
    static int maschSerAus(BufferedReader br1, ObjectOutputStream ow1) throws IOException, ClassNotFoundException {
        String str = br1.readLine();
        MaschineSer ma;
        int anzOk = 0; // Anzahl der vollständigen Maschinen
        while (str != null) {
            ma = new MaschineSer(str); // Maschinen-Instanz von CSV-String erzeugen
            if (ma.getCrt() == 1) {
                // Maschine ist ok
                ow1.writeObject(ma); // Maschine serialisiert in Datei schreiben
                anzOk ++;
            }

            str = br1.readLine(); // nächste Zeile lesen
        }
        return anzOk;
    }

    /**
     * Ließt serialisierte Maschinen-Objekte aus einer Datei und erzeugt daraus eine Liste
     *
     * @param or1   ObjectInputStream auf eine Datei mit serialisierten Maschinen
     * @param xs3   Referenz auf Liste, die mit den Maschinen befüllt wird
     * @return      Anzahl an Maschinen
     * @throws IOException
     * @throws ClassNotFoundException
     */
    static int maschSerEin(ObjectInputStream or1, List<MaschineSer> xs3) throws IOException, ClassNotFoundException {
        int anzOk = 0; // Anzahl der vollständigen Maschinen
        MaschineSer ma;

        try {
            while (true) {
                ma = (MaschineSer) or1.readObject();
                xs3.add(ma);
                anzOk ++;
            }
        }
        catch (IOException e) {
            System.out.println("Alle Maschinen eingelesen!");
        }

        return anzOk;
    }
}
