package Praktikum3;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by lorenz on 23.05.17.
 */
public class MASet {
    private TreeSet<MaschineS> tmenge;
    private HashSet<MaschineS> hmenge;

    public MASet() {
        this.tmenge = new TreeSet<>();
        this.hmenge = new HashSet<>();
    }

    /**
     * Initiiert die Properties tmenge und hmenge mit Maschinen durch einlesen einer CSV-Datei. Nur korrekte Maschinen
     * werden übernommen! Es werden keine Maschinen-Duplikate übernommen.
     *
     * Anmerkung: Hier werden die Methoden dat2tset und dat2hset kombiniert! Damit wird Codewiederholung vorgebeugt.
     * Dies macht das Programm einfacher lesbar, erweiterbar und wartbar.
     *
     * @param br1   Unser BufferedReader, der eine CSV-Datei ließt
     * @return      Anzahl der korrekten CSV-Datensätze. Duplikate werden nicht gezählt!
     * @throws IOException
     */
    int dat2set(BufferedReader br1) throws IOException {
        int anzOK = 0;
        MaschineS ma;
        String ln = br1.readLine();

        // Maschinen einlesen
        while (ln != null) {
            ma = new MaschineS(ln);
            if (ma.getCrt() == 1) {
                // Maschine ist ok!
                if (tmenge.add(ma) && hmenge.add(ma)) {
                    // Maschine existierte in beiden sets noch nicht. Dies ist bei einer neuen Maschine immer der Fall.
                    anzOK ++;
                }
            }
            ln = br1.readLine();
        }
        return anzOK;
    }

    String[] set2Stringf(int a) throws Exception {
        if (a < 1 || 2 < a) throw new Exception("kein gültiger Wert für a!");

        String[] out = new String[hmenge.size()]; // Es gilt immer: |hmenge| = |tmenge|. Von daher kann man hier die eine oder die andere nehmen.
        int i = 0;

        // über die Elemente der gewünschten Menge iterieren. Beide Mengen bestehen aus MaschineS-Instanzen.
        for (MaschineS ma : (a == 1 ? hmenge : tmenge)) {
            out[i] = ma.ausMaschCSV(); // Maschine als CSV-String speichern
            i ++;
        }
        return out;
    }
}
