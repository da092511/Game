package game;

public class UnitOrc extends Unit{
	public UnitOrc() {
		super.setName("오크");
	}
	
	public void skill() {
		System.out.println("한명에게 2배의 데미지 + 기절 ");
	}
	
	public void skill(Unit target) {
		int power = super.getPower() * 2;
		System.out.println("[" + super.getName() + "]가 " + "[" + target.getName() + "]에게 " + power + "의 데미지를 입힙니다. ");
	
		if(!target.getIsFaint())
			target.setFaint();
		
		int hp = target.getCurHp() - power;
		target.setCurHp(hp);
	
	}
}
