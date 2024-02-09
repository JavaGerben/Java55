package util
import java.util.*;

public class AskFor {
	static Scanner myScanner = new Scanner(System.in);
	
	
	public static int askForNumber(String text) {
		System.out.println(text);
		
		int result = 0;
		
		while (result == 0) {
			try {
				result = myScanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("This is not a number, please enter a number");
				myScanner.next();
			}
		}
		return result;
	}
	
	
}