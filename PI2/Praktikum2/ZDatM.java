package PI2.HA2;

import java.io.*;
import java.util.*;

public class ZDatM {
    private FileReader fr1;

    private BufferedReader br1;

    private FileWriter fw1;

    private PrintWriter pr1;

    private LinkedList<Maschine> dsliste;

    ZDatM(String dsn, int mod) throws Exception {
        this.dsliste = new LinkedList<Maschine>();

        if (mod == 1) {
            this.fr1 = new FileReader(dsn);
            this.br1 = new BufferedReader(fr1);

            this.einlesen();
        }

        if (mod == 2) {
            this.fw1 = new FileWriter(dsn, true);
            this.pr1 = new PrintWriter(fw1);
        }
    }

    private int einlesen() throws Exception {
        int anzOK = 0;
        String h = br1.readLine();
        Maschine ma;

        while (h != null) {

            ma = new Maschine(h);
            if (ma.getCrt() == 1) {
                // Maschine ist ok!
                anzOK++;
            }
            dsliste.add(ma);
            h = br1.readLine();
        }
        return anzOK;
    }

    public void list2dat() {
        for (Maschine ma : this.dsliste) {
            this.pr1.println(ma.ausMaschCSV());
        }
        this.pr1.close();
    }

    public LinkedList<Maschine> getDsliste() {
        return this.dsliste;
    }

    public void setDsliste(LinkedList<Maschine> dsliste) {
        this.dsliste = dsliste;
    }

    public int bubble(int iox) throws Exception {
        int vergleiche = 0; // Anzahl der durchgeführten Vergleiche
        boolean unsortiert = true;

        if (iox < 1 || 3 < iox) {
            throw new Exception("Kein gültiges Sortier-Kriterium");
        }

        // sortieren
        while (unsortiert) {
            unsortiert = false;
            for (int i = 1; i < this.dsliste.size(); i++) {
                Maschine m1 = dsliste.get(i - 1);
                Maschine m2 = dsliste.get(i);

                if (compare(iox, m1, m2) > 0) unsortiert = true;

                if (unsortiert) {
                    // tauschen
                    dsliste.set(i - 1, m2);
                    dsliste.set(i, m1);
                }

                vergleiche++;
            }
        }

        return vergleiche;
    }
    /*
    public int sortDA (int iox) {
        LinkedList<Maschine> hlist = new LinkedList<Maschine>(dsliste);  //hlist soll eine copy von dsliste sein
        int help;

        for (int i= 0;i < hlist.size()-1;i++ ) {
            help = i;
            Maschine temp;
            for (int j = i + 1; j < hlist.size(); j++) {
                switch (iox) {
                    case 1  :
                        if (hlist.get(help).getMabez().compareTo(hlist.get(j).getMabez()) > 0) {
                            help = j;
                        }

                        break;
                    case 2 :
                        if (hlist.get(help).getPreis().compareTo(hlist.get(j).getPreis()) > 0) {
                            help = j;
                        }

                        break;
                    case 3 :
                        if (hlist.get(help).getStao().compareTo(hlist.get(j).getStao()) > 0) {
                            help = j;
                        }
                        break;
                }
            }
            temp = hlist.get(i);
            hlist.set(i, hlist.get(help));
            hlist.set(help, temp);
        }



    }
*/
/*
    public int sortDA (int iox) {
        LinkedList<Maschine> hlist = new LinkedList<>(dsliste);  // dsliste kopieren
        int help;
        int vergleiche = 0;

        for (int i= 0;i < hlist.size()-1;i++ ) {
            help = i;
            for (int j = i + 1; j < hlist.size(); j++) {
                vergleiche ++;
                if (compare(iox, hlist.get(i), hlist.get(j)) > 0) {
                    help = j;
                }
            }
            Maschine temp = hlist.get(i);
            hlist.set(i, hlist.get(help));
            hlist.set(help, temp);
        }

        return vergleiche;
    }
    */
    /**
     * Vergleicht zwei Maschinen anhand eines Ordnungkriteriums
     * @param iox   Ordnungskriterium
     * @param ma1   1. Maschine
     * @param ma2   2. Maschine
     * @return      compareTo()-Wert für das jeweilige verglichene Attribut
     */
    private int compare(int iox, Maschine ma1, Maschine ma2) {
        switch(iox) {
            case 1:
                // Ordnungskriterium Maschinenbezeichnung
                return ma1.getMabez().compareTo(ma2.getMabez());
            case 2:
                // Nach Preis vergleichen
                return new Double(ma1.getPreis()).compareTo(new Double(ma2.getPreis()));

            case 3:
                // Nach Standort vergleichen
                return ma1.getStao().compareTo(ma2.getStao());
        }
        return 0; // default
    }

    /**
     * Sortiert dsliste mithilfe des Verfahrens "Direkte Auswahl"
     * @param iox   Ordnungskriterium, nach dem sortiert werden soll
     * @return      Anzahl aller Vergleiche, die durchgeführt werden mussten
     */

    public int sortDA (int iox) throws Exception {
        if (iox < 1 || 3 < iox) throw new Exception("Kein gültiges Sortier-Kriterium");

        LinkedList<Maschine> hlist = new LinkedList<>();
        int vergleiche = 0;

        for (Maschine ma : dsliste) {
            // Den Platz jeder Maschine in der sich aufbauenden hlist suchen
            if (hlist.size() == 0) {
                // tritt nur beim ersten Durchlauf auf
                // setze Ankerknoten auf ma
                hlist.add(ma);
            }
            else if (compare(iox, ma, hlist.getFirst()) < 0) {
                // ma am Anfang von hlist einfügen
                hlist.addFirst(ma);
                vergleiche ++;
            }
            else if (compare(iox, ma, hlist.getLast()) >= 0) {
                // ma an's Ende von hlist schreiben
                hlist.addLast(ma);
                vergleiche ++;
            }
            else {
                // Einfügeposition kann nur noch zweischen den äußeren Knoten von hlist liegen!
                // Einfügeposition von ma suchen:
                boolean found = false; // gibt an, ob die position in hlist gefunden wurde und ma eingefügt wurde
                for (int i = 0; i < hlist.size() - 1; i++) {
                    if (found) continue; // alles überspringen, falls ma schon erfolgreich eingefügt wurde
                    // ma immer mit zwei nebeneinanderliegenden Elementen aus hlist vergleichen
                    if (compare(iox, ma, hlist.get(i)) >= 0 && compare(iox, ma, hlist.get(i + 1)) < 0) {
                        // richtiger Platz gefunden! -> einfügen!
                        hlist.add(i + 1, ma); // ma direkt vor der nächsthöheren Maschine einfügen
                        found = true;
                    }
                    vergleiche ++; // wird nicht erreicht, wenn ma schon eingefügt!
                }
            }
        }
        // dslist überschreiben!
        this.setDsliste(hlist);
        return vergleiche;
    }
}


