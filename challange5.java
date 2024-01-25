import java.util.Scanner; 

public class challange5 {
	public static void main(String[] args) {
		System.out.println("What kind of thing are we talking about?");
		Scanner input = new Scanner(System.in);
		String a = input.next();
		System.out.println("How would you describe it? Big? Azure? Tattered?");
		String b = input.next();
		String c = "of Doom";
		String d = "3000";
		System.out.println("The " + b + " " + a + " of " + c + " " + d + "!");
	}
}