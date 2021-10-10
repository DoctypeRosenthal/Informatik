/***************************************************************/
/* Verfasser: Gruppe 8                                         */
/* Source   : Quersumme.java                                   */  
/* Zweck    : Quersumme einer eingegebenen Zahl berechnen      */
/* Stand    : 15.11.2016                                       */
/***************************************************************/

class Quersumme {
  public static void main(String args[]) {
    int z;        // Eingabe des Benutzers
    int su;       // Summand der Quersumme
    int qsum = 0; // Quersumme
    int q;        // Hilfe zur Quersummenberechnung
    
    System.out.println("Bitte eine Zahl eingeben");
    
    z = IO1.einint();
    
    if (z < 0) {
      // z muss positiv sein
      z = z * -1;
    }
    
    q = z;
    
    do {
      su = q % 10;
      q = q / 10;
      qsum += su;
    } while (q >= 1); 
    
    if (qsum % 3 == 0) {
      System.out.println("Zahl ist durch 3 teilbar");
      if (qsum % 9 == 0) {
        System.out.println("Zahl ist auch durch 9 teilbar");
      } else {
        System.out.println("Zahl ist nicht durch 9 teilbar. Der Rest der Division durch 9 ist " + (qsum % 9));
      }
    } else {
      System.out.println("Zahl ist nicht durch 3 teilbar. Der Rest der Division durch 3 ist " + (qsum % 3)); 
      System.out.println("Zahl ist nicht durch 9 teilbar. Der Rest der Division durch 9 ist " + (qsum % 9)); 
    }
    System.out.println("Die Quersumme der Zahl ist " + qsum);
  }
}