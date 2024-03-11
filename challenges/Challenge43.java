package challenges;
import weapons.*;

public class Challenge43 {
	public static void main (String[] args) {
		Sword sword = new Sword();
		Bow bow = new Bow();
		Axe axe = new Axe();
		
		Colored item1 = new Colored<Sword> (sword, "blue");
		Colored item2 = new Colored<Bow> (bow, "red");
		Colored item3 = new Colored<Axe> (axe, "green");
		
		item1.display();
		item2.display();
		item3.display();
	}
}

class Colored<T> {
	private T itemT;
	private String StringK;
	
	public Colored (T itemT, String StringK) {
		this.itemT = itemT;
		this.StringK = StringK;
	}
	
	public void display() {
		String color = switch(StringK.toLowerCase()) {
			case "reset", "white"	-> "\u001B[0m";
			case "black"			-> "\u001B[30m";
			case "red" 				-> "\u001B[31m";
			case "green"			-> "\u001B[32m";
			case "yellow"			-> "\u001B[33m";
			case "blue"				-> "\u001B[34m";
			default					-> "";
		};
		System.out.println(color + itemT + "\u001B[0m");
	}
}