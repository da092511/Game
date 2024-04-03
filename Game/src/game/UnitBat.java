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
		System.out.println("[" + super.getName() + "]가 " + "[" + target.getName() + "]를 기절시킵니다.");
		
		if(!target.getIsFaint()) {
			target.setFaint();
			System.out.println("스킬 성공");
		}else 
			System.err.println("스킬 실패");
	}
}
