import java.util.Scanner; 

public class Challenge5 {
	public static void main(String[] args) {
		System.out.println("What kind of thing are we talking about?");
		Scanner input = new Scanner(System.in);
		String a = input.next();	//possibly a part of the program of string c
		System.out.println("How would you describe it? Big? Azure? Tattered?");
		String b = input.next();	//possibly a preposition of string a
		String c = "Doom";			//removed "of" becuase it prented it twice. its possibly name of a program 
		String d = "3000";			//possibly a version number
		System.out.println("The " + b + " " + a + " of " + c + " " + d + "!");
	}
}

// missing comments in this file, i tried to fill the blanks where ever i could