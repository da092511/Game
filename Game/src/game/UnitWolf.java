package game;

public class UnitWolf extends Unit{

	public UnitWolf(){
		super.setName("늑대");
	}
	
	@Override
	public void skill() {
		System.out.println("적 전체에게 공격력의 절반 데미지 ");
	}
	
	@Override
	public void skill(Unit target) {
	}
	
}
