import java.util.Scanner;

public class max1020 {
	public static void main (String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("please input the first number");
		int tempNumber = myScanner.nextInt();
		System.out.println("please input the second number");
		System.out.println(max(tempNumber, myScanner.nextInt()));
	}
	
	static int max(int firstNumber, int secondNumber) {
		if ((firstNumber < 10 || firstNumber > 20) && (secondNumber < 10 || secondNumber > 20)) {
			return 0;
		} else if (firstNumber < 10 || firstNumber > 20) {
			return secondNumber;
		} else if (secondNumber < 10 || secondNumber > 20) {
			return firstNumber;
		} else if (firstNumber >= secondNumber) {
			return firstNumber;
		} else {
			return secondNumber;
		}
	}
}