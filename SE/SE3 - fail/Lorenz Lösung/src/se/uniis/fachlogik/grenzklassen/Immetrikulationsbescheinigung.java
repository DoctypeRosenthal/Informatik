package se.uniis.fachlogik.grenzklassen;

public class Immetrikulationsbescheinigung {
    private String name;
    private int matrikelnr;

    public Immetrikulationsbescheinigung(String n, int mnr) {
        this.name = n;
        this.matrikelnr = mnr;
    }

    public String getName() {
        return name;
    }

    public int getMatrikelnr() {
        return matrikelnr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMatrikelnr(int matrikelnr) {
        this.matrikelnr = matrikelnr;
    }
    
    
}
