import java.util.Scanner;

public class Fibonacci {
	public static void main (String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("Please input the number to which you want the fibonacci sequence to go to.");
		int input = myScanner.nextInt();
		int oldNum = 1;
		int newNum = 1;
		
		System.out.print(oldNum);
		
		while (newNum <= input) {
			System.out.print(" " + newNum);
			oldNum = newNum;
			newNum += oldNum;
		}
	}
}