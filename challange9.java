import java.util.Scanner;

public class challange9 {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("How many eggs have been collected today?");
		int eggAmount = myScanner.nextInt();
		int duckbearEggs = eggAmount % 4;
		eggAmount = eggAmount - duckbearEggs;
		int sisterEggs = eggAmount / 4;
		System.out.println("The sisters get " + sisterEggs + " eggs each. And the duckbear gets " + duckbearEggs +".");
		// the duckbear gets more when there are 1, 2, 3, 6, 7 ore 11 eggs.
	}
}