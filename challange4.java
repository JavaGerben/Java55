import java.util.Scanner;

public class challange4 {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("Bread is ready.");
		System.out.println("who is the bread for?");
		
		String userName = myScanner.nextLine();
		System.out.println("the bread is for " + userName +".");
	}
}