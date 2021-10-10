package se.videois.datenhaltung.db.entities;

import java.util.ArrayList;

public class AlleAusleihvorgaenge {
    private ArrayList<Ausleihvorgang> ausleihen = new ArrayList<Ausleihvorgang>();
	private static AlleAusleihvorgaenge einzigesexemplar;
	
	public static AlleAusleihvorgaenge exemplar() {
		if (einzigesexemplar == null)
			einzigesexemplar = new AlleAusleihvorgaenge();
		return einzigesexemplar;
	}
	
	private AlleAusleihvorgaenge(){}
	
	public void addAusleihvorgang(Ausleihvorgang a){
		ausleihen.add(a);
	}
        
        public void delAusleihvorgang(Ausleihvorgang a){
		ausleihen.remove(a);
	}
        
        public Boolean containsAusleihvorgang(Ausleihvorgang a){
		return ausleihen.contains(a);
	}
	
	public Ausleihvorgang suchen( int ausleihnr) {
            Ausleihvorgang ret = null;
            for (Ausleihvorgang a : ausleihen) {
            if (a.getAusleihnr() == ausleihnr) {
                ret = a;}
            }
            return ret;
	}
	
}
