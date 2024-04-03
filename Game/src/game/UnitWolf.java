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
		if(target.getCurHp() == 0)
			return;
		
		int power = super.getPower() / 2;
		System.out.println("[" + super.getName() + "]가 " + "[" + target.getName() + "]에게 " + power + "의 데미지를 입힙니다. ");
		
		int hp = target.getCurHp() ;
		
		if(hp == 0) {
			System.err.println("스킬 실패 : 이미 죽은 적입니다");
		}
		
		hp = hp - power;
		
		if(hp <= 0) {
			System.out.println("[" + target.getName() + "]을 처치하였습니다.");
			hp = 0;
		}
		
		target.setCurHp(hp);
	}
	
}
