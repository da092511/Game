package game;

import java.util.Random;
import java.util.Vector;

public class UnitManager {
	Vector<Player> playerList = new Vector<>();
	Vector<Unit> monList = new Vector<>();
	String path = "game." ;
	String players[] = {"warrior" , "witch", "hiller"};
	String mons[] = {"UnitWolf", "UnitBat", "UnitOrc"};
	Random ran = new Random();
	
	public UnitManager() {
		playerList.add(new Player("전사", 1000, 45));
		playerList.add(new Player("마녀", 800, 60));
		playerList.add(new Player("힐러" , 500, 70));
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
