import java.util.Scanner;

public class or35 {
	public static void main (String[] args) {
		Scanner myScannner = new Scanner(System.in);
		
		System.out.println("Please write a number");
		int numberInput = myScannner.nextInt();
		
		if (numberInput >= 0 && numberInput % 3 == 0 || numberInput >= 0 && numberInput % 5 == 0) {
			System.out.println ("true");
		} else {
			System.out.println ("false");
		}
	}
}