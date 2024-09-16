package dat108.oblig2.hamburgersjappeMedBlockingQueue;

import java.util.Random;

public class Servitor extends Thread {
	private final HamburgerBrett brett;
	private final String navn;
	
	public Servitor(String navn, HamburgerBrett brett) {
		this.navn = navn;
		this.brett = brett;
	}

	public HamburgerBrett getBrett() {
		return brett;
	}

	public String getNavn() {
		return navn;
	}
	
	public void run() {
		Random random = new Random();
		while(true) {
			try {
				Thread.sleep(random.nextInt(4000) + 2000); // Simulerer en tilfeldig ventetid mellom 2 og 6 sekunder.
				brett.taHamburger(navn);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
