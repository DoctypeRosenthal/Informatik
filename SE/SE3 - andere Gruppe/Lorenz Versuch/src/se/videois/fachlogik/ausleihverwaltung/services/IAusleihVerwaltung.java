package se.videois.fachlogik.ausleihverwaltung.services;

import se.videois.fachlogik.grenzklasen.AusleihQuittung;

public interface IAusleihVerwaltung {
    AusleihQuittung artikelAusleihen(int knr, int anr);
    boolean ausleiheBeenden(int ausleihNr);
}
