package se.uniis.fachlogik.grenzklassen;

public class Pruefungsschein {
        private int kursnr;
        private String datum;
        private String note;
        private int meldungsnr;

    public Pruefungsschein(int knr, String d, String n, int mnr) {
        this.kursnr = knr;
        this.datum = d;
        this.note = n;
        this.meldungsnr = mnr;
    }

    public int getKursnr() {
        return kursnr;
    }

    public String getDatum() {
        return datum;
    }

    public String getNote() {
        return note;
    }

    public int getMeldungsnr() {
        return meldungsnr;
    }

    public void setKursnr(int kursnr) {
        this.kursnr = kursnr;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setMeldungsnr(int meldungsnr) {
        this.meldungsnr = meldungsnr;
    }
        
    

}
