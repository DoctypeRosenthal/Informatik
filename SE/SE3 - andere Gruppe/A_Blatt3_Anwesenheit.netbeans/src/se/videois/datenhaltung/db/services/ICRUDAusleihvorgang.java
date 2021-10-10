package se.videois.datenhaltung.db.services;

import se.videois.datenhaltung.db.entities.Ausleihvorgang;

public interface ICRUDAusleihvorgang {
    public Boolean insertAusleihvorgang (Ausleihvorgang a);
    public Boolean deleteAusleihvorgang (int id);
    public Ausleihvorgang getAusleihvorgangByID (int id);
}
