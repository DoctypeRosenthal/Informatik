package se.uniis.datenhaltung.db.impl;

import se.uniis.datenhaltung.db.entities.AlleKurse;
import se.uniis.datenhaltung.db.entities.Kurs;
import se.uniis.datenhaltung.db.services.ICRUDKurs;

public class ICRUDKursImpl implements ICRUDKurs {

    @Override
    public Boolean insertKurs(Kurs k) {
        AlleKurse allekurse = AlleKurse.exemplar();
        Boolean exists = allekurse.containsKurs(k);
        if (exists) {
            return false;}
        else {
            allekurse.addKurs(k);
            return true;}
    }

    @Override
    public Boolean deleteKurs(int id) {
        AlleKurse allekurse = AlleKurse.exemplar();
        Kurs help = allekurse.suchen(id);
        if (help == null) {return false;}
        else { 
            allekurse.delKurs(help);
                return true;
        }
    }

    @Override
    public Kurs getKursByID(int id) {
        AlleKurse allekurse = AlleKurse.exemplar();
        return allekurse.suchen(id);
    }

}
