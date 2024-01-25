import java.util.Scanner;

public class CheckIfNumberIsEvenOrOdd {
	public static void main (String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("Imput a number");
		System.out.println(evenOrNot(myScanner.nextInt()));
	}
	
	static int evenOrNot(int number) {
		number %= 2;
		if (number == 0) {
			return 1;
		} else {
			return 0;
		}
	}
}