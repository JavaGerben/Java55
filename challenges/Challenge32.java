package challenges;
import java.util.*;

public class Challenge32 {
	public static void main (String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("The password must be between 5 and 14 characers.");
		System.out.println("It must also contain one upper and lower case letter, and contain one number.");
		System.out.println("Resrticted characters are the capital \"T\" and the \"&\".");
		
		System.out.println("Please input a password conforming to the rules:");
		PasswordValidator password = new PasswordValidator( myScanner.nextLine());
		
		if (password.getCcorrectPassword()) {
			System.out.println("Your password meets all the criteria.");
		} else {
			System.out.println("Your password does not meets all the criteria.");
		}
		System.out.println();
		main(null);
	}
}

public class PasswordValidator {
	private String password;
	private boolean correctPassword;
	
	public PasswordValidator (String password) {
		correctPassword = false;
		passwordSetter (password);
	}
	
	public boolean getCcorrectPassword() {
		return correctPassword;
	}
	
	private void passwordSetter (String password) {
		boolean between5and13Chars = false;
		boolean oneUpperCase = false;
		boolean oneLowerCase = false;
		boolean oneNumber = false;
		boolean noCapitalT = false;
		boolean noAndSign = false;
		
		if (password.length() >= 6 && password.length() <= 13) {
			between5and13Chars = true;
			for (char ch: password.toCharArray()) {
				if(Character.isUpperCase(ch)) {
					oneUpperCase = true;
				} else if (Character.isLowerCase(ch)){
					oneLowerCase = true;
				} else if (Character.isDigit(ch)) {
					oneNumber = true;
				} else if (ch == 'T') {
					noCapitalT = true;
				} else if (ch == '&') {
					noAndSign = true;
				}
			}
		}
		if (between5and13Chars && oneUpperCase && oneLowerCase && oneNumber && !noCapitalT && !noAndSign) {
			this.password = password;
			correctPassword = true;
		}
	}
}