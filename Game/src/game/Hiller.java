package game;

public class Hiller extends Unit{
	
	public Hiller() {
		super.setName("힐러");
	}
	
	public void skill() { 
		System.out.println("본인 제외 모든 동료들 각각 30hp 회복 ");
	}
	
}
