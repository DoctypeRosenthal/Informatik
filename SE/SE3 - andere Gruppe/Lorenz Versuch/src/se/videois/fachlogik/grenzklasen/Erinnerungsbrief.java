package se.videois.fachlogik.grenzklasen;

public class Erinnerungsbrief {
    String name;
    String anschrift;
    String ausleihdatum;
    int artikelnr;

    public Erinnerungsbrief(String name, String anschrift, String ausleihdatum, int artikelnr) {
        this.name = name;
        this.anschrift = anschrift;
        this.ausleihdatum = ausleihdatum;
        this.artikelnr = artikelnr;
    }

    public String getName() {
        return name;
    }

    public String getAnschrift() {
        return anschrift;
    }

    public String getAusleihdatum() {
        return ausleihdatum;
    }

    public int getArtikelnr() {
        return artikelnr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAnschrift(String anschrift) {
        this.anschrift = anschrift;
    }

    public void setAusleihdatum(String ausleihdatum) {
        this.ausleihdatum = ausleihdatum;
    }

    public void setArtikelnr(int artikelnr) {
        this.artikelnr = artikelnr;
    }
    
    
}
