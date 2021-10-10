package se.videois.fachlogik.ausleihverwaltung.impl;

import se.videois.datenhaltung.db.entities.Artikel;
import se.videois.datenhaltung.db.entities.Ausleihvorgang;
import se.videois.datenhaltung.db.entities.Kunde;
import se.videois.datenhaltung.db.impl.ICRUDArtikelImpl;
import se.videois.datenhaltung.db.impl.ICRUDAusleihvorgangImpl;
import se.videois.datenhaltung.db.impl.ICRUDKundeImpl;
import se.videois.datenhaltung.db.services.ICRUDArtikel;
import se.videois.datenhaltung.db.services.ICRUDAusleihvorgang;
import se.videois.datenhaltung.db.services.ICRUDKunde;
import se.videois.fachlogik.ausleihverwaltung.services.IAusleihVerwaltung;
import se.videois.fachlogik.grenzklasen.AusleihQuittung;

public class IAusleihVerwaltungImpl implements IAusleihVerwaltung {
    private ICRUDKunde icrudKunde = new ICRUDKundeImpl();
    private ICRUDArtikel icrudArtikel = new ICRUDArtikelImpl();
    private ICRUDAusleihvorgang icrudAusleihvorgang = new ICRUDAusleihvorgangImpl();

    /**
     * Aussagekräftiges doc-comment
     *
     * @param knr
     * @param anr
     * @return
     */
    @Override
    public AusleihQuittung artikelAusleihen(int knr, int anr) {
        Kunde kunde = icrudKunde.getKundeByID(knr);
        Artikel artikel = icrudArtikel.getArtikelByID(anr);
        int mindestalter = artikel.getMindestalter();
        int gebJahr = kunde.getGebjahr();
        if (2018 - gebJahr < mindestalter || !artikel.isVerfuegbar()) {
            return null;
        }
        Ausleihvorgang ausleihvorgang = new Ausleihvorgang(kunde, artikel, 28);
        ausleihvorgang.setBeginn("15.01.18");
        ausleihvorgang.setEnde("20.01.18");

        artikel.setVerfuegbar(false);

        icrudAusleihvorgang.insertAusleihvorgang(ausleihvorgang);

        return new AusleihQuittung(knr, anr, "15.01.18", 28);
    }

    /**
     * Aussagekräftiges doc-comment
     *
     * @param ausleihNr
     * @return
     */
    @Override
    public boolean ausleiheBeenden(int ausleihNr) {
        Ausleihvorgang ausleihvorgang = icrudAusleihvorgang.getAusleihvorgangByID(ausleihNr);
        if (ausleihvorgang == null) {
            return false;
        }

        Artikel artikel = ausleihvorgang.getArtikel();
        artikel.setVerfuegbar(true);

        icrudAusleihvorgang.deleteAusleihvorgang(ausleihNr);

        return false;
    }
}
