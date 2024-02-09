package manticore;
import util.*;

public class Challenge22 {
	public static void main (String[] args) {
		new Game();
		playRounds();
	}
	
	private static void playRounds() {
		guessManticoreSpot();
		damageCalc();
		if (Game.manticoreHealth > 0) {
			displayRound();
			if (Game.cityHealth > 0 && Game.manticoreHealth > 0) {
				roundResult();
				playRounds();
			} else {
				System.out.println("------------------------------------------------------------");
				System.out.println("The city of Consolas has been destroyed. The Manticore won.");
			}
		} else {
			System.out.println("------------------------------------------------------------");
			System.out.println("The Manticore has been destroyed! The city of Consolas has been saved!");
		}
		
	}
	
	private static void guessManticoreSpot () {
		AskForNumberInRange spot = new AskForNumberInRange("Guess where the manticor is (between 0 and 100)", 0, 100);
		Game.guessedSpot = spot.getResult();
		String result = "";
		
		if (Game.guessedSpot < Game.manticoreSpot) {
			result = "OVERSHOT the target.";
		} else if (Game.guessedSpot > Game.manticoreSpot) {
			result = "FELL SHORT of the target.";
		} else if (Game.guessedSpot == Game.manticoreSpot) {
			result = "was a DIRECT HIT!";
			manticoreHit();
		}
		Game.roundResult = "That round " + result;
	}
	
	private static void damageCalc() {
		String result = "";
		if (Game.roundCount % 3 == 0 && Game.roundCount % 5 == 0) {
			Game.damgeIfHit = "5";
		} else if (Game.roundCount % 3 == 0 || Game.roundCount % 5 == 0) {
			Game.damgeIfHit = "3";
		} else {
			Game.damgeIfHit = "1";
		}
		Game.damgeIfHit = "The cannon is expected to deal " + result + " damage this round.";
	}
	
	private static void manticoreHit () {
		if (Game.roundCount % 3 == 0 && Game.roundCount % 5 == 0) {
			Game.manticoreHealth -= 10;
		} else if (Game.roundCount % 3 == 0 || Game.roundCount % 5 == 0) {
			Game.manticoreHealth -= 3;
		} else {
			Game.manticoreHealth -= 1;
		}
		if (Game.manticoreHealth < 0) Game.manticoreHealth = 0;
	}
	
	private static void roundResult() {
		Game.cityHealth--;
		Game.roundCount++;
	}
	
	private static void displayRound () {
		System.out.println("------------------------------------------------------------");
		System.out.println("STATUS: Round: 1 City: " + Game.cityHealth + "/15, Manticore: " + Game.manticoreHealth + "/10");
		System.out.println(Game.damgeIfHit);
		System.out.println(Game.damgeIfHit);
		System.out.println("Entered desired cannon range: " + Game.guessedSpot);
		System.out.println(Game.roundResult);
		System.out.println("------------------------------------------------------------");
	}
}

class Game {
	static int roundCount;
	static int cityHealth;
	static int manticoreHealth;
	static int manticoreSpot;
	static int guessedSpot;
	static String damgeIfHit;
	static String roundResult;
	
	Game() {
		roundCount = 1;
		cityHealth = 15;
		manticoreHealth = 10;
		AskForNumberInRange spot = new AskForNumberInRange("How far away from the city do you want to station the Manticore?", 0, 100);
		manticoreSpot = spot.getResult();
		new ClearScreen();
	}
}