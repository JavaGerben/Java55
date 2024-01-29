import java.util.Scanner;

public class Factorial {
	public static void main (String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("This will calculate the factorial of any number above 0 that you type in in below.");
		int input = myScanner.nextInt();
		int total = 1;
		
		while (input > 1) {
			total *= input;
			input--;
		}
		System.out.println(total);
	}
}