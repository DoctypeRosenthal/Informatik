/***************************************************************/
/* Verfasser: Gruppe 08                                        */
/* Source   : KubikAnnäherung.java                             */
/* Zweck    : Approximierung der Kubikwurzel einer Zahl        */
/* Stand    : 4.12.2016                                        */
/* Gruppe 8 : Devrim Eker, Lorenz Rosenthal                    */
/***************************************************************/



class KubikAnnäherung {
    public static void main ( String[] args ) {
        double a;       //Benutzereingabe aus der die Kubikwurzel gezogen werden soll
        double eps;     //Benutzereingabe zur Genauigkeitsschranke
        double xa;      //Hilfsvariable für xn
        double xn;      //Annnäherungswert
        double d;       //Prüft wann die Genauigkeitsschranke erreicht wird
        double v;       //Vergleichswert
        int w;      
        
        do{
          int n = 0;      //Zähler

          System.out.println(" Bitte geben Sie Zahl a ein aus der die Kubikwurzel gezogen werden soll");
          a = IO1.eindouble();

          do {
            System.out.println(" Bitte geben sie die Genauigkeitsschranke eps ein");
            eps = IO1.eindouble();
            } while (eps <= 0);

            xa = a;
            d = eps + 1.;
            xn  = 1.;

            while (d >= eps) {
              xn = (1. / 3. ) * ( 2. * xa + a / ( xa * xa ));
              d = xn - xa;
              d = Math.abs(d);
              xa = xn;
              n = n + 1 ;
            }

        v = Math.pow( a, 1./3. );

        System.out.println(" Ihr Annäherungswert xn = " +xn+ " dieser wurde nach " +n+ " Schleifenschritten berechnet, ein Vergleichswert zu der errechneten Kubikwurzel ist "+v );
        System.out.println(" Wollen Sie noch eine Kubikwurzel ziehen? Ja (1) Nein (2)");
        w = IO1.einint();
    } while (w == 1);
   } 
}