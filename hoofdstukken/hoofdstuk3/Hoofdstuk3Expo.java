import java.util.*;

public class Hoofdstuk3Expo {
	public static void main (String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		System.out.print("Geef de basis: ");
		int baseNumber = myScanner.nextInt();
		System.out.print("Geef de exponent: ");
		int expoNumber = myScanner.nextInt();
		System.out.print(baseNumber + " tot de macht " + expoNumber + " is: " + exponent(baseNumber, expoNumber));
	}
	
	private static int exponent(int baseNumber, int expoNumber) {
		int result = baseNumber * baseNumber;
		for (int i = 2; i <  expoNumber; i++) {
			result *= baseNumber;
		}
		return result;
	}
}