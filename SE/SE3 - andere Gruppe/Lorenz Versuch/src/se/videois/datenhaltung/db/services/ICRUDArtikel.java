package se.videois.datenhaltung.db.services;

import se.videois.datenhaltung.db.entities.Artikel;
import se.videois.datenhaltung.db.entities.DVD;
import se.videois.datenhaltung.db.entities.Spiel;

public interface ICRUDArtikel {
    public Boolean insertArtikel(Artikel a);
    public Boolean deleteArtikel(int id);
    public Artikel getArtikelByID(int id);
}
