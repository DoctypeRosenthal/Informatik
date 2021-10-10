package Praktikum3;

import Praktikum2.Maschine;

class MaschineS extends Maschine implements Comparable {

    MaschineS(String csv) {
        super(csv);
    }

    public int compareTo(Object o) {
        MaschineS m = (MaschineS) o;
        int out = 1; // Standard-Rückgabewert
        if (this.manr == m.getManr() && this.preis == m.getPreis() && (this.mabez.compareTo(m.getMabez()) + this.stao.compareTo(m.getStao()) == 0)) {
            // beide Maschinen sind gleich
            out = 0;
        }
        return out;
    }

}
