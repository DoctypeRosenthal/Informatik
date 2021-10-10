package se.uniis.datenhaltung.db.impl;

import se.uniis.datenhaltung.db.entities.AlleStudenten;
import se.uniis.datenhaltung.db.entities.Student;
import se.uniis.datenhaltung.db.services.ICRUDStudent;

public class ICRUDStudentImpl implements ICRUDStudent {

    @Override
    public Boolean insertStudent(Student s) {
        AlleStudenten allestudenten = AlleStudenten.exemplar();
        Boolean exists = allestudenten.containsStudent(s);
        if (exists) {
            return false;}
        else {
            allestudenten.addStudent(s);
            return true;}
    }

    @Override
    public Boolean deleteStudent(int id) {
        AlleStudenten allestudenten = AlleStudenten.exemplar();
        Student help = allestudenten.suchen(id);
        if (help == null) {return false;}
        else { 
            allestudenten.delStudent(help);
                return true;
        }
    }

    @Override
    public Student getStudentByID(int id) {
        AlleStudenten allestudenten = AlleStudenten.exemplar();
        return allestudenten.suchen(id);
    }

}
