package se.uniis.datenhaltung.db.entities;

public class Pruefungsmeldung {
    private String datum;
    private int meldenr;
    private String note;
    private Kurs kurs;
    private Student student;
    
    public Pruefungsmeldung (Kurs kurs, Student student, String datum, int meldenr, String note) {
        this.datum = datum;
        this.meldenr = meldenr;
        this.note = note;
        this.kurs = kurs;
        this.student =student;
    }
    
    public Kurs getKurs() {
        return kurs;
    }

    public Student getStudent() {
        return student;
    }
    
    
    public String getDatum() {
        return datum;
    }

    public int getMeldenr() {
        return meldenr;
    }

    public String getNote() {
        return note;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public void setMeldenr(int meldenr) {
        this.meldenr = meldenr;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    
}
