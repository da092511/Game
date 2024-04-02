package game;

import java.util.Random;
import java.util.Vector;

public class UnitManager {
	Vector<Unit> playerList = new Vector<>();
	Vector<Unit> monList = new Vector<>();
	String path = "game." ;
	String players[] = {"Warrior" , "Witch", "Hiller"};
	String mons[] = {"UnitWolf", "UnitBat", "UnitOrc"};
	Random ran = new Random();
	
	public UnitManager() {
		for (int i = 0; i < 3; i++) {
			try {
				Class<?> clazz = Class.forName(path + players[i]);
				Object obj = clazz.getDeclaredConstructor().newInstance(); // clazz.newInstance();
				Unit temp = (Unit) obj;
				int hp = ran.nextInt(6) + 5;
				int pow = ran.nextInt(10) + 10;
				
				hp = hp *100;
				pow = pow * 5;
				
				temp.init(hp, pow);  	//super : Unit
				playerList.add(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void monsterRandomSet(int size) {
		for (int i = 0; i < size; i++) {
			int num = ran.nextInt(mons.length);
			try {
				Class<?> clazz = Class.forName(path + mons[num]);
				Object obj = clazz.getDeclaredConstructor().newInstance(); // clazz.newInstance();
				Unit temp = (Unit) obj;
				int hp = ran.nextInt(100) + 100;
				int pow = ran.nextInt(10) + 10;
				
				temp.init(hp, pow);
				monList.add(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
