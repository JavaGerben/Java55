import java.util.Scanner;

public class Challenge16 {
	public static void main (String[] args) {
		Scanner myScanner = new Scanner(System.in);
		int captainNumber = 0;
		
		do {
			System.out.println ("Please enter a number between 0 and 100, cap.");
			captainNumber = myScanner.nextInt();
		} while (captainNumber <= 0 || captainNumber >= 100);
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
		System.out.println("Please guess the number.");
		
		int hunterNumber;
		do {
			hunterNumber = myScanner.nextInt();
			String guessNumberMsg;
			
			if (hunterNumber == captainNumber) {
				guessNumberMsg = "You've guessed right";
			} else if (hunterNumber < captainNumber) {
				guessNumberMsg = hunterNumber + " is to low.\nWaht is your next guess?";
			} else if (hunterNumber > captainNumber) {
				guessNumberMsg = hunterNumber + " is to high.\nWaht is your next guess?";
			} else {
				guessNumberMsg = "not valid";
			}
			System.out.println(guessNumberMsg);
		} while (hunterNumber != captainNumber);
	}
}