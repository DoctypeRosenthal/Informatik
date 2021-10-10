package se.videois.datenhaltung.db.entities;

import java.util.ArrayList;

public class Kunde {
    private String name;
    private String anschrift;
    private int gebjahr;
    private String pernummer;
    private int kundenr;
    private ArrayList<Ausleihvorgang> ausleihen = new ArrayList<Ausleihvorgang>();
	
    public void addAusleih(Ausleihvorgang a){
	ausleihen.add(a);
    }
    
    public void delAusleih(Ausleihvorgang a){
	ausleihen.remove(a);
    }
    
    public Boolean containsAusleih(Ausleihvorgang a){
	return ausleihen.contains(a);
    }

    public Kunde(String name, String anschrift, int gebjahr, String pernummer, int kundenr) {
        this.name = name;
        this.anschrift = anschrift;
        this.gebjahr = gebjahr;
        this.pernummer = pernummer;
        this.kundenr = kundenr;
    }
	
        
    public Kunde() {}
	
    public int getJahr() {
	return gebjahr;
    }
	
    public int getKundenr() {
	return kundenr;
    }

    public String getName() {
        return name;
    }

    public String getAnschrift() {
        return anschrift;
    }

    public int getGebjahr() {
        return gebjahr;
    }

    public String getPernummer() {
        return pernummer;
    }

    public ArrayList<Ausleihvorgang> getAusleih() {
        return ausleihen;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAnschrift(String anschrift) {
        this.anschrift = anschrift;
    }

    public void setGebjahr(int gebjahr) {
        this.gebjahr = gebjahr;
    }

    public void setPernummer(String pernummer) {
        this.pernummer = pernummer;
    }

    public void setKundenr(int kundenr) {
        this.kundenr = kundenr;
    }

    public void setAusleih(ArrayList<Ausleihvorgang> ausleih) {
        this.ausleihen = ausleih;
    }
    
        
   
        
}
