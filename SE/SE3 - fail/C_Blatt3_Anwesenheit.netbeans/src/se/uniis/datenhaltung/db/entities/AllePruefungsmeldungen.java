package se.uniis.datenhaltung.db.entities;

import java.util.ArrayList;

public class AllePruefungsmeldungen {
    private static AllePruefungsmeldungen einzigesexemplar;
    
    private ArrayList<Pruefungsmeldung> meldungen;

    private AllePruefungsmeldungen() {
        this.meldungen = new ArrayList<Pruefungsmeldung>();
    }
    
     public static AllePruefungsmeldungen exemplar() {
        if (einzigesexemplar == null) {
            AllePruefungsmeldungen as = new AllePruefungsmeldungen();
            einzigesexemplar = as;
        }
        return einzigesexemplar;
    }
    
    public void addPruefmeld (Pruefungsmeldung p) {
        meldungen.add(p);
    }
    
    public void delPruefmeld (Pruefungsmeldung p) {
        meldungen.remove(p);
    }
    
    public Boolean containsPruefmeld (Pruefungsmeldung p) {
        return meldungen.contains(p);
    }
    
    public Pruefungsmeldung suchen (int meldenr){
        Pruefungsmeldung ret = null;
        for (Pruefungsmeldung pm : meldungen) {
            if (pm.getMeldenr() == meldenr) {
                ret = pm;}
            }
        return ret;
        }
    
}
