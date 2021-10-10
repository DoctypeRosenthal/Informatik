/***************************************************************/
/* Verfasser: Prof. Dr. Gregor Büchel                          */
/* Source : IO1.java                                           */
/* Containerklasse mit Eingabemethoden fuer die Datentypen int,*/
/* double, char und für Instanzen der Klasse String            */
/* Stand: 16.12.2003                                           */
/***************************************************************/

import java.io.*;

class IO1
{public static int einint()
 { int w=-999999, rc;
   BufferedReader in
        = new BufferedReader(new InputStreamReader(System.in));
   do
   { rc=0;     //Fehlervermutung
     try
     { w=Integer.valueOf(in.readLine().trim()).intValue();
       rc=1;   //kein Fehler <=> rc=1
     }
     catch(IOException e)
     { System.out.println("Schwerer Inputfehler: "+e.getMessage());
       System.out.println("Bitte korrekten Integerwert eingeben:");
     }
     catch(NumberFormatException g)
     { System.out.println("Inputfehler: "+g.getMessage());
       System.out.println("Bitte korrekten Integerwert eingeben:");
     }
   } while (rc==0);
   return w;
 }
 
 public static double eindouble()
 { int rc;
   double w=-99999999999999.99999;
   BufferedReader in
        = new BufferedReader(new InputStreamReader(System.in));
   do
   { rc=0;     //Fehlervermutung
     try
     { w=Double.valueOf(in.readLine().trim()).doubleValue();
       rc=1;   //kein Fehler <=> rc=1
     }
     catch(IOException e)
     { System.out.println("Schwerer Inputfehler: "+e.getMessage());
       System.out.println("Bitte korrekten Doublewert eingeben:");
     }
     catch(NumberFormatException g)
     { System.out.println("Inputfehler: "+g.getMessage());
       System.out.println("Bitte korrekten Doublewert eingeben:");
     }
   } while (rc==0);
   return w;
 }

 public static String einstring()
 { int rc;
   String st1= new String();
   BufferedReader in
        = new BufferedReader(new InputStreamReader(System.in));
   do
   { rc=0;     //Fehlervermutung
     try
     { st1=in.readLine().trim();
       rc=1;   //kein Fehler <=> rc=1
     }
     catch(IOException e)
     { System.out.println("Schwerer Inputfehler: "+e.getMessage());
       System.out.println("Bitte korrekten Stringwert eingeben:");
     }
     
   } while (rc==0);
   return st1;
 }

 public static char einchar()
 { char x='#';  /* Initialisierung */
   int rc;
   String st1= new String();
   BufferedReader in
        = new BufferedReader(new InputStreamReader(System.in));
   do
   { rc=0;     //Fehlervermutung
     try
     { st1=in.readLine();
       if (st1.length()>0)
       { x=st1.toCharArray()[0];
         rc=1;
       }
       else
       { System.out.println("Achtung: Laenge("+st1+")="+st1.length());
         System.out.println("Bitte nur LOWER-CASE-Zeichen von der Tastatur eingeben!");
       }  
     }
     catch(IOException e)
     { System.out.println("Schwerer Inputfehler: "+e.getMessage());
       System.out.println("Bitte korrekten Stringwert eingeben:");
     }
     
   } while (rc==0);
   return x;
 }


 public static String estrOt()
 { /* wie Methode einstring() , aber ohne trim() des Eingabestrings */
   int rc;
   String st1= new String();
   BufferedReader in
        = new BufferedReader(new InputStreamReader(System.in));
   do
   { rc=0;     //Fehlervermutung
     try
     { st1=in.readLine();
       rc=1;   //kein Fehler <=> rc=1
     }
     catch(IOException e)
     { System.out.println("Schwerer Inputfehler: "+e.getMessage());
       System.out.println("Bitte korrekten Doublewert eingeben:");
     }
     
   } while (rc==0);
   return st1;
 }
}