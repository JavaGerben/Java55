package challenges;
import java.util.*;


public class Challenge23 {
	static Scanner myScanner = new Scanner(System.in);
	
	public static void main (String[] args) {
		System.out.println("Please set a 4 digid passcode.");
		int passcode = myScanner.nextInt();
		myScanner.nextLine();
		Door door = new Door(passcode);
		doorStatusAction(door);
	}
	
	
	static void doorStatusAction(Door door) {
		if (door.getDoorStatus() == DoorStatus.OPEN) {
			System.out.print("The door is open. What do you want to do? ");
			String input = myScanner.nextLine().toLowerCase();
			if (input.toLowerCase().equals("close")) {
				door.setDoorStatus(DoorStatus.CLOSED);
			} else if (input.equals(String.valueOf(door.getPasscode()))) {
				codeSetter(door);
			}
		} else if (door.getDoorStatus() == DoorStatus.CLOSED) {
			System.out.print("The door is closed. What do you want to do? ");
			String input = myScanner.nextLine().toLowerCase();
			if (input.toLowerCase().equals("open")) {
				door.setDoorStatus(DoorStatus.OPEN);
			} else if (input.toLowerCase().equals("lock")) {
				door.setDoorStatus(DoorStatus.LOCKED);
			} else if (input.equals(String.valueOf(door.getPasscode()))) {
				codeSetter(door);
			}
		} else if (door.getDoorStatus() == DoorStatus.LOCKED) {
			System.out.print("The door is locked. What do you want to do? ");
			String input = myScanner.nextLine().toLowerCase();
			if (input.equals("unlock")) {
				if (codeChecker(door)) {
					door.setDoorStatus(DoorStatus.CLOSED);
				}
			} else if (input.equals(String.valueOf(door.getPasscode()))) {
				codeSetter(door);
			}
		}
		doorStatusAction(door);
	}
	
	static boolean codeChecker (Door door) {
		System.out.println("Enter the code:");
		int passcode = myScanner.nextInt();
		myScanner.nextLine();
		if (passcode == door.getPasscode()) {
			System.out.println("You entered a valid code.");
			return true;
		} else {
			System.out.println("You entered an invalid code.");
			return false;
		}
	}
	
	static void codeSetter (Door door) {
		System.out.println("You entered the code.\nWould you like to change it?");
		String input = myScanner.nextLine();
		if (input.toLowerCase().equals("yes")) {
			System.out.println("Please set a 4 digid passcode.");
			door.setPasscode(myScanner.nextInt());
			myScanner.nextLine();
			System.out.println("the code has been changed.");
		}
	}
}
enum DoorStatus {
	OPEN,
	CLOSED,
	LOCKED
}

class Door {
	private int passcode;
	private DoorStatus doorStatus;
	
	public Door(int passcode) {
		this.passcode = passcode;
		doorStatus = DoorStatus.OPEN;
	}
	
	public DoorStatus getDoorStatus() {
		return doorStatus;
	}
	
	public void setDoorStatus(DoorStatus doorStatus) {
		this.doorStatus = doorStatus;
	}
	
	public int getPasscode() {
		return passcode;
	}
	
	public void setPasscode(int passcode) {
		this.passcode = passcode;
	}
}