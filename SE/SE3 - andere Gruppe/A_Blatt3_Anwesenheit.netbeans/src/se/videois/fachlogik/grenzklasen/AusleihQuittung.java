package se.videois.fachlogik.grenzklasen;


import java.util.Date;

public class AusleihQuittung {
	private int kundennr;
	private int artikelnr;
	private int ausleihnr;
	private String ausleihdatum;
	
	public AusleihQuittung(int knr, int anr, String dat, int nr) {
		kundennr = knr;
		artikelnr = anr;
		ausleihdatum = dat;
                ausleihnr = nr;
	}
	
	public AusleihQuittung() {}

    public int getKundennr() {
        return kundennr;
    }

    public int getArtikelnr() {
        return artikelnr;
    }

    public int getAusleihnr() {
        return ausleihnr;
    }

    public String getAusleihdatum() {
        return ausleihdatum;
    }

    public void setKundennr(int kundennr) {
        this.kundennr = kundennr;
    }

    public void setArtikelnr(int artikelnr) {
        this.artikelnr = artikelnr;
    }

    public void setAusleihnr(int ausleihnr) {
        this.ausleihnr = ausleihnr;
    }

    public void setAusleihdatum(String ausleihdatum) {
        this.ausleihdatum = ausleihdatum;
    }
    
    
	
}
