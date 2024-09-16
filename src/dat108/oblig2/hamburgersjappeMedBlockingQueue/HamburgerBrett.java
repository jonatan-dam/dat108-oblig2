package dat108.oblig2.hamburgersjappeMedBlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


/*
 * En objekt-klasse for å registrere hamburgerbrettene som fungerer som kø for servering av hamburgere.
 */

public class HamburgerBrett {
	private final int kapasitet;
	private final BlockingQueue<Hamburger> brett;
	
	public HamburgerBrett(int kapasitet) {
		this.kapasitet = kapasitet;
		this.brett = new LinkedBlockingQueue<>(kapasitet);
	}

	public int getKapasitet() {
		return kapasitet;
	}
	
	public void leggTilHamburger(Hamburger hamburger, String kokkNavn) throws InterruptedException {
		brett.put(hamburger);
		System.out.println(kokkNavn + " (kokk) legger på hamburger " + hamburger + ". Brett: " + brett);
	
	} // end leggTilHamburger
	
	public Hamburger taHamburger(String servitorNavn) throws InterruptedException {
		Hamburger hamburger = brett.take();
		System.out.println(servitorNavn + " (servitør) tar av hamburger " + hamburger + ". Brett: " + brett);
		return hamburger;
	}
}
