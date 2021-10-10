package Praktikum2;

import java.io.Serializable;

public class Maschine implements Serializable {
  protected int manr;

  protected double preis;

  protected String mabez;

  protected String stao;

  private int crt;

  public Maschine(String csv) {
    String[] attr = csv.split(";");
    if (attr.length != 4) {
      this.crt = 2;
      return;
    }

    try {
      if (
              setManr(Integer.parseInt(attr[0]))
                      && setPreis(Double.parseDouble(attr[1]))
                      && setMabez(attr[2])
                      && setStao(attr[3])
              ) {
        this.crt = 1;
      } else {
        this.crt = 2;
      }
    } catch(Exception e) {

      this.crt = 2;
    }
  }

  public String ausMaschCSV() {
    return manr + ";"+ preis + ";" + mabez + ";" + stao;
  }

  public void ausMasch() {
    System.out.println(this.ausMaschCSV());
  }

  double abschreibung(int laufz) throws Exception {
    if (laufz <= 0) throw new Exception();
    double aw = this.preis / laufz;
    return aw;
  }

  public boolean setManr(int nr) {
    if (nr < 1) return false;
    this.manr = nr;
    return true;

  }
  public int getManr() {
    return manr;
  }

  public boolean setPreis (double pr){
    if (pr <= 1) return false;
    this.preis = pr;
    return true;
  }

  public double getPreis() {
    return preis;
  }

  public boolean setMabez (String bez) {
    if (bez.charAt(0) < 'A' || 'Z' < bez.charAt(0)) return false;
    this.mabez = bez;
    return true;
  }

  public String getMabez () {
    return mabez;
  }

  public boolean setStao (String st) {
    if (st.charAt(0) < 'A' || 'Z' < st.charAt(0)) return false;
    this.stao = st;
    return true;
  }

  public String getStao () {
    return stao;
  }

  public int getCrt () {
    return crt;
  }

}
