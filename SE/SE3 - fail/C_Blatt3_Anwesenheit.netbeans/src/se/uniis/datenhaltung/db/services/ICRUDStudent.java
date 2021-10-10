
package se.uniis.datenhaltung.db.services;

import se.uniis.datenhaltung.db.entities.Student;

public interface ICRUDStudent {
    public Boolean insertStudent(Student s);
    public Boolean deleteStudent(int id);
    public Student getStudentByID(int id);
}
