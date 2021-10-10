package PI2.HA2;

public class ZDatAnw {
    public static void main(String[] args) throws Exception {
		ZDatM m = new ZDatM("Masch1.txt", 1); // lesende Instanz
		ZDatM n = new ZDatM("Masch2.txt", 2); // schreibende Instanz
		int vergleiche; // Anzahl der Vergleiche durch die Sortierung

		n.setDsliste(m.getDsliste()); // schreibende Instanz mit Maschinen-Liste befüllen
		vergleiche = n.bubble(3);
		System.out.println(vergleiche + " Vergleiche beim Sortieren der " + n.getDsliste().size() + " Elemente durchgeführt.");
		n.list2dat(); // Maschinen-Liste in eine Datei schreiben
    }
}

