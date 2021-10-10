class Lichterkette {
  public static void main(String[] args) {
    short flags = 64;                  // Repräsentiert eine "Lichterkette" mit 16 Lämpchen (bits)
    byte k = 6;                      // die byte-Position des Lämpchens, welches überprüft werden soll
    byte pot2 = (byte) Math.pow(2, k); // die 2er-Potenz von k
    String b = "aus";                // zeigt an, ob das k-te Lämpchen brennt oder nicht. Standardwert: "aus"
       
    if ((flags & pot2)/pot2 == 1) {
       // das k-te bit hat den wert 1 -> das Lämpchen brennt
      b = "an";        
    } 
    
    System.out.print("Das " + k + "te Lämpchen ist " + b);
  }  
}