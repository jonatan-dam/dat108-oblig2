package dat108.oblig2.hamburgersjappe;

import java.util.LinkedList;
import java.util.Queue;

/*
 * En objekt-klasse for å registrere hamburgerbrettene som fungerer som kø for servering av hamburgere.
 */
public class HamburgerBrett {
	private final int kapasitet;
	private final Queue<Hamburger> brett;
	
	public HamburgerBrett(int kapasitet) {
		this.kapasitet = kapasitet;
		this.brett = new LinkedList<>();
	}

	public int getKapasitet() {
		return kapasitet;
	}
	
	/**
	 * Legger til en hamburger i køen. Kokken venter dersom brettet er fullt, og varsler alle servitører når hen legger på en ny hamburger.
	 * @param hamburger Hamburgeren som skal legges på brettet
	 * @param kokkNavn Navnet på kokken som legger på en hamburger
	 * @throws InterruptedException
	 */
	public synchronized void leggTilHamburger(Hamburger hamburger, String kokkNavn) throws InterruptedException {
		while(brett.size() == kapasitet) {
			System.out.println(kokkNavn + " (kokk) er klar med hamburger " + hamburger + ", men brettet er fullt. Venter!");
			wait(); // Kokken må vente med å legge på burger dersom brettet er fullt
		}
		brett.add(hamburger);
		System.out.println(kokkNavn + " (kokk) legger på hamburger " + hamburger + ". Brett: " + brett);
		notifyAll(); // Varsler alle servitører om at det finnes en ny hamburger på brettet
		
	} // end leggTilHamburger
	
	/**
	 * Fjerner en hamburger fra fremst i køen, for å servere den. Servitøren venter dersom brettet er tomt, og varsler alle kokker når hen tar en burger fra brettet.
	 * @param servitorNavn Servitøren som tar en hamburger fra brettet
	 * @return Hamburgeren som blir tatt fra brettet.
	 * @throws InterruptedException
	 */
	public synchronized Hamburger taHamburger(String servitorNavn) throws InterruptedException {
		while(brett.isEmpty()) {
			System.out.println(servitorNavn + " (servitør) ønsker å ta av hamburger, men brettet er tomt. Venter!");
			wait();
		}
		Hamburger hamburger = brett.poll();
		System.out.println(servitorNavn + " (servitør) tar av hamburger " + hamburger + ". Brett: " + brett);
		notifyAll(); // Varsler alle kokker om at det er ledig plass på brettet
		return hamburger;
		
	} // end taHamburger

	
	
}
