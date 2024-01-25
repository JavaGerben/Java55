public class challange17 {
	public static void main (String[] args) {
		boolean divisibleBy3;
		boolean divisibleBy5;
		String countMsg;
		String colourText;
		
		for (int i = 1; i < 100; i++) {
			if (i % 3 == 0) {
				divisibleBy3 = true;
			} else { 
				divisibleBy3 = false;
			}
			if (i % 5 == 0) {
				divisibleBy5 = true;
			} else {
				divisibleBy5 = false;
			}
			if (divisibleBy3 && divisibleBy5) {
				countMsg = "Electric fire!";
				colourText = "\u001B[34m";		//blue text
			} else if (divisibleBy3) {
				countMsg = "Fire";
				colourText = "\u001B[31m";		//red text
			} else if (divisibleBy5) {
				countMsg = "Electric";
				colourText = "\u001B[33m";		//yellow text
			} else {
				countMsg = "Normal";
			}
			System.out.println (colourText + 1 + ": " + countMsg);
			System.out.print("\u001B[37m"); 	//set colour of text back to white
		}
	}
}