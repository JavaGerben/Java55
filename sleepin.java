import java.util.Scanner;

public class sleepin {
	public static void main (String[] args) {
		Scanner myScanner = new Scanner(System.in);
		boolean weekday;
		boolean vacation;
		boolean sleepIn;
		
		System.out.println("Is it a weekday?");
		String answer = myScanner.nextLine();
		if (answer.equals("yes") || answer.equals("true")) {
			weekday = true;
		} else {
			weekday = false;
		}
		System.out.println("Are you on vacation?");
		answer = myScanner.nextLine();
		if (answer.equals("yes") || answer.equals("true")) {
			vacation = true;
		} else {
			vacation = false;
		}
		
		if (!weekday || vacation) {
			sleepIn = true;
		} else {
			sleepIn = false;
		}
		
		System.out.println("the return value is: " + sleepIn);
	}
}