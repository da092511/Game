package game;

public class Main {

	public static void main(String[] args) {
		GameManager game = new GameManager();
		
		boolean isRun = true;
		while(true) {
			isRun = game.changeStage();
			
			if(!isRun)
				break;
		}
		System.err.println("게임오버");
	}

}
