import java.util.Scanner;

public class posNeg {
	public static void main (String[] args) {
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Please enter the first value.");
		int tempInput1 = myScanner.nextInt();
		System.out.println("Please enter the second value.");
		int tempInput2 = myScanner.nextInt();
		System.out.println("Please enter true or false.");
		System.out.println(testNegative(tempInput1, tempInput2, myScanner.nextBoolean()));
	}
	
	static boolean testNegative(int number1, int number2, boolean bool) {
		if (bool && number1 < 0 && number2 < 0) {
			return true;
		} else if (!bool) {
			if ((number1 >= 0 && number2 < 0) || (number1 < 0 && number2 >= 0)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}