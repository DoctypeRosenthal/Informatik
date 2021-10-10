package se.uniis.fachlogik.univerwaltung.impl;

import se.uniis.datenhaltung.db.entities.Kurs;
import se.uniis.datenhaltung.db.entities.Pruefungsmeldung;
import se.uniis.datenhaltung.db.entities.Student;
import se.uniis.datenhaltung.db.impl.ICRUDKursImpl;
import se.uniis.datenhaltung.db.impl.ICRUDPruefmeldungImpl;
import se.uniis.datenhaltung.db.impl.ICRUDStudentImpl;
import se.uniis.fachlogik.grenzklassen.Pruefungsschein;
import se.uniis.fachlogik.univerwaltung.services.IUniVerwaltung;

/**
 * IUniVerwaltungImpl
 * @author Gruppe 42
 * @version 1.0
 */
public class IUniVerwaltungImpl implements IUniVerwaltung {

    /**
     * Erstellt einen Pruefungschein
     * /LF20/ Prüfungsergebnis registrieren
     * @param kursnr Kursnummer des Kurses
     * @param mnr Matrikelnummer des Studenten
     * @param note Einzutragene Note
     * @return Pruefungsschein
     */
    @Override
    public Pruefungsschein pruefungRegistrieren(int kursnr, int mnr, String note) {
        ICRUDKursImpl crudKurs = new ICRUDKursImpl();
        Kurs kurs = crudKurs.getKursByID(kursnr);
        ICRUDStudentImpl crudStudent = new ICRUDStudentImpl();
        Student student = crudStudent.getStudentByID(mnr);
        if (!kurs.containsStudent(student))
            return null;    
        Pruefungsmeldung pruefmeld = new Pruefungsmeldung(kurs, student, "1.1.1984", mnr, note);
        ICRUDPruefmeldungImpl crudPruefmeld = new ICRUDPruefmeldungImpl();
        crudPruefmeld.insertPruefmeld(pruefmeld);
        Pruefungsschein pruefschein = new Pruefungsschein(kursnr, "1.1.1984", note, mnr);
        kurs.delStudent(student);
        student.delKurs(kurs);
        return pruefschein;
    }
    
}
