package dat108.oblig2.skrivut;
import javax.swing.JOptionPane;


/*
 *  Det skal lages et lite program der vi har én tråd som skriver ut en linje på skjermen hvert 3.
 *  sekund, og én tråd som gjentatte ganger lar brukeren taste inn via JOptionPane hva som skal
 *  skrives ut.
 */
public class MultiThreadPrinter {
	
	// Variabel for å lagre standardmelding, før bruker-input
	private static String melding = "Hallo verden!";
			
	// Flagg for å kontrollere om programmet skal fortsette å kjøre
	private static boolean kjorer = true;


	public static void main(String[] args) {
		
		// Tråd for å skrive ut meldinger hvert 3. sekund
		Thread printerThread = new Thread(() -> {
			while (kjorer) {
				System.out.println(melding);
				
				try {
					Thread.sleep(3000); // Venter i 3 sekund
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
				
		
		
		// Tråd for å ta imot brukerens input via JOptionPane
		Thread inputThread = new Thread(() -> {
			while (kjorer) {
				String nyMelding = JOptionPane.showInputDialog("Tast inn meldingen du vil skrive ut. Tast 'quit' for å avslutte");
				
				if(nyMelding != null && nyMelding.equalsIgnoreCase("quit")) {
					kjorer = false;
				} else if (nyMelding != null) {
					melding = nyMelding;
				}
			}
		});
		
		
		// Starter begge trådene
		printerThread.start();
		inputThread.start();
		
		// Venter til begge trådene er ferdige
		try {
			printerThread.join();
			inputThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Programmet er avsluttet.");
		
	}

}
