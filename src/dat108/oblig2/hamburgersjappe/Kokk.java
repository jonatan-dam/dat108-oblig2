package dat108.oblig2.hamburgersjappe;

import java.util.Random;

/*
 * En tråd-klasse for å registrere kokker som jobber i hamburgersjappen.
 */

public class Kokk extends Thread {
	private final HamburgerBrett brett;
	private final String navn;
	private static int hamburgerCounter = 1;
	
	public Kokk(String navn, HamburgerBrett brett) {
		this.navn = navn;
		this.brett = brett;
	}

	public String getNavn() {
		return navn;
	}

	public HamburgerBrett getBrett() {
		return brett;
	}

	public void run() {
		Random random = new Random();
		while (true) {
			try {
				Thread.sleep(random.nextInt(4000) + 2000); // Simulerer en tilfeldig ventetid mellom 2 og 6 sekunder.
				Hamburger hamburger;
				synchronized (Kokk.class) {
					hamburger = new Hamburger(hamburgerCounter++);
				}
				
				brett.leggTilHamburger(hamburger, navn);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	
	
}
