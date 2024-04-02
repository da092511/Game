package game;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GameManager {
	private Random ran = new Random();
	public static Scanner scan = new Scanner(System.in);
	public static String nextStage = "";
	private String curStage = "";
	
	Map<String, Stage> stageList = new HashMap<String, Stage>();
	
	private int n ;
	private String stage = "Round";
	
	GameManager() {
		stageList.put("Forest of Dream", new StageTitle());
		stageList.put("LOBBY", new StageLobby());
		stageList.put("BATTLE", new StageBattle());
		
		nextStage = "Forest of Dream";
	}

	boolean changeStage() {
		if (curStage.equals(nextStage))
			return true;

		curStage = nextStage;
		
		Stage stage = stageList.get(curStage);
		stage.init();

		boolean run = true;
		while (true) {
			run = stage.update();
			if (run == false)
				break;
		}

		if (nextStage.equals(""))
			return false;
		else
			return true;
	}

}