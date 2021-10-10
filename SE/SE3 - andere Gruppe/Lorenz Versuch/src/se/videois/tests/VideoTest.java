package se.videois.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import se.videois.datenhaltung.db.entities.Artikel;
import se.videois.datenhaltung.db.entities.Ausleihvorgang;
import se.videois.datenhaltung.db.entities.Kunde;
import se.videois.datenhaltung.db.impl.ICRUDArtikelImpl;
import se.videois.datenhaltung.db.impl.ICRUDAusleihvorgangImpl;
import se.videois.datenhaltung.db.impl.ICRUDKundeImpl;
import se.videois.datenhaltung.db.services.ICRUDArtikel;
import se.videois.datenhaltung.db.services.ICRUDAusleihvorgang;
import se.videois.datenhaltung.db.services.ICRUDKunde;
import se.videois.fachlogik.ausleihverwaltung.impl.IAusleihVerwaltungImpl;
import se.videois.fachlogik.ausleihverwaltung.services.IAusleihVerwaltung;
import org.junit.*;
import se.videois.fachlogik.grenzklasen.AusleihQuittung;

import static org.junit.Assert.*;

public class VideoTest {

    private static IAusleihVerwaltung iAusleihVerwaltung = new IAusleihVerwaltungImpl();
    private static ICRUDAusleihvorgang icrudAusleihvorgang = new ICRUDAusleihvorgangImpl();
    private static ICRUDArtikel icrudArtikel = new ICRUDArtikelImpl();
    private static ICRUDKunde icrudKunde = new ICRUDKundeImpl();
    private static final int ARTIKEL_NR = 1;
    private static final int KIND_NR = 1;
    private static final int ERWACHSEN_NR = 2;

    @BeforeClass
    public static void init() {
        // Erwachsenenfilm erzeugen
        Artikel artikel = new Artikel(true, ARTIKEL_NR, "Köln", 18, 100);
        Kunde kind = new Kunde("Paul", "Köln", 2005, "bla", KIND_NR);
        Kunde erwachsen = new Kunde("Dieter", "Köln", 1980, "bla", ERWACHSEN_NR);
        icrudArtikel.insertArtikel(artikel);
        icrudKunde.insertKunde(kind);
        icrudKunde.insertKunde(erwachsen);
    }

    @After
    @Test
    public void ausleiheBeenden() {
        iAusleihVerwaltung.ausleiheBeenden(28);
    }

    @Test
    public void ausleiheFail() {
        // Kind leiht aus
        AusleihQuittung ausleihQuittung = iAusleihVerwaltung.artikelAusleihen(KIND_NR, ARTIKEL_NR);
        assertNull(ausleihQuittung);
        assertNull(icrudAusleihvorgang.getAusleihvorgangByID(28));
        assertTrue(icrudArtikel.getArtikelByID(1).isVerfuegbar());
    }

    @Test
    public void ausleiheErfolg() {
        // Erwachsener leiht aus
        AusleihQuittung ausleihQuittung = iAusleihVerwaltung.artikelAusleihen(ERWACHSEN_NR, ARTIKEL_NR);
        assertNotNull(ausleihQuittung);
        Ausleihvorgang ausleihvorgang = icrudAusleihvorgang.getAusleihvorgangByID(28);
        assertNotNull(ausleihvorgang);
        assertEquals(ausleihvorgang.getBeginn(), "15.01.18");
        assertEquals(ausleihvorgang.getEnde(), "20.01.18");
        assertEquals(ausleihvorgang.getKunde().getKundenr(), ERWACHSEN_NR);
        assertFalse(icrudArtikel.getArtikelByID(1).isVerfuegbar());
    }
}