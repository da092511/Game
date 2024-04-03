package game;

public class UnitOrc extends Unit{
	public UnitOrc() {
		super.setName("오크");
	}

	@Override
	public void skill() {
		System.out.println("한명에게 2배의 데미지 + 기절 ");
	}
	
	@Override
	public void skill(Unit target) {
		int power = super.getPower() * 2;
		System.out.println("[" + super.getName() + "]가 " + "[" + target.getName() + "]에게 " + power + "의 데미지를 입힙니다. ");
	
		if(!target.getIsFaint())
			target.setFaint();
		
		if(target.getCurHp() == 0) {
			System.err.println("스킬 실패 : 이미 죽은 적입니다");
			return;
		}
		
		int hp = target.getCurHp() - power;
		if(hp <= 0) {
			System.out.println("[" + target.getName() + "]을 처치하였습니다.");
			hp = 0;
		}
		
		target.setCurHp(hp);
	}
	
}
