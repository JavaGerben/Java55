import java.util.Scanner;
import java.util.HashMap;

public class challange10 {
	public static void main (String[] args) {
		Scanner myScanner = new Scanner(System.in);
		int points;
		int estate;
		int duchies;
		int province;
		
		System.out.println("How many estates do you have?");
		estate = myScanner.nextInt();
		System.out.println("How many estates do you have?");
		duchies = myScanner.nextInt();
		System.out.println("How many provinces do you have?");
		province = myScanner.nextInt();
		points = (estate*1) + (duchies*3) + (province*6);
		if (points == 1) {
			System.out.println("You have " + points + " point.");
		} else {
			System.out.println("You have " + points + " points.");
		}
	}
}