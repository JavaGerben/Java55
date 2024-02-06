import java.util.*;

public class Hangman {
	static Scanner myScanner = new Scanner(System.in);
	
	public static void main (String[] args) {
		System.out.println ("This is a game of hangman, player one please enter a word:");
		String theWord = myScanner.nextLine();
		theWord = theWord.toUpperCase();
		
		for (int i = 0; i < 100; i++) {
			System.out.println();
		}
		
		boolean wordFilled = false;
		ArrayList<Character> guessedLetters = new ArrayList<>();
		System.out.println ("Player 2, please guess a letter.");
		char guessedChar = Character.toUpperCase(myScanner.next().charAt(0));
		int roundCounter = 0;
		
		while (!wordFilled && roundCounter < 10) {
			if (!guessedLetters.contains(guessedChar)) {
				guessedLetters.add(guessedChar);
			}
			
			boolean noUnderscores = true;
			for (char letter : theWord.toCharArray()) {
				if (guessedLetters.contains(letter)) {
					System.out.print(letter);
				} else {
					System.out.print("_");
					noUnderscores = false;
				}
			}
			
			System.out.println();
			
			if (noUnderscores) {
				wordFilled = true;
				System.out.println("Player 2 has won the game.");
			}
			
			if (!wordFilled) {
				System.out.println ("Player 2, please guess a letter.");
				guessedChar = Character.toUpperCase(myScanner.next().charAt(0));
			}
			roundCounter++;
		}
		if (!wordFilled) {
			System.out.println("Player 1 has won the game, because you took more then 10 turns to guess the word.");
		}
	}
}