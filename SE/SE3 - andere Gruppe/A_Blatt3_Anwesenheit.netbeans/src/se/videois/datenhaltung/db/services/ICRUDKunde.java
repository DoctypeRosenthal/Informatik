package se.videois.datenhaltung.db.services;

import se.videois.datenhaltung.db.entities.Kunde;

public interface ICRUDKunde {
    public Boolean insertKunde (Kunde k);
    public Boolean deleteKunde (int id);
    public Kunde getKundeByID (int id);
}
