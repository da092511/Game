package game;

public class Witch extends Unit {
	
	public Witch() {
		super.setName("마녀");
	}

	@Override
	public void skill() {
		System.out.println("적 1턴 무효화");
	}
	
	@Override
	public void skill(Unit target) {
		if(target.getCurHp() == 0)
			return;
		
		System.out.println("[" + super.getName() + "]가 " + "[" + target.getName() + "]를 기절시킵니다.");
		
		if(!target.getIsFaint())
			target.setFaint();
		else 
			System.err.println("실패");
	}
}
