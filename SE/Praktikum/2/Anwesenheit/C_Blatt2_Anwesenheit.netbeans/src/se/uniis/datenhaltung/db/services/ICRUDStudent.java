/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.uniis.datenhaltung.db.services;

import se.uniis.datenhaltung.db.entities.Student;

/**
 *
 * @author user
 */
public interface ICRUDStudent {
    public boolean createStudent(Student student);
    public Student readStudent(int matrikelnr);
        
}
