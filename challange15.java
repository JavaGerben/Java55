import java.util.Scanner;

public class challange15 {
	public static void main (String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("The following items are available:\n");
		System.out.println("1. Rope\n2. Torches\n3. Climbing Equipment\n4. Clean Water\n5. Machete\n6. Canoe\n7. Food Supplies\n");
		System.out.println("What number do you want to see the price of?");
		int itemNumber = myScanner.nextInt();
		myScanner.nextLine();  //Consume newline left-over
		System.out.println("And what is your name?");
		String userName = myScanner.nextLine();
		float price = switch (itemNumber) {
			case 1 -> 10;
			case 2 -> 15;
			case 3 -> 25;
			case 4 -> 1;
			case 5 -> 20;
			case 6 -> 200;
			case 7 -> 1;
			default -> 0;
		};
		if (userName.equals("Gerben")) {
			price /= 2;
		}	
		System.out.println("The price of that item is: " + price + ".");
	}
}