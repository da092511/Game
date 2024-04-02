package game;

public class UnitBat extends Unit{
	public UnitBat() {
		super.setName("박쥐");
	}
	
	@Override
	public void skill() {
		System.out.println("적 한명에게 침묵 시전 ");
	}
	
	@Override
	public void skill(Unit target) {
	}
}
