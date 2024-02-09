package util;
import java.util.*;

public class AskForNumberInRange {
	Scanner myScanner = new Scanner(System.in);
	private int result;
	private boolean done;
	
	public AskForNumberInRange(String text, int min, int max) {
		System.out.println(text);
		
		result = 0;
		done = false;
		
		while (!done) {
			try {
				result = myScanner.nextInt();
				if (result >= min && result <= max)
					done = true;
				else 
					System.out.println("Please enter a value between " + min + " and " + max);
			} catch (InputMismatchException e) {
				System.out.println("Please enter a value between " + min + " and " + max);
				myScanner.next();
			}
		}
	}
	public int getResult() {
		return result;
	}
}