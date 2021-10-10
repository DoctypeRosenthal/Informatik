package se.uniis.datenhaltung.db.entities;

import java.util.ArrayList;

public class Kurs {
    private int kursnr;
    private String titel;
    private String dozent;

    private ArrayList<Pruefungsmeldung> meldungen;
    private ArrayList<Student> angemeldet;
    
    public Kurs(int knr, String t, String d) {
        this.kursnr = knr;
        this.titel = t;
        this.dozent = d;
        meldungen = new ArrayList<Pruefungsmeldung>();
        angemeldet = new ArrayList<Student>();
    }
    
     public void addStudent (Student s) {
        angemeldet.add(s);
    }
    
      public void delStudent (Student s) {
        angemeldet.remove(s);
    }
      
    public Boolean containsStudent (Student s) {
        return angemeldet.contains(s);
    }
    
    public void addMeldung (Pruefungsmeldung p) {
        meldungen.add(p);
    }
    
     public void delMeldung (Pruefungsmeldung p) {
        meldungen.remove(p);
    }
     
      public Boolean containsMeldung (Pruefungsmeldung p) {
        return meldungen.contains(p);
    }
    
    public int getKursnr() {
        return kursnr;
    }

    public String getTitel() {
        return titel;
    }

    public String getDozent() {
        return dozent;
    }

    public void setKursnr(int kursnr) {
        this.kursnr = kursnr;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setDozent(String dozent) {
        this.dozent = dozent;
    }
    
}
