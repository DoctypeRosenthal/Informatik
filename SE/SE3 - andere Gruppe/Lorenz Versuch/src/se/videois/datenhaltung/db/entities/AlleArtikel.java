
package se.videois.datenhaltung.db.entities;
import java.util.ArrayList;

public class AlleArtikel {
	private ArrayList<Artikel> artikel = new ArrayList<Artikel>();
	private static AlleArtikel einzigesexemplar;
	
	public static AlleArtikel exemplar() {
		if (einzigesexemplar == null)
			einzigesexemplar = new AlleArtikel();
		return einzigesexemplar;
	}
	
	private AlleArtikel(){}
	
	public void addArtikel(Artikel a){
		artikel.add(a);
	}
        
        public void delArtikel(Artikel a){
		artikel.remove(a);
	}
        
        public Boolean containsArtikel(Artikel a){
		return artikel.contains(a);
	}
	
	public Artikel suchen( int artikelnr) {
            Artikel ret = null;
            for (Artikel a : artikel) {
            if (a.getArtikelnr() == artikelnr) {
                ret = a;}
            }
            return ret;
	}
	
}
