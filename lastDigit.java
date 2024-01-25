import java.util.Scanner;


public class lastDigit {
	public static void main (String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("Please enter the first number.");
		int modAnswer1 = myScanner.nextInt();
		System.out.println("Please enter the second number.");
		int modAnswer2 = myScanner.nextInt();
		
		if (modAnswer1 >= 10) {
			modAnswer1 = modAnswer1 % 10;
		}
		if (modAnswer2 >= 10) {
			modAnswer2 = modAnswer2 % 10;
		}
		
		if (modAnswer1 == modAnswer2) {
			System.out.println ("the last digits are the same.");
		} else {
			System.out.println ("the last digits are not the same.");
		}
	}
}