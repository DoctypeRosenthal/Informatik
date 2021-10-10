import java.util.*;
import java.io.*;

class MaschAnw {
  
  public static void main(String[] args) {
    Maschine ma1 = new Maschine();
  
    ma1.ausMasch();
  
    System.out.println("------------------------------------------------");
    
    String[] mas = maschGeber();
  // erzeuge Liste von Maschinen
    LinkedList<Maschine> malist = new LinkedList<Maschine>();
    for (int i = 0; i < mas.length; i++) {
      Maschine ma = new Maschine(mas[i]);
      if (ma.getCrt() == 2) {
        System.out.println("Fehlerhafte Eingabe an Stelle " + (i + 1));
      } else {
        ma.ausMasch();
        malist.add(ma);
      }
    }
  
  // Abschreibung berechnen
  abschreibungBerechnen(malist);
  
  // in Datei schreiben
  write2Dat(malist);
  
  // Datei auslesen und bearbeiten lassen...
  MaschDV.main();
  
  }
  
  static void write2Dat(LinkedList<Maschine> malist) {
    // Alle Maschinen in Datei schreiben  
  try {
    FileWriter fw = new FileWriter("MASCH.txt");
    PrintWriter pw = new PrintWriter(fw);
  
    for (Maschine ma : malist) {
      pw.println(ma.ausMaschCSV());
    }
      
    pw.close();
    fw.close();
  } catch (IOException e) {
    System.out.println(e);
    return;
  }
  }
  
  static void abschreibungBerechnen(LinkedList<Maschine> malist) {
  System.out.println("Abschreibung berechnen (y: ja, n: nein)?");
  char y = IO1.einchar(); // should we calculate?
  
  if (y == 'n') return; // abort!
  
  int manr; // machine nr
  Maschine maAbsch; // the requested machine
  int laufz; // machine's lifespan
  double absch; // machine's calculated writing-off value per wok day
  
  while (y == 'y') {  
    // read machine nr.
    System.out.println("Maschinennummer eingeben:");
    manr = IO1.einint();
    
    // check if machine is in list
    try {
      maAbsch = findMaschineByNr(malist, manr);
    } catch (Exception e) {
      // machine was not found!
      System.out.println("Maschine ist nicht in Liste!");
      continue;
    } 
    
    // read lifespan
    System.out.println("Laufzeit in Arbeitstagen eingeben:");
    laufz = IO1.einint();
  
    // try to calc machine's writing-off
    try { 
      absch = maAbsch.abschreibung(laufz);      
    } catch (Exception e) {
      System.out.println("Laufzeit war ungültig!");
      continue;
    }
    System.out.println("Abschreibungswert/Arbeitstag der Maschine ist " + absch);
    
    // do everything again?
    System.out.println("Abschreibung berechnen (y: ja, n: nein)?");
    y = IO1.einchar();
  }  
  }
  
  static Maschine findMaschineByNr(LinkedList<Maschine> mas, int nr) throws Exception {
  for (Maschine ma : mas) {
    if (ma.getManr() == nr) return ma;
  }
  // machine wasn't found in list!
  throw new Exception();
  }
  
  static String[] maschGeber() {
    String[] maschinen = {
      "1;3.5;Staubsauger;Köln",
      "2;19.99;PC;ALDI",
      "3;99.99;Auto;Dortmund",
      "a;33.99;C64;Düsseldorf", // unkorrekt
      "5;55.66;Rasierer;Saturn",
      "6;50;Fahrrad;Düsseldorf",
      "20.3;Tisch;Hagen", // unkorrekt
    };
    
    return maschinen;
  }
}