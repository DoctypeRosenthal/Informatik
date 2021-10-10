package se.videois.datenhaltung.db.entities;

public class CD extends Artikel{
    private String genre;
    private int erscheinungsjahr;
    private String interpret;
    private String titel;

    public CD(String genre, int erscheinungsjahr, String interpret, String titel, boolean verfuegbar, int artikelnr, String standort, int mindestalter, int tagespreis) {
        super(verfuegbar, artikelnr, standort, mindestalter, tagespreis);
        this.genre = genre;
        this.erscheinungsjahr = erscheinungsjahr;
        this.interpret = interpret;
        this.titel = titel;
    }
		
   
    public String getGenre() {
        return genre;
    }

    public int getErscheinungsjahr() {
        return erscheinungsjahr;
    }

    public String getInterpret() {
        return interpret;
    }

    public String getTitel() {
        return titel;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setErscheinungsjahr(int erscheinungsjahr) {
        this.erscheinungsjahr = erscheinungsjahr;
    }

    public void setInterpret(String interpret) {
        this.interpret = interpret;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }
    
    
}
