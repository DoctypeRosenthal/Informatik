/***************************************************************/
/* Verfasser: Gruppe 08                                        */
/* Source   : FunktionY08.java                                 */  
/* Zweck    : Endliche Zahlenfolge berechnen                   */
/* Stand    : 18.10.2016                                       */
/* Gruppe 8 : Devrim Eker, Lorenz Rosenthal                    */                                        
/***************************************************************/

class FunktionY08 {
  public static void main(String args[]) {
    int a = -1;            
    int b = 3;
    int ug = -(a + b + 1); /* Untergrenze    */
    int og = a + b + 1;    /* Obergrenze     */   
    int y;                 /* Funktionswert  */
    int x;                 /* Zaehler */
    
    System.out.println("Funktionswerte:");
    x = ug;
    while (x <= og) { 
      y = (x - a) * (x * x - b * b);
      System.out.println("für x = " + x + " ist y = " + y);
      x = x + 1;
    }
    System.out.println("Ende der Berechnung");
  }
}
