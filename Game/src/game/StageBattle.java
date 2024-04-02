package game;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class StageBattle extends Stage {
	UnitManager unitManager = new UnitManager();
	Vector<Unit> playerList = null;
	Vector<Unit> monList = null;
	Random ran = new Random();
	int monDead = 0;
	int playerDead = 0;

	public void init() {
		unitManager.monList.clear();
		unitManager.monsterRandomSet(4);
		playerList = null;
		playerList = unitManager.playerList;
		monList = null;
		monList = unitManager.monList;
		monDead = monList.size();
		playerDead = playerList.size();
	}

	void printCharacter() {
		System.out.println("======[BATTLE]======");
		// System.out.println(playerSize + " " + monSize);
		System.out.println("======[PLAYER]======");
		for (int i = 0; i < playerList.size(); i++) {
			playerList.get(i).printData();
		}
		System.out.println("======[MONSTER]======");
		for (int i = 0; i < monList.size(); i++) {
			monList.get(i).printData();
		}
	}

	void playerAttack(int index) {
		Unit p = playerList.get(index);
		if (p.getCurHp() <= 0)
			return;
		System.out.println("======[메뉴 선택]=====");
		System.out.println("[" + p.getName() + "] [1.어택] [2.스킬]");
		int sel = GameManager.scan.nextInt();
		
		System.out.println("======[Attack]=====");
		if (sel == 1) {
			while (true) {
				int idx = ran.nextInt(monList.size());
				
				if (p.getIsFaint())
					break;
				else if (monList.get(idx).getCurHp() > 0) {
					p.attack(monList.get(idx));
					break;
				}
			}
		} else if (sel == 2) {
			//skill
			
		}
	}

	void monster_attack(int index) {
		Unit m = monList.get(index);
		if (m.getCurHp() <= 0)
			return;
		while (true) {
			int idx = ran.nextInt(playerList.size());
			
			if (m.getIsFaint())
				break;
			else if (playerList.get(idx).getCurHp() > 0) {
				//skill
				
				m.attack(playerList.get(idx));
				break;
			}
		}
	}

	void checkLive() {
		int num = 0;
		for (int i = 0; i < playerList.size(); i++) {
			if (playerList.get(i).getCurHp() <= 0) {
				num += 1;
			}
		}
		playerDead = playerList.size() - num;
		num = 0;
		for (int i = 0; i < monList.size(); i++) {
			if (monList.get(i).getCurHp() <= 0) {
				num += 1;
			}
		}
		monDead = monList.size() - num;

	}

	public boolean update() {
		boolean run = true;
		int pIndex = 0;
		int mIndex = 0;
		boolean turn = true;

		while (run) {
			// print_character();
			if (turn) {
				printCharacter();
				if (pIndex < playerList.size()) {
					playerAttack(pIndex);

					pIndex += 1;
					turn = !turn;
				} else {
					turn = !turn;
					pIndex = 0;
				}

			} else if (!turn) {
				if (mIndex < monList.size()) {
					if(mIndex == 0)
						System.out.println("====[Attacked]====");
					monster_attack(mIndex);
					mIndex += 1;
				} else {
					turn = !turn;
					mIndex = 0;
				}
			}
			checkLive();
			if (monDead <= 0 || playerDead <= 0)
				break;
		}
		GameManager.nextStage = "LOBBY";
		return false;
	}
}