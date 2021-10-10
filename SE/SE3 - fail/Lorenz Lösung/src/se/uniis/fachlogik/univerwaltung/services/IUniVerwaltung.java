package se.uniis.fachlogik.univerwaltung.services;

import se.uniis.fachlogik.grenzklassen.Pruefungsschein;

public interface IUniVerwaltung {
    public Pruefungsschein pruefungRegistrieren(int kursnr, int mnr, String note);
}
