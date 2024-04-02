package game;

public class Hiller extends Unit{
	
	public Hiller() {
		super.setName("힐러");
	}

	@Override
	public void skill() {
		System.out.println("모든 동료들 각각 30Hp 회복 ");
	}

	@Override
	public void skill(Unit target) {
		System.out.println(super.getName() + "가 " + target.getName()+"을 힐 +30Hp");
		
		int hp = target.getCurHp() + 30;
		
		if(hp > target.getMaxHp())
			hp = target.getMaxHp();
		
		target.setCurHp(hp);
	}
}