import java.util.Scanner;

public class challange11 {
	public static void main (String[] args) {
		int targetRow;
		int targetColumn;
		int eastOfTarget;
		int westOfTarget;
		int northOfTarget;
		int southOfTarget;
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("What is the target row?");
		targetRow = myScanner.nextInt();
		System.out.println("what is the target column?");
		targetColumn = myScanner.nextInt();
		
		eastOfTarget = targetColumn + 1;
		westOfTarget = targetColumn -1;
		northOfTarget = targetRow - 1;
		southOfTarget = targetRow + 1;
		
		System.out.println("deploy to:");
		
		System.out.println("(" + targetRow + ", " + eastOfTarget + ")"); 		//field east of the target
		System.out.println("(" + targetRow + ", " + westOfTarget + ")");		//field west of the target
		System.out.println("(" + northOfTarget + ", " + targetColumn + ")");	//field north of the target
		System.out.println("(" + southOfTarget + ", " + targetColumn + ")");	//field south of the target
	}
}