package dat108.oblig2.hamburgersjappeMedBlockingQueue;

import java.util.Arrays;



/**
 * Det skal lages et lite program som simulerer en hamburger-sjappe.
 * Hamburger-sjappen har et brett (kø) der ferdige hamburgere legges på av kokken(e) etter
 * hvert som de er ferdige og tas av av servitøren(e) etter hvert som kunder kjøper en
 * hamburger.
 * 
 * Det er meningen at man skal bruke klasser fra java.util.concurrent.BlockingQueue i stedet for synchronized, wait, og notify.
 */

public class Program {
	
	public static void main(String[] args) {
		final String[] kokker = {"Anne", "Erik", "Knut"};
		final String[] servitorer = {"Mia", "Per"};
		final int KAPASITET = 4;
		
		skrivUtHeader(kokker, servitorer, KAPASITET);
		
		HamburgerBrett brett = new HamburgerBrett(KAPASITET);
		
		for (String navn : kokker) {
			new Kokk(navn, brett).start();
		}
		
		for (String navn : servitorer) {
			new Servitor(navn, brett).start();
		}
	}
	
	/**
	 * Skriver ut en header med detaljer om simuleringen av hamburgersjappen
	 * @param kokker Et array med kokkene som lager hamburgere i sjappen
	 * @param servitorer Et array med servitørene som serverer hamburgere i sjappen
	 * @param kapasitet Kapasiteten på hamburgerbrettet/køen
	 */
	public static void skrivUtHeader(String[] kokker, String[] servitorer, int kapasitet) {
		System.out.println("I denne simuleringen har vi: \n" + kokker.length + " kokker " + Arrays.toString(kokker) + "\n"
							+ servitorer.length + " servitører " + Arrays.toString(servitorer) + "\nKapasiteen til brettet er " + kapasitet + " hamburgere. \nVi starter ...");
	} //end skrivUtHeader

}
