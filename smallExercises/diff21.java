import java.util.Scanner;

public class diff21 {
	public static void main (String[] args) {
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Please enter your value");
		System.out.println(diff(myScanner.nextInt()));
	}
	
	static String diff(int number) {
		int resultNumber;
		if (number > 21) { 
			resultNumber = (number - 21) * 2;
		} else {
			resultNumber = 21 - number;
		}
		return ("diff21(" + number + ") -> " + resultNumber);
	}
}