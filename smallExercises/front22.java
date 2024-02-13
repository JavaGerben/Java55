import java.util.Scanner;

public class front22 {
	public static void main (String[] args) {
		Scanner myScanner = new Scanner(System.in);
		String output;
		String intake;
		
		System.out.println("Please enter your word.");
		intake = myScanner.nextLine();
		
		if (intake.length() < 2 && intake != null) {
			output = intake.substring(0, 1) + intake + intake.substring(0, 1);
			System.out.println(output);
		} else if (intake != null) {
			output = intake.substring(0, 2) + intake + intake.substring(0, 2);
			System.out.println(output);
		}
	}
}