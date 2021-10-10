class Abtast {
  public static void main(String[] args) {
    int i; // Laufindex
    double x; // x-Wert
    double f; // Funktionswert
    
    for (i = 20; i <= 40; i ++) { 
      x = i/10.0;
      f = 20*x*x - 100*x +129.5;
      System.out.println("Funktionswert: " + f + "; Quantisierung: " + (int) f + "; x = " + x);
      if (i == 25) {
        System.out.println("Minimum!");                    
      } // end of if
    } // end of for
  }
  

}