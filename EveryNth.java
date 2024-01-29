import java.util.Scanner;

public class EveryNth {
	public static void main (String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("Pease input a string.");
		String myString = myScanner.nextLine();
		System.out.println("Please input a number.");
		int myInt = myScanner.nextInt();
		
		System.out.println(letterPicker(myInt, myString));
	}
	private static String letterPicker(int numberJump, String theLetters) {
		int placement = 0;
		String result = "";
		
		while (placement <= theLetters.length()) {
			result = result + theLetters.charAt(placement);
			placement += numberJump;
		}
		return result;
	}
}

/* ik heb bij deze opdracht en bij Factorial.java beide keren while gebruikt, terwijl in de uitleg een for gebruikt werd
 * is dit erg, maakt dit veel verschil?
 */