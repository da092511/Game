package game;

public class Witch extends Unit {
	
	public Witch() {
		super.setName("마녀");
	}
	
	public void skill() {
		System.out.println("적 1턴 무효화");
	}
}
