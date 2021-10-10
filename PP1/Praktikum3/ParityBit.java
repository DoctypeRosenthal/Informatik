import java.util.Arrays; 
public class ParityBit {
	
	public static void main(String[] args) {
		char end = 'n'; // kann 'j' oder 'n' sein
		
		do {
			int userIn;
			int parityBit;
			int[] bits = new int[8];
			int i = 0;
			int gesamt = 0;
			
			while (i < bits.length) {
				System.out.println("Bitte ein bit eingeben für Stelle " + i);
				userIn = IO1.einint();
				if (userIn != 1 && userIn != 0) {
					System.out.println("Fehlerhafte Eingabe!");
					continue;
				}
				
				bits[i] = userIn;
				i++;
			}
			
			for (i = 0; i < bits.length; i++) {
				gesamt += bits[i];
			}
			
			if (gesamt % 2 == 0) {
				// gerade Anzahl an 1-er bits
				parityBit = 0;
			} else {
				// ungerade Anzahl an 1-er bits
				parityBit = 1;
			}
			
			System.out.println(Arrays.toString(bits));
			System.out.println("Wert des parity-bits: " + parityBit);
			
			// Umkippen
			System.out.println("Bitte geben sie eine Positionsnummer zwischen 0 und 7 ein, \n"
				+ "um das bit an dieser Stelle 'umzukippen'. Geben sie -1 ein, \n"
				+ "wenn Sie nichts vornehmen wollen.");
				
			userIn = IO1.einint();
			if (userIn != -1) {
				bits[userIn] = bits[userIn] == 0 ? 1 : 0;
				System.out.println(Arrays.toString(bits));
				System.out.println("Wert des parity-bits: " + parityBit);
			}
			
			// Prüfen auf bitfehler
			gesamt = 0;
			for (i = 0; i < bits.length; i++) {
				gesamt += bits[i];
			}
			
			if ((gesamt % 2 == 0 && parityBit == 1) || (gesamt % 2 == 1 && parityBit == 0)) {
				// Fehler
				System.out.println("Fehler!");
			} else {
				System.out.println("Alles ok!");
			}
			System.out.println("Programm beenden? [j/n]");
			end = IO1.einchar();
		} while (end == 'n');
		System.out.println("Vielen Dank für die Benutzung des Programms und einen schönen Tag!");
	}
	
}