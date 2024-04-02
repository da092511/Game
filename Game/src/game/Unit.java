package game;

public class Unit {
	private int curHp;
	private int maxHp;
	private int power;
	
	private String name;
	private String state = "노말";
	
	private boolean isFaint;
	
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
	
	public int getCurHp() {
		return this.curHp;
	}
	
	public void setCurHp(int curHp) {
		this.curHp = curHp;
	}
	
	public void attack(Unit target) {
		System.out.println(name);
		int hp = target.getCurHp() - power;
		
		System.out.println("[" + name + "]가 " + "[" + target.name + "]에게 " + power + "의 데미지를 입힙니다. ");
		if (hp <= 0) {
			System.out.println("[" + target.name + "]를 쳐치했습니다.");
			target.setCurHp(0);
			return;
		}
		
		target.setCurHp(hp);
	}
	
	public void printData() {
		System.out.println("[" + name + "] [" + curHp + "/" + maxHp + "] [" + power + "]");
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean getIsFaint() {
		return this.isFaint;
	}
	
	public void setFaint() {
		this.isFaint = !isFaint;
		
	}
	
}
