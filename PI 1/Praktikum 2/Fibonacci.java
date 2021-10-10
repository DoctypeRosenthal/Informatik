/***************************************************************/
/* Verfasser: Gruppe 8                                         */
/* Source   : Fibonacci.java                                   */  
/* Zweck    : Fibonacci-Folge berechnen                        */
/* Stand    : 15.11.2016                                       */
/***************************************************************/

class Fibonacci {
  public static void main ( String args []) {
    int n=1;     // Laufvariable
    int av1=1;   // n-1 Folgenglied
    int av2=1;   // n-2 Folgenglied
    int a;       // n. Folgenglied
    
    System.out.println(n+". Fibonacci-Zahl = "+av1);
    n = n+1;
    System.out.println(n+". Fibonacci-Zahl = "+av1); 
    while (n < 20) { 
      n=n+1;
      
      if (n%2 == 0) {
        a = av1 + av2;
        av1 = av1 + av2;
        System.out.println(n+". Fibonacci-Zahl = "+a);
      } 
      
      if (n % 2 == 1) {   
        a = av1 + av2;                                  
        av2 = av1 + av2;
        System.out.println(n+". Fibonacci-Zahl = "+a);
      }
      
    } 
  }          
}   