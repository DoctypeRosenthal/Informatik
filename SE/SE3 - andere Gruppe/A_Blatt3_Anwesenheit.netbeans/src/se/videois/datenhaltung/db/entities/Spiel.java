package se.videois.datenhaltung.db.entities;

public class Spiel extends Artikel{
    private int erscheinungsjahr;
    private String system;
    private String titel;
    private String kategorie;
    private String hersteller;

    public Spiel(int erscheinungsjahr, String system, String titel, String kategorie, boolean verfuegbar, int artikelnr, String standort, int mindestalter, int tagespreis) {
        super(verfuegbar, artikelnr, standort, mindestalter, tagespreis);
        this.erscheinungsjahr = erscheinungsjahr;
        this.system = system;
        this.titel = titel;
        this.kategorie = kategorie;
    }

  
    
    public int getErscheinungsjahr() {
        return erscheinungsjahr;
    }

    public String getSystem() {
        return system;
    }

    public String getTitel() {
        return titel;
    }

    public String getKategorie() {
        return kategorie;
    }

    public String getHersteller() {
        return hersteller;
    }

    public void setErscheinungsjahr(int erscheinungsjahr) {
        this.erscheinungsjahr = erscheinungsjahr;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }
    
    
}
