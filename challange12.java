import java.util.Scanner;

public class challange12 {
	public static void main (String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("please enter a number");
		int time = myScanner.nextInt();
		time = time % 2;
		if (time == 0) {
			System.out.println("Tick");
		} else if (time == 1) {
			System.out.println("Tock");
		}
	}
}