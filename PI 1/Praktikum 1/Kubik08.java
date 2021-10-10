/***************************************************************/
/* Verfasser: Gruppe 08                                        */
/* Source   : Kubik08.java                                     */  
/* Zweck    : Kubiktabelle berechnen                           */
/* Stand    : 18.10.2016                                       */
/* Gruppe 8 : Devrim Eker, Lorenz Rosenthal                    */                                        
/***************************************************************/

class Kubik08 {
  public static void main(String args[]) {
    int i;       /* Zaehler fuer Potenz */
    int ug = 1;  /* Untergrenze    */
    int og = 30; /* Obergrenze     */   
    int q;       /* Kubikzahl      */
    int sum = 0; /* Summe der Kubikzahlen */
    
    System.out.println("Tabelle der 3er Potenzen:");
    i = ug;
    while (i <= og) { 
      q = i * i * i;
      sum = sum + q;
      System.out.println(i + "*" + i + "*" + i + "=" + q);
      System.out.println("Kubikzahlsumme = " + sum);
      i = i + 1;
    }
    System.out.println("Ende der Berechnung");
  }
}
