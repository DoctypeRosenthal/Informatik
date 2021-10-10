package se.uniis.datenhaltung.db.entities;

import java.util.ArrayList;

public class AlleStudenten {
    private static AlleStudenten einzigesexemplar;
    
    private ArrayList<Student> studenten;

    private AlleStudenten() {
        this.studenten = new ArrayList<Student>();
    }
    
    public static AlleStudenten exemplar() {
        if (einzigesexemplar == null) {
            AlleStudenten as = new AlleStudenten();
            einzigesexemplar = as;
        }
        return einzigesexemplar;
    }
    
     public void addStudent (Student s) {
        studenten.add(s);
    }
    
    public void delStudent (Student s) {
        studenten.remove(s);
    }
    
    public Boolean containsStudent (Student s) {
        return studenten.contains(s);
    }
    
    public Student suchen (int matrikelnr){
        Student ret = null;
        for (Student s : studenten) {
            if (s.getMatrikelnr() == matrikelnr) {
                ret = s;}
            }
        return ret;
        }
    
}
