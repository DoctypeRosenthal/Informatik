package se.videois.datenhaltung.db.entities;

public class DVD extends Artikel{
    private int erscheinungsjahr;
    private String titel;
    private String regisseur;
    private String genre;

    public DVD(int erscheinungsjahr, String titel, String regisseur, String genre, boolean verfuegbar, int artikelnr, String standort, int mindestalter, int tagespreis) {
        super(verfuegbar, artikelnr, standort, mindestalter, tagespreis);
        this.erscheinungsjahr = erscheinungsjahr;
        this.titel = titel;
        this.regisseur = regisseur;
        this.genre = genre;
    }
	
    

    public int getErscheinungsjahr() {
        return erscheinungsjahr;
    }

    public String getTitel() {
        return titel;
    }

    public String getRegisseur() {
        return regisseur;
    }

    public String getGenre() {
        return genre;
    }

    public void setErscheinungsjahr(int erscheinungsjahr) {
        this.erscheinungsjahr = erscheinungsjahr;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setRegisseur(String regisseur) {
        this.regisseur = regisseur;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    
}
