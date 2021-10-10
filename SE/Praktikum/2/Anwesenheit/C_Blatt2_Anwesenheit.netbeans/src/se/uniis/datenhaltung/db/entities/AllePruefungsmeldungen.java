/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.uniis.datenhaltung.db.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class AllePruefungsmeldungen {
    private static AllePruefungsmeldungen singleton;
    private List<Pruefungsmeldung> pruefungsmeldungen;

    private AllePruefungsmeldungen() {
        pruefungsmeldungen = new ArrayList<Pruefungsmeldung>();
    }
    
    public static AllePruefungsmeldungen getInstance() {
        if (singleton == null)
            singleton = new AllePruefungsmeldungen();
        return singleton;
    }
    
    public void addPruefungsmeldung(Pruefungsmeldung pruefungsmeldung) {
        pruefungsmeldungen.add(pruefungsmeldung);
    }
    
    public void deletePruefungsmeldung(Pruefungsmeldung pruefungsmeldung) {
        pruefungsmeldungen.remove(pruefungsmeldung);
    }
    
    public Pruefungsmeldung searchPruefungsmeldung(int meldenr) {
        for (Pruefungsmeldung pruefungsmeldung : pruefungsmeldungen) {
            if (pruefungsmeldung.getMeldenr() == meldenr)
                return pruefungsmeldung;
        }
        return null;
    }
    
    public boolean containsPruefungsmeldung(Pruefungsmeldung pruefungsmeldung) {
        return pruefungsmeldungen.contains(pruefungsmeldung);
    }
}
