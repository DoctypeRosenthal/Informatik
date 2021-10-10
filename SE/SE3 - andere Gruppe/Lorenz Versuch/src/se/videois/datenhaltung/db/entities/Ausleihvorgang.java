package se.videois.datenhaltung.db.entities;

public class Ausleihvorgang {
    private String beginn;
    private String ende;
    private int ausleihnr;
    private Artikel artikel;
    private Kunde kunde;

    public Ausleihvorgang(Kunde kun, Artikel art, int nr) {
        ausleihnr = nr;
        kunde = kun;
        artikel = art;
    }

    public Ausleihvorgang() {
    }

    public int getAusleihnr() {
        return ausleihnr;
    }

    public String getBeginn() {
        return beginn;
    }

    public String getEnde() {
        return ende;
    }

    public Artikel getArtikel() {
        return artikel;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setBeginn(String date) {
        beginn = date;
    }

    public void setEnde(String ende) {
        this.ende = ende;
    }

    public void setAusleihnr(int ausleihnr) {
        this.ausleihnr = ausleihnr;
    }

    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }
}
