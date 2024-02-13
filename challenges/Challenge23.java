package challenges;
import java.util.*;

public class Challenge23 {
	static Scanner myScanner = new Scanner(System.in);
	public static void main (String[] args) {
		Chest chestStatus = Chest.OPEN;
		
		chestAction(chestStatus);
	}
	
	static void chestAction(Chest chestStatus) {
		if (chestStatus == Chest.OPEN) {
			System.out.print("The chest is open. What do you want to do? ");
			chestStatus = switch (myScanner.nextLine().toLowerCase().trim()) {
				case "close" -> Chest.CLOSED;
				default -> Chest.OPEN;
			};
		} else if (chestStatus == Chest.CLOSED) {
			System.out.print("The chest is closed. What do you want to do? ");
			chestStatus = switch (myScanner.nextLine().toLowerCase().trim()) {
				case "open" -> Chest.OPEN;
				case "lock" -> Chest.LOCKED;
				default -> Chest.CLOSED;
			};
		} else if (chestStatus == Chest.LOCKED) {
			System.out.print("The chest is locked. What do you want to do? ");
			chestStatus = switch (myScanner.nextLine().toLowerCase().trim()) {
				case "unlock" -> Chest.CLOSED;
				default -> Chest.LOCKED;
			};
		}
		chestAction(chestStatus);
	}
}
enum Chest {
	OPEN,
	CLOSED,
	LOCKED
}