
package se.uniis.datenhaltung.db.services;

import se.uniis.datenhaltung.db.entities.Kurs;

public interface ICRUDKurs {
    public Boolean insertKurs(Kurs k);
    public Boolean deleteKurs(int id);
    public Kurs getKursByID(int id);
}
