package se.videois.datenhaltung.db.impl;

import se.videois.datenhaltung.db.entities.AlleArtikel;
import se.videois.datenhaltung.db.entities.Artikel;
import se.videois.datenhaltung.db.services.ICRUDArtikel;

public class ICRUDArtikelImpl implements ICRUDArtikel {

    @Override
    public Boolean insertArtikel(Artikel a) {
       AlleArtikel alleartikel = AlleArtikel.exemplar();
        Boolean exists = alleartikel.containsArtikel(a);
        if (exists) {
            return false;}
        else {
            alleartikel.addArtikel(a);
            return true;}
    }

    @Override
    public Boolean deleteArtikel(int id) {
        AlleArtikel alleartikel = AlleArtikel.exemplar();
        Artikel help = alleartikel.suchen(id);
        if (help == null) {return false;}
        else { 
            alleartikel.delArtikel(help);
                return true;
        }
    }

    @Override
    public Artikel getArtikelByID(int id) {
        AlleArtikel alleartikel = AlleArtikel.exemplar();
        return alleartikel.suchen(id);
    }

}
