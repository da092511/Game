package game;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class StageBattle extends Stage {
	private UnitManager unitManager = new UnitManager();
	private Vector<Unit> playerList = null;
	private Vector<Unit> monList = null;
	private Random ran = new Random();
	
	private int monDead = 0;
	private int playerDead = 0;
	
	private int roundNum = 1;
	private String curRound;
	
	public void init() {
		unitManager.monList.clear();
		unitManager.monsterRandomSet(4);
		playerList = null;
		playerList = unitManager.playerList;
		monList = null;
		monList = unitManager.monList;
		monDead = monList.size();
		playerDead = playerList.size();
		
		curRound = String.format("%dRound", roundNum);
		roundNum ++;
	}

	private void printCharacter() {
		System.out.println("======["+curRound+"]======");
		System.out.println("======[PLAYER]======");
		for (int i = 0; i < playerList.size(); i++) {
			playerList.get(i).printData();
		}
		System.out.println("======[MONSTER]======");
		for (int i = 0; i < monList.size(); i++) {
			monList.get(i).printData();
		}
	}
	
	private void playerSkill(Unit p) {
		if(p instanceof Hiller) {
			Hiller hiller = (Hiller) p;
			
			for(Unit target : playerList)
				hiller.skill(target);
			
			return;
		}
		
		for(Unit target : monList)
			p.skill(target);
	}

	private void playerAttack(int index) {
		Unit p = playerList.get(index);
		if (p.getCurHp() <= 0)
			return;
		
		System.out.println("======[메뉴 선택]=====");
		System.out.println("[" + p.getName() + "] [1.어택] [2.스킬]");
		int sel = GameManager.scan.nextInt();
		
		System.out.println("=======[Attack]=====");
		if (sel == 1) {
			while (true) {
				int idx = ran.nextInt(monList.size());
				
				if (p.getIsFaint()) {
					System.err.println(p.getName() + "는 기절상태입니다.");
					p.setFaint();
					break;
				}
				else if (monList.get(idx).getCurHp() > 0) {
					p.attack(monList.get(idx));
					break;
				}
			}
		} else if (sel == 2) {
			if (p.getIsFaint()) {
				System.err.println(p.getName() + "는 기절상태입니다.");
				p.setFaint();
				return;
			}
			//skill
			p.skill();
			playerSkill(p);
		}
	}
	
	private void monSkill(Unit m) {
		m.skill();
		if(m instanceof UnitWolf) {
			for(Unit target : playerList)
				m.skill(target);
			return;
		}
		
		int rIdx = ran.nextInt(playerList.size());
		m.skill(playerList.get(rIdx));
	}

	private void monsterAttack(int index) {
		Unit m = monList.get(index);
		
		if (m.getCurHp() <= 0)
			return;
		
		while (true) {
			int idx = ran.nextInt(playerList.size());
			int attack = ran.nextInt(20);
			
			if (m.getIsFaint()) {
				System.err.println(m.getName() + "는 기절상태입니다.");
				m.setFaint();
				break;
			}
			else if (playerList.get(idx).getCurHp() > 0) {
				//skill
				if(attack == 1) {
					monSkill(m);
					break;
				}
				//attack
				m.attack(playerList.get(idx));
				break;
			}
		}
	}

	private void checkLive() {
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
			if (turn) {
				printCharacter();
				if (pIndex < playerList.size()) {
					playerAttack(pIndex);

					pIndex += 1;
					turn = !turn;
					
					if(pIndex == playerList.size())
						pIndex = 0;
				}

			} else if (!turn) {
				if (mIndex < monList.size()) {
					if(mIndex == 0)
						System.out.println("====[Attacked]====");
					monsterAttack(mIndex);
					mIndex ++;
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