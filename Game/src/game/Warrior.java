package game;

public class Warrior extends Witch {

	public Warrior() {
		super.setName("전사");
	}
	
	@Override
	public void skill() {
		System.out.println("적 전체에게 데미지");
	}

}
