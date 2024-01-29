import java.util.Scanner;

public class challange13 {
	public static void main (String[] args) {
		Scanner myScanner = new Scanner(System.in);
		String locationMsg = "ERROR: no data on enimy.";
		
		System.out.println("What is the X coordinate?");
		int xCoord = myScanner.nextInt();
		System.out.println("What is the Y coordinate?");
		int yCoord = myScanner.nextInt();
		
		if (xCoord == 0 && yCoord == 0) {
			locationMsg = "The enimy is here!";							//Here
		} else if (xCoord == 0 && yCoord > 0) {
			locationMsg = "The enimy is north";							//North
		} else if (yCoord > 0 && xCoord > 0) {
			locationMsg = "the enimy is to the north east";				//North east
		} else if (xCoord > 0 && yCoord == 0) {
			locationMsg = "The enimy is east.";							//East
		} else if (xCoord > 0 && yCoord < 0) {
			locationMsg = "The enimy is south east";					//south east
		} else if (xCoord == 0 && yCoord < 0) {
			locationMsg = "The enimy is south";							//South
		} else if (xCoord < 0 && yCoord < 0) {
			locationMsg = "The enimy is south west";					//South west
		} else if (xCoord < 0 && yCoord == 0) {
			locationMsg = "The enimy is west";							//West
		} else if (xCoord < 0 && yCoord > 0) {
			locationMsg = "The enimy is north west";					//North west
		}
		System.out.println(locationMsg);
	}
}