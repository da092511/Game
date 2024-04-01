package game;

public abstract class Unit {
	int curHp;
	int maxHp;
	int power;
	String name;
	String state = "노말";
	
	public Unit() {
		
	}
	
	public Unit(String na, int max, int pw) {
		name = na;
		maxHp = max;
		curHp = max;
		power = pw;
	}
	
	public void init(int max, int pw) {
		maxHp = max;
		curHp = max;
		power = pw;
	}
	
	public void init(String na, int max, int pw) {
		name = na;
		maxHp = max;
		curHp = max;
		power = pw;
	}
	
	public void attack(Unit target) {
		
	}
	
	
}
