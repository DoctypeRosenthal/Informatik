
package se.uniis.fachlogik.univerwaltung.test;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
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

public class UniTesten {
    
    private static Pruefungsschein pruefschein;
    private static final int meldenr = 0;
    private static final int kursnr = 0;
    private static final int matrikelnr = 11116666;
    private static final String note = "1+";
    private static ICRUDKurs crudKurs = new ICRUDKursImpl();
    private static ICRUDStudent crudStudent = new ICRUDStudentImpl();
    private static IUniVerwaltung uniVerwaltung = new IUniVerwaltungImpl();
    private static ICRUDPruefmeldung crudPruefmeldung = new ICRUDPruefmeldungImpl();
    private static Pruefungsmeldung pruefmeldung;
    private static Kurs kurs;
    private static Student student;
            
    public UniTesten() {
    }
    
    @BeforeClass
    public static void erzeugeTestdaten() {
       // Testdaten erzeugen:
       kurs = new Kurs(kursnr, "EKS", "Nissen");
       student = new Student("Kevin", "Chorweiler", matrikelnr);
       kurs.addStudent(student);
       student.addKurs(kurs);
       
       // Testdaten in DB einfügen:
       crudKurs.insertKurs(kurs);
       crudStudent.insertStudent(student);
       
       // Methode aufrufen:
       pruefschein = uniVerwaltung.pruefungRegistrieren(kursnr, meldenr, note);
       
       // erstellte Prüfungsmeldung suchen:
       pruefmeldung = crudPruefmeldung.getPruefmeldByID(meldenr);
    }
    
// Ergebeniss überprüfen:
   
   //====================================================================
   @Test
   public void testPruefmeldung_P1() {
        //Prüfungsschein wurde erstellt und besitzt korrekte Daten
        assertNotNull(pruefschein);
        assertEquals(pruefschein.getKursnr(), kursnr);
        assertEquals(pruefschein.getNote(), note);
        assertEquals(pruefschein.getMeldungsnr(), meldenr);
   }
   
   //====================================================================
        
  //====================================================================      
  @Test
   public void testPruefmeldung_P2() {
        //Prüfungsmeldung ist im System mit korrektem Prüfungsdatum, 
        //korrekter Note und korrekter Meldungsnummer registriert
        assertNotNull(pruefmeldung);
        assertEquals(pruefmeldung.getDatum(), "1.1.1984");
        assertEquals(pruefmeldung.getNote(), note);
        assertEquals(pruefmeldung.getMeldenr(), meldenr);
   }
   
   //====================================================================      
  @Test
   public void testPruefmeldung_P3() {
        //Anmeldung ist bei Student entfernt
        assertFalse(student.containsMeldung(pruefmeldung));
   }
   
   //====================================================================      
  @Test
   public void testPruefmeldung_P4() {
        //Anmeldung ist bei Kurs entfernt
        assertFalse(kurs.containsStudent(student));
   }
        
   //====================================================================
   @Test
   public void testPruefmeldung_P5() {
        //Prüfungsmeldung ist mit Kurs verbunden
        assertTrue(kurs.containsMeldung(pruefmeldung));
   }
       
   //====================================================================
   @Test
   public void testPruefmeldung_P6() {
        //Prüfungsmeldung ist mit Student verbunden
        assertTrue(student.containsMeldung(pruefmeldung));
   }
        
   //====================================================================
   @Test
   public void testPruefmeldung_P7() {
        //Student ist mit Prüfungsmeldung verbunden
        assertSame(pruefmeldung.getStudent(), student);
   }
        
   //====================================================================
   @Test
   public void testPruefmeldung_P8() {
        //Kurs ist mit Prüfungsmeldung verbunden
        assertSame(pruefmeldung.getKurs(), kurs);
    }
}
