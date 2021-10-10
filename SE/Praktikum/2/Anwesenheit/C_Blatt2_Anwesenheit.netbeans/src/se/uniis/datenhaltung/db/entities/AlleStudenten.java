/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.uniis.datenhaltung.db.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class AlleStudenten {
    private static AlleStudenten singleton;
    private List<Student> studenten;

    private AlleStudenten() {
        studenten = new ArrayList<Student>();
    }
    
    public static AlleStudenten getInstance() {
        if (singleton == null)
            singleton = new AlleStudenten();
        return singleton;
    }
    
    public void addStudent(Student student) {
        studenten.add(student);
    }
    
    public void deleteStudent(Student student) {
        studenten.remove(student);
    }
    
    public Student searchStudent(int matrikelnr) {
        for (Student student : studenten) {
            if (student.getMatrikelnr() == matrikelnr)
                return student;
        }
        return null;
    }
    
    public boolean containsStudent(Student student) {
        return studenten.contains(student);
    }
}
