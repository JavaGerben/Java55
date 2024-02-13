import java.util.*;

public class Hoofdstuk3Even {
	public static void main (String[] args) {
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Please input a number");
		int testedNumber = myScanner.nextInt();
		System.out.println(isEven(testedNumber));
	}
	
	private static boolean isEven(int testedNumber) {
		if(testedNumber % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}
}