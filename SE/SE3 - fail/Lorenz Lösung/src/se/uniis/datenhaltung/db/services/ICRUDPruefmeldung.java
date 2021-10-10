
package se.uniis.datenhaltung.db.services;

import se.uniis.datenhaltung.db.entities.Pruefungsmeldung;

public interface ICRUDPruefmeldung {
    public Boolean insertPruefmeld(Pruefungsmeldung p);
    public Boolean deletePruefmeld(int id);
    public Pruefungsmeldung getPruefmeldByID(int id);
}
