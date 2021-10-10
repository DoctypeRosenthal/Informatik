/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.uniis.datenhaltung.db.impl;

import se.uniis.datenhaltung.db.entities.AllePruefungsmeldungen;
import se.uniis.datenhaltung.db.entities.Pruefungsmeldung;
import se.uniis.datenhaltung.db.services.ICRUDPruefungsmeldung;

/**
 *
 * @author user
 */
public class ICRUDPruefungsmeldungImpl implements ICRUDPruefungsmeldung {

    @Override
    public boolean createPruefungsmeldung(Pruefungsmeldung meldung) {
        if (meldung.getStudent() == null)
            return false;
        AllePruefungsmeldungen pruefungsmeldungen = AllePruefungsmeldungen.getInstance();
        if (pruefungsmeldungen.containsPruefungsmeldung(meldung))
            return false;
        pruefungsmeldungen.addPruefungsmeldung(meldung);
        
        return true;
    }

    @Override
    public Pruefungsmeldung readPruefungsmeldung(int meldenr) {
        return AllePruefungsmeldungen.getInstance().searchPruefungsmeldung(meldenr);
    }
    
}
