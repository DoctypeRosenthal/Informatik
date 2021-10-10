package se.uniis.datenhaltung.db.impl;

import se.uniis.datenhaltung.db.entities.AllePruefungsmeldungen;
import se.uniis.datenhaltung.db.entities.Kurs;
import se.uniis.datenhaltung.db.entities.Pruefungsmeldung;
import se.uniis.datenhaltung.db.entities.Student;
import se.uniis.datenhaltung.db.services.ICRUDPruefmeldung;

public class ICRUDPruefmeldungImpl implements ICRUDPruefmeldung {

    @Override
    public Boolean insertPruefmeld(Pruefungsmeldung p) {
        AllePruefungsmeldungen allepruefmeld = AllePruefungsmeldungen.exemplar();
        Boolean exists = allepruefmeld.containsPruefmeld(p);
        if (exists) {
            return false;}
        else {
            allepruefmeld.addPruefmeld(p);
            Kurs k = p.getKurs();
            k.addMeldung(p);
            Student s = p.getStudent();
            s.addMeldung(p);
            return true;}
    }

    @Override
    public Boolean deletePruefmeld(int id) {
        AllePruefungsmeldungen allepruefmeld = AllePruefungsmeldungen.exemplar();
        Pruefungsmeldung help = allepruefmeld.suchen(id);
        if (help == null) {return false;}
        else { 
            allepruefmeld.delPruefmeld(help);
            Kurs k = help.getKurs();
            k.delMeldung(help);
            Student s = help.getStudent();
            s.delMeldung(help);
            return true;
        }
    }

    @Override
    public Pruefungsmeldung getPruefmeldByID(int id) {
        AllePruefungsmeldungen allepruefmeld = AllePruefungsmeldungen.exemplar();
        return allepruefmeld.suchen(id);
    }

}
