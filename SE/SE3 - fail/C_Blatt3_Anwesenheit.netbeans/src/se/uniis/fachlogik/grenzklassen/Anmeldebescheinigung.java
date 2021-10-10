package se.uniis.fachlogik.grenzklassen;

public class Anmeldebescheinigung {
    private int matrikelnr;
    private int kursnr;
    private String datum;

    public Anmeldebescheinigung(int mnr, int knr, String d) {
        this.matrikelnr = mnr;
        this.kursnr = knr;
        this.datum = d;
    }

    public int getMatrikelnr() {
        return matrikelnr;
    }

    public int getKursnr() {
        return kursnr;
    }

    public String getDatum() {
        return datum;
    }

    public void setMatrikelnr(int matrikelnr) {
        this.matrikelnr = matrikelnr;
    }

    public void setKursnr(int kursnr) {
        this.kursnr = kursnr;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }
    
    
}
