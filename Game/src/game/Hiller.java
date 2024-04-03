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
		int hp = target.getCurHp();
		
		if(hp == 0)
			return;
		
		hp = hp + 30;
		
		if(hp > target.getMaxHp())
			hp = target.getMaxHp();
		
		System.out.println(super.getName() + "가 " + target.getName()+"를 힐 +30Hp");
		
		target.setCurHp(hp);
	}
}