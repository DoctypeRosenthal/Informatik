import java.io.*;
import java.util.*;

class MaschDV {

  static void main() {
    LinkedList<Maschine> malist = new LinkedList<Maschine>();
    
    try {
      FileReader fr = new FileReader("MASCH.txt");
      BufferedReader br = new BufferedReader(fr);
      String h = br.readLine();
      
      while (h != null){
        Maschine ma = new Maschine(h);
        malist.add(ma);
        h = br.readLine();
      }
    } catch (IOException e) {
      System.out.println(e);
    }
    
    for (Maschine ma : malist) {
      ma.ausMasch();
    }
    
    int auswahl = -1;
    
    while (auswahl != 0){
      System.out.println("Wählen sie aus:");
      System.out.println(
        "1: Einfügen einer neuen Maschine in die Liste \n"
        + "2: Löschen einer Maschine aus der Liste \n"
        + "3: Ändern einer Maschine in der Liste \n"
        + "4: Maschinen in eine Datei Schreiben \n"
        + "0: Beenden der Anwendung"
      );
      auswahl = IO1.einint();
      
      switch (auswahl){
        case 1:
          insertIn(malist);
        break;
        
        case 2:
          deleteFrom(malist);
        break;
        
        case 3:
          change(malist);
        break;
        
        case 4:
          MaschAnw.write2Dat(malist);
        break;    
      }   
    }         
  }
  
  static void insertIn(LinkedList<Maschine> malist) {
    int pos; // gewünschte Position der Maschine innerhalb der Liste
    System.out.println("Wo soll die Maschine eingefügt werden? Listenlänge ist " + malist.size());
    
    pos = IO1.einint();
    while (pos < 0 || malist.size() < pos) {
      System.out.println("Keine gültige Position! Bitte eine Zahl zwischen 0 und " + malist.size() + " eingeben.");
      pos = IO1.einint();
    }
    
    // gültige Position wurde eingegeben -> neue Standard-Maschine einfügen
    malist.add(pos, new Maschine());
  }
  
  static void deleteFrom(LinkedList<Maschine> malist) {
    int pos; // gewünschte Position der Maschine innerhalb der Liste
    System.out.println("Welche Maschine soll gelöscht werden? Listenlänge ist " + malist.size());
    
    pos = IO1.einint();
    while (pos < 0 || (malist.size() - 1) < pos) {
      System.out.println("Keine gültige Position! Bitte eine Zahl zwischen 0 und " + (malist.size() - 1) + " eingeben.");
      pos = IO1.einint();
    }
    
    // gültige Position wurde eingegeben 
    malist.remove(pos);
  }
  
  static void change(LinkedList<Maschine> malist) {
    int pos; // gewünschte Position der Maschine innerhalb der Liste
    Maschine ma;
    int auswahl;
    boolean erfolgreich = true;
    
    System.out.println("Welche Maschine soll geändert werden? Listenlänge ist " + malist.size());
    
    pos = IO1.einint();
    while (pos < 0 || malist.size() < pos) {
      System.out.println("Keine gültige Position! Bitte eine Zahl zwischen 0 und " + malist.size() + " eingeben.");
      pos = IO1.einint();
    }
    
    // gültige Position wurde eingegeben
    ma = malist.get(pos);
    
    System.out.println("Ausgewählte Maschine:");
    ma.ausMasch();
    
    System.out.println("Welches Attribut möchten Sie ändern?");
    System.out.println(
      "1: Maschinennummer\n"
      + "2: Preis\n"
      + "3: Bezeichnung\n"
      + "4: Standort"
    );
    
    auswahl = IO1.einint();
    
    switch (auswahl) {
      case 1:
        // neue Maschinennummer eingeben
        int nr = IO1.einint();
        erfolgreich = ma.setManr(nr);
      break;
      case 2:
        // neuen Preis eingeben
        double preis = IO1.eindouble();
        erfolgreich = ma.setPreis(preis);
      break;
      case 3:
        // Maschinenbezeichnung
        String bez = IO1.einstring();
        erfolgreich = ma.setMabez(bez);
      break;
      case 4:
        // Standort
        String stao = IO1.einstring();
        erfolgreich = ma.setStao(stao);
      break;
      default:
        System.out.println("Keine gültige Auswahl!");
      break;
    }
    
    if (erfolgreich) {
      // es wurde was geändert -> nur dann Maschine zurück in die Liste schreiben
      malist.set(pos, ma);
    }
    
    System.out.println(erfolgreich ? "Maschine wurde geändert!" : "Maschine wurde nicht geändert!");
  }
}
