package se.uniis.datenhaltung.db.entities;

import java.util.ArrayList;

public class AlleKurse {
    private static AlleKurse einzigesexemplar;
    
    private ArrayList<Kurs> kurse;

    private AlleKurse() {
        this.kurse = new ArrayList<Kurs>();
    }
    
    public static AlleKurse exemplar() {
        if (einzigesexemplar == null) {
            AlleKurse ak = new AlleKurse();
            einzigesexemplar = ak;
        }
        return einzigesexemplar;
    }
    
    public void addKurs (Kurs k) {
        kurse.add(k);
    }
    
    public void delKurs (Kurs k) {
        kurse.remove(k);
    }
    
    public Boolean containsKurs (Kurs k) {
        return kurse.contains(k);
    }
    
    public Kurs suchen (int knr){
        Kurs ret = null;
        for (Kurs k : kurse) {
            if (k.getKursnr() == knr) {
                ret = k;}
            }
        return ret;
        }
    
    
    
}
