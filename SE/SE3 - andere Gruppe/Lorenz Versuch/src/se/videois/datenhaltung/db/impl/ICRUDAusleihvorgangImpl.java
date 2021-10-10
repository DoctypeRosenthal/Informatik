package se.videois.datenhaltung.db.impl;

import se.videois.datenhaltung.db.entities.AlleAusleihvorgaenge;
import se.videois.datenhaltung.db.entities.Artikel;
import se.videois.datenhaltung.db.entities.Ausleihvorgang;
import se.videois.datenhaltung.db.entities.Kunde;
import se.videois.datenhaltung.db.services.ICRUDAusleihvorgang;

public class ICRUDAusleihvorgangImpl implements ICRUDAusleihvorgang {

    @Override
    public Boolean insertAusleihvorgang(Ausleihvorgang a) {
        AlleAusleihvorgaenge alleausleihen = AlleAusleihvorgaenge.exemplar();
        Boolean exists = alleausleihen.containsAusleihvorgang(a);
        if (exists) {
            return false;}
        else {
            alleausleihen.addAusleihvorgang(a);
            Artikel art = a.getArtikel();
            art.addAusleih(a);
            Kunde kun = a.getKunde();
            kun.addAusleih(a);
            return true;}
    }

    @Override
    public Boolean deleteAusleihvorgang(int id) {
        AlleAusleihvorgaenge alleausleihen = AlleAusleihvorgaenge.exemplar();
        Ausleihvorgang a = alleausleihen.suchen(id);
        if (a == null) {return false;}
        else { 
            alleausleihen.delAusleihvorgang(a);
            Artikel art = a.getArtikel();
            art.delAusleih(a);
            Kunde kun = a.getKunde();
            kun.delAusleih(a);
            return true;
        }
    }

    @Override
    public Ausleihvorgang getAusleihvorgangByID(int id) {
        AlleAusleihvorgaenge alleausleihen = AlleAusleihvorgaenge.exemplar();
        return alleausleihen.suchen(id);
    }

}
