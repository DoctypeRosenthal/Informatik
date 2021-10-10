package se.videois.datenhaltung.db.entities;

import java.util.ArrayList;

public class AlleKunden {
	private ArrayList<Kunde> kunden = new ArrayList<Kunde>();
	private static AlleKunden einzigesexemplar;
	
	public static AlleKunden exemplar() {
			if (einzigesexemplar == null)
				einzigesexemplar = new AlleKunden();
			return einzigesexemplar;
	}
	
	private AlleKunden() {}
	
	public void addKunde(Kunde k){
		kunden.add(k);
	}
        
        public void delKunde(Kunde k) {
            kunden.remove(k);
        }
        
        public Boolean containsKunde(Kunde k) {
            return kunden.contains(k);
        }
	
	public Kunde suchen (int knr) {
            Kunde ret = null;
            for (Kunde k : kunden) {
            if (k.getKundenr() == knr) {
                ret = k;}
            }
            return ret;
	}
}
