import java.util.Scanner;

public class NotString {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("please input a string");
		String inputText = myScanner.nextLine();
		
		if (notString(inputText)){		
			System.out.println(inputText.substring(4));
		} else {
			System.out.println("not " + inputText);
		}
	}

	static boolean notString(String text) {
		if(text.startsWith("not ")) return true;
		else return false;
	}
}