package se.uniis.datenhaltung.db.entities;

import java.util.ArrayList;

public class Student {
    private String name;
    private String anschrift;
    private int matrikelnr;

    private ArrayList<Pruefungsmeldung> pruefungen;
    private ArrayList<Kurs> kurse;
    
    public Student(String name, String anschrift, int mnr) {
        this.name = name;
        this.anschrift = anschrift;
        this.matrikelnr = mnr;
        pruefungen = new ArrayList<Pruefungsmeldung>();
        kurse = new ArrayList<Kurs>();
    }
    
   
    public void addKurs (Kurs k) {
        kurse.add(k);
    }
    
    public void delKurs (Kurs k) {
        kurse.remove(k);
    }
    
    public Boolean containsKurs (Kurs k) {
        return kurse.contains(k);
    }
    
     public void addMeldung (Pruefungsmeldung p) {
        pruefungen.add(p);
    }
     
     public void delMeldung (Pruefungsmeldung p) {
        pruefungen.remove(p);
    }
     
     public Boolean containsMeldung (Pruefungsmeldung p) {
        return pruefungen.contains(p);
    }
    
    public String getName() {
        return name;
    }

    public String getAnschrift() {
        return anschrift;
    }

    public int getMatrikelnr() {
        return matrikelnr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAnschrift(String anschrift) {
        this.anschrift = anschrift;
    }

    public void setMatrikelnr(int matrikelnr) {
        this.matrikelnr = matrikelnr;
    }
    
    
}
