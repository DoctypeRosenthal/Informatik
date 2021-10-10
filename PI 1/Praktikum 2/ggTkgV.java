/***************************************************************/
/* Verfasser: Gruppe 8                                         */
/* Source   : ggTkgV.java                                      */  
/* Zweck    : Größten gemeinsamen Teiler und kleinstes 
              gemeinsames Vielfaches von zwei Zahlen berechnen */
/* Stand    : 15.11.2016                                       */
/***************************************************************/

class ggTkgV {
  public static void main(String args[]) {
    int a, b,  // Eingabezahlen
        c, v;  // Ergebnisse
    
    do {
      // wird solange wiederholt, bis User eine Zahl größer 0 eingibt
      System.out.println("Geben Sie eine Zahl > 0 ein");
      a = IO1.einint();
    } while (a <= 0); // end of do-while
    
    
    do {
      // User muss eine Zahl gleich 1 oder a oder dazwischen eingeben
      System.out.println("Geben Sie eine Zahl >= 1 und <= " + a + " ein");
      b = IO1.einint();
    } while (b > a || b < 1);
    
    c = ggT(a, b);
    v = kgV(a, c, b);
    System.out.println("Größter gemeinsamer Teiler der Zahlen ist " + c);
    System.out.println("Kleinstes gemeinsames Vielfaches der Zahlen ist " + v);
    
  }
  
  private static int ggT(int a, int b) {
    // implementiert den Euklidischen Algorithmus 
    int Z; // Divident
    int N; // Divisior
    int r; // Rest der Division
    
    if (a >= b) {
      Z = a;
      N = b;
    } else {
      Z = b;
      N = a;             
    } 
    
    do {
      // berechne den Rest r der Division Z/N
      r = Z % N;
      if (r != 0) {
        Z = N;
        N = r;
      } 
    } while (r > 0); 
    
    return N;
  }
  
  private static int kgV(int a, int b, int c) {
    return (a / b) * c;
  }
  
}