package dat108.oblig2.hamburgersjappeMedBlockingQueue;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Kokk extends Thread {
	private final HamburgerBrett brett;
	private final String navn;
	private static final AtomicInteger hamburgerCounter = new AtomicInteger(1);
	
	public Kokk(String navn, HamburgerBrett brett) {
		this.navn = navn;
		this.brett = brett;
	}

	public static AtomicInteger getHamburgerCounter() {
		return hamburgerCounter;
	}


	public HamburgerBrett getBrett() {
		return brett;
	}

	public String getNavn() {
		return navn;
	}
	
	public void run() {
		Random random = new Random();
		while (true) {
			try {
				Thread.sleep(random.nextInt(4000) + 2000); // Simulerer en tilfeldig ventetid mellom 2 og 6 sekunder.
				Hamburger hamburger = new Hamburger(hamburgerCounter.getAndIncrement()); // Synkroniserer hamburgerCounter på tvers av kokkene
				brett.leggTilHamburger(hamburger, navn);
				
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
