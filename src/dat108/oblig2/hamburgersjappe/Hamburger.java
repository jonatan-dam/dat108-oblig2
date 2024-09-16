package dat108.oblig2.hamburgersjappe;

public class Hamburger {
	private final int id;
	
	public Hamburger(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	@Override
    public String toString() {
        return "◖" + id + "◗";
    }
	
	
}
