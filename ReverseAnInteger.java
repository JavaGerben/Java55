import java.util.Scanner;

public class ReverseAnInteger {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("Please enter a string.");
		String input = myScanner.nextLine();
		
		for (int i = 0; i < input.length(); i++) {
			System.out.print(input.charAt((input.length()-i-1)));
		}
	}
}