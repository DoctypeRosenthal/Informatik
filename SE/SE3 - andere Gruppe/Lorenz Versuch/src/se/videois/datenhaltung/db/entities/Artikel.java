package se.videois.datenhaltung.db.entities;

import java.util.ArrayList;


public class Artikel {
  private boolean verfuegbar;
  private int artikelnr;
  private String standort;
  private int mindestalter;
  private int tagespreis;
  private ArrayList ausleihen = new ArrayList();
 
    public void addAusleih(Ausleihvorgang a) {
	 ausleihen.add(a);
    }
    
    public void delAusleih(Ausleihvorgang a) {
	 ausleihen.add(a);
    }
    
    public Boolean containsAusleih(Ausleihvorgang a) {
	 return ausleihen.contains(a);
    }

    public Artikel(boolean verfuegbar, int artikelnr, String standort, int mindestalter, int tagespreis) {
        this.verfuegbar = verfuegbar;
        this.artikelnr = artikelnr;
        this.standort = standort;
        this.mindestalter = mindestalter;
        this.tagespreis = tagespreis;
    }
 
 
    public Artikel(){}
 
    public int getMindestalter() {
	 return mindestalter;
    }
 
    public int getTagespreis() {
	 return tagespreis;
    }
 
    public int getArtikelnr() {
	 return artikelnr;
    }

    public String getStandort() {
        return standort;
    }

    public ArrayList getAusleih() {
        return ausleihen;
    }

 
    public void setArtikelnr(int artikelnr) {
        this.artikelnr = artikelnr;
    }

    public void setStandort(String standort) {
        this.standort = standort;
    }

    public void setMindestalter(int mindestalter) {
        this.mindestalter = mindestalter;
    }

    public void setTagespreis(int tagespreis) {
        this.tagespreis = tagespreis;
    }

    
 public void setVerfuegbar(boolean v){
	 verfuegbar = v;
 }

 public boolean isVerfuegbar() {
        return verfuegbar;
    }
 
}
