import java.util.Scanner;

public class IsPrime {
	public static void main (String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		System.out.print("Please enter a positive number that you want to check if it is a prime number: ");
		int checkPrime = myScanner.nextInt();
		int i = 2;
		boolean devinderFound = false;
		String textOutput = " is a prime number";
		
		while (i <= (checkPrime/2) && !devinderFound) {
			if (checkPrime % i == 0)  {
				devinderFound = true;
				textOutput = " is not a prime number";
			}
			if (i % 2 == 0 ) i++;
			else i += 2;
		}
		System.out.println(checkPrime + textOutput);
	}
}