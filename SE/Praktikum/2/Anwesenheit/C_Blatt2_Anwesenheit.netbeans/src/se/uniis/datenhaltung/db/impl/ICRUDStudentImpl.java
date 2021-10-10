/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.uniis.datenhaltung.db.impl;

import se.uniis.datenhaltung.db.entities.AlleStudenten;
import se.uniis.datenhaltung.db.entities.Student;
import se.uniis.datenhaltung.db.services.ICRUDStudent;

/**
 *
 * @author user
 */
public class ICRUDStudentImpl implements ICRUDStudent {

    @Override
    public boolean createStudent(Student student) {
        AlleStudenten studenten = AlleStudenten.getInstance();
        if (studenten.containsStudent(student))
            return false;
        studenten.addStudent(student);
        
        return true;
    }
        

    @Override
    public Student readStudent(int matrikelnr) {
        return AlleStudenten.getInstance().searchStudent(matrikelnr);
    }
    
}
