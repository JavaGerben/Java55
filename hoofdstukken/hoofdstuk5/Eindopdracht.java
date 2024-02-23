import java.util.*;

public class Eindopdracht {
	public static void main (String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		System.out.print("Please input a sentence: ");
		String input = myScanner.nextLine();
		System.out.println();
		
		System.out.println("Aantal karakters: " + input.toCharArray().length);
		System.out.println("Aantal woorden:   " + input.split("\\s").length);
		System.out.println("Aantal klinkers:  " + amountOfVowels(input));
		System.out.println("Palindroom?       " + palindroom(input));
		graphic(input);
	}
	
	public static int amountOfVowels(String input) {
		int vowelCount = 0;
		for (char ch : input.toCharArray()) {
			switch(ch) {
				case 'a', 'e', 'i', 'o', 'u', 'y':
					vowelCount++;
					break;
			};
		}
		return vowelCount;
	}
	
	public static boolean palindroom (String input) {
		input = input.replace(" ", "");
		int startLetter = 0;
		int endLetter = input.length() - 1;
		
		while(startLetter < endLetter) {
			if (input.charAt(startLetter) != input.charAt(endLetter)) {
				return false;
			}
			startLetter++;
			endLetter--;
		}
		return true;
	}
	
	public static void graphic (String input) {
		ArrayList<Integer> characterCounts = new ArrayList<>();
		char[] allCharacters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'v', 
					'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ' '};
		
		for (char ch : allCharacters) {
			characterCounts.add(letterCounter(ch, input));
		}
		
		int highestIndex = Collections.max(characterCounts);
		for (int row = highestIndex; row > 0; row--) {
			for (int ch = 0; ch < allCharacters.length; ch++) {
				if (characterCounts.get(ch) >= row) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		for (char ch : allCharacters) {
			System.out.print(ch + " ");
		}
	}
	
	public static int letterCounter(char letter, String input) {
		int letterCount = 0;
		for (char ch : input.toCharArray()) {
			if (ch == letter) {
				letterCount++;
			}
		}
		return letterCount;
	}
}