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
		int power = super.getPower() / 2;
		System.out.println("[" + super.getName() + "]가 " + "[" + target.getName() + "]에게 " + power + "의 데미지를 입힙니다. ");
		
		int hp = target.getCurHp() - power;
		
		if(hp < 0)
			hp = 0;
		
		target.setCurHp(hp);
	}
	
}
