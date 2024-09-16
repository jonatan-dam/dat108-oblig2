package dat108.oblig2.skrivut;
import javax.swing.JOptionPane;


/*
 *  Det skal lages et lite program der vi har én tråd som skriver ut en linje på skjermen hvert 3.
 *  sekund, og én tråd som gjentatte ganger lar brukeren taste inn via JOptionPane hva som skal
 *  skrives ut.
 */
public class MultiThreadPrinter {
	
	// Variabel for å lagre standardmelding, før bruker-input
	private static String message = "Hallo verden!";
			
	// Flagg for å kontrollere om programmet skal fortsette å kjøre
	private static boolean running = true;


	public static void main(String[] args) {
		
		// Tråd for å skrive ut meldinger hvert 3. sekund
		Thread printThread = new Thread(() -> {
			while (running) {
				System.out.println(message);
				
				try {
					Thread.sleep(3000); // Venter i 3 sekund
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
				
		
		
		// Tråd for å ta imot brukerens input via JOptionPane
		Thread inputThread = new Thread(() -> {
			while (running) {
				String newMessage = JOptionPane.showInputDialog("Tast inn meldingen du vil skrive ut. Tast 'quit' for å avslutte");
				
				if(newMessage != null && newMessage.equalsIgnoreCase("quit")) {
					running = false;
				} else if (newMessage != null) {
					message = newMessage;
				}
			}
		});
		
		
		// Starter begge trådene
		printThread.start();
		inputThread.start();
		
		// Venter til begge trådene er ferdige
		try {
			printThread.join();
			inputThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Programmet er avsluttet.");
		
	}

}
