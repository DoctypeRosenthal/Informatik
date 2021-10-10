package se.uniis.test;

import org.junit.BeforeClass;
import org.junit.Test;
import se.uniis.datenhaltung.db.entities.Kurs;
import se.uniis.datenhaltung.db.entities.Pruefungsmeldung;
import se.uniis.datenhaltung.db.entities.Student;
import se.uniis.datenhaltung.db.impl.ICRUDKursImpl;
import se.uniis.datenhaltung.db.impl.ICRUDPruefmeldungImpl;
import se.uniis.datenhaltung.db.impl.ICRUDStudentImpl;
import se.uniis.datenhaltung.db.services.ICRUDKurs;
import se.uniis.datenhaltung.db.services.ICRUDPruefmeldung;
import se.uniis.datenhaltung.db.services.ICRUDStudent;
import se.uniis.fachlogik.grenzklassen.Pruefungsschein;
import se.uniis.fachlogik.univerwaltung.impl.IUniVerwaltungImpl;
import se.uniis.fachlogik.univerwaltung.services.IUniVerwaltung;

import static org.junit.Assert.*;

public class UniTesten {

    final static ICRUDKurs crudKurs = new ICRUDKursImpl();
    final static ICRUDStudent crudStudent = new ICRUDStudentImpl();
    final static ICRUDPruefmeldung crudPruefmeld = new ICRUDPruefmeldungImpl();
    final static IUniVerwaltung iUniVerwaltung = new IUniVerwaltungImpl();
    final static int MATRIKEL_NR = 111222;
    final static int MELDUNGS_NR = 1;
    final static int KURS_NR = 1;
    final static String NOTE = "1";
    final static String DATUM = "1.1.1984";

    @BeforeClass
    public static void init() {
        // create student
        Student student = new Student("Heinz", "Köln", MATRIKEL_NR);
        Kurs kurs = new Kurs(KURS_NR, "SE", "Nissen");

        student.addKurs(kurs);
        kurs.addStudent(student);

        crudStudent.insertStudent(student);
        crudKurs.insertKurs(kurs);
    }

    @Test
    public void pruefungRegistrierenErfolg() {
        Pruefungsschein pruefungsschein = iUniVerwaltung.pruefungRegistrieren(KURS_NR, MATRIKEL_NR, NOTE);
        assertNotNull(pruefungsschein); // 1
        assertEquals(pruefungsschein.getKursnr(), KURS_NR); // 1
        assertEquals(pruefungsschein.getNote(), NOTE); // 1

        Pruefungsmeldung pruefungsmeldung = crudPruefmeld.getPruefmeldByID(MELDUNGS_NR);
        assertNotNull(pruefungsmeldung); // 2
        assertEquals(pruefungsmeldung.getDatum(), DATUM); // 2
        assertEquals(pruefungsmeldung.getNote(), NOTE); // 2

        Student student = crudStudent.getStudentByID(MATRIKEL_NR);
        Kurs kurs = crudKurs.getKursByID(KURS_NR);
        assertFalse(student.containsKurs(kurs));  // 3
        assertFalse(kurs.containsStudent(student));  // 4

        assertEquals(pruefungsmeldung.getKurs(), kurs);  // 5
        assertEquals(pruefungsmeldung.getStudent(), student);  // 6

        assertTrue(student.containsMeldung(pruefungsmeldung)); // 7
        assertTrue(kurs.containsMeldung(pruefungsmeldung));  // 8
    }
}