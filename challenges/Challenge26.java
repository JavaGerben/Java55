package challenges;
import java.util.*;
import util.*;

public class Challenge26 {
	static Scanner myScanner = new Scanner(System.in);
	
	public static void main (String[] args) {
		Arrow arrow1 = new Arrow();
		do {
			System.out.println("What arrowhead would you like, here are your options:");
			System.out.println(java.util.Arrays.asList(Arrowhead.values()));
			
			arrow1.setArrowhead(
				switch (myScanner.nextLine().toLowerCase()) {
					case "steel" 		-> Arrowhead.STEEL;
					case "wood" 		-> Arrowhead.WOOD;
					case "obsidian" 	-> Arrowhead.OBSIDIAN;
					default 			-> null;
				}
			);
		} while (arrow1.getArrowhead() == null);
		
		AskForNumberInRange arrowTemp = new AskForNumberInRange("What arrow length would you like, between 60 and 100 cm", 60, 100);
		arrow1.setArrowLength(arrowTemp.getResult());
		
		do {
			System.out.println("What fletching would you like, here are your options:");
			System.out.println(java.util.Arrays.asList(Fletching.values()));
			
			arrow1.setFletching(
				switch (myScanner.nextLine().toLowerCase()) {
					case "plastic" 											-> Fletching.PLASTIC;
					case "turkey", "turkey feather", "turkey feathers"		-> Fletching.TURKEY_FEATHER;
					case "goose", "goose feather", "goose feathers"			-> Fletching.GOOSE_FEATHER;
					default 												-> null;
				}
			);
		} while (arrow1.getFletching() == null);
		
		getCost(arrow1);
	}
	
	static void getCost(Arrow arrow1) {
		float total = 0.0f;
		total += switch (arrow1.getArrowhead()) {
			case STEEL		-> 10;
			case WOOD 		-> 3;
			case OBSIDIAN	-> 5;
			default 		-> 0;
		};
		
		total += switch (arrow1.getFletching()) {
			case PLASTIC			-> 10;
			case TURKEY_FEATHER 	-> 5;
			case GOOSE_FEATHER		-> 3;
			default 				-> 0;
		};
		
		total += arrow1.getArrowLength() * 0.05;
		
		System.out.println("The total cost is: " + total + " gold.");
	}
}
enum Arrowhead {
	STEEL,
	WOOD,
	OBSIDIAN
}

enum Fletching {
	PLASTIC,
	TURKEY_FEATHER,
	GOOSE_FEATHER
}

class Arrow {
	private Arrowhead arrowhead;
	private Fletching fletching;
	private int arrowLength;
	
	public void setArrowhead(Arrowhead arrowhead) {
		this.arrowhead = arrowhead;
	}
	
	public Arrowhead getArrowhead() {
		return this.arrowhead;
	}
	
	public void setFletching(Fletching fletching) {
		this.fletching = fletching;
	}
	
	public Fletching getFletching() { 
		return this.fletching;
	}
	
	public void setArrowLength(int arrowLength) {
		this.arrowLength = arrowLength;
	}
	
	public int getArrowLength() {
		return this.arrowLength;
	}
}