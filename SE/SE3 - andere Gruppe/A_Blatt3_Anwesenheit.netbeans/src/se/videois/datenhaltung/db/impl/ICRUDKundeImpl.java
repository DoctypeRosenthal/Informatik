package se.videois.datenhaltung.db.impl;

import se.videois.datenhaltung.db.entities.AlleKunden;
import se.videois.datenhaltung.db.entities.Kunde;
import se.videois.datenhaltung.db.services.ICRUDKunde;

public class ICRUDKundeImpl implements ICRUDKunde {

    @Override
    public Boolean insertKunde(Kunde k) {
        AlleKunden allekunden = AlleKunden.exemplar();
        Boolean exists = allekunden.containsKunde(k);
        if (exists) {
            return false;}
        else {
            allekunden.addKunde(k);
            return true;}
    }

    @Override
    public Boolean deleteKunde(int id) {
         AlleKunden allekunden = AlleKunden.exemplar();
        Kunde help = allekunden.suchen(id);
        if (help == null) {return false;}
        else { 
            allekunden.delKunde(help);
                return true;
        }
    }

    @Override
    public Kunde getKundeByID(int id) {
         AlleKunden allekunden = AlleKunden.exemplar();
        return allekunden.suchen(id);
    }

}
