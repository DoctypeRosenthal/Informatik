/***************************************************************/
/* Verfasser: Gruppe 08                                        */
/* Source   : FunktionN08.java                                 */  
/* Zweck    : maxint übersteigen für og > 30                   */
/* Stand    : 18.10.2016                                       */
/* Gruppe 8 : Devrim Eker, Lorenz Rosenthal                    */                                        
/***************************************************************/

class FunktionN08 {
  public static void main(String args[]) {
    int i = 1;     /* Laufvar. */
    int og = 20;   /* Obergrenze     */   
    int f = 1;     /* Funktionswert      */
    
    System.out.println("Berechnung einer endlichen Zahlenfolge");
    System.out.println("f" + i + " = 1");
    while (i < og) { 
      i = i + 1;
      f = 2 * ( f - 1 ) + 4;
      System.out.println("f" + i + " = " + f);
    }
    System.out.println("Ende der Berechnung");
  }
}
