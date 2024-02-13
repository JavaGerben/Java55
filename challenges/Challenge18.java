import java.util.Scanner;

public class Challenge18 {
	public static void main (String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		int[] firstArray = new int[5];
		System.out.print("Please enter 5 numbers:/nNumber 1: ");
		firstArray[0] = myScanner.nextInt();
		System.out.print("Number 2: ");
		firstArray[1] = myScanner.nextInt();
		System.out.print("Number 3: ");
		firstArray[2] = myScanner.nextInt();
		System.out.print("Number 4: ");
		firstArray[3] = myScanner.nextInt();
		System.out.print("Number 5: ");
		firstArray[4] = myScanner.nextInt();
		
		int[] secondArray = new int[5];
		
		for (int i = 0; i < firstArray.length; i++) {
			secondArray[i] = firstArray[i];
			System.out.println("Value " + i + " of firstArray: " + firstArray[i]);
			System.out.println("Value " + i + " of secondArray: " + secondArray[i] + "\n");
		}
	}
}