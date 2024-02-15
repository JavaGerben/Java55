package challenges;
import java.util.*;
import util.*;

public class Challenge27 {
	static Scanner myScanner = new Scanner(System.in);
	
	public static void main (String[] args) {
		System.out.println("Would you like one of the 3 pre-made arrows, or make a custom one?");
		System.out.println("1. Elite arrow");
		System.out.println("2. Beginner arrow");
		System.out.println("3. Marksman arrow");
		System.out.println("4. Custom arrow");
		int arrowOptions;
		
		do {
			System.out.println("Please select the number of the option you want.");
			arrowOptions = myScanner.nextInt();
			myScanner.nextLine();
		} while (arrowOptions != 1 && arrowOptions != 2 && arrowOptions != 3 && arrowOptions != 4); 
			
		if (arrowOptions == 1) {
			Arrow arrow1 = Arrow.createEliteArrow();
			getCost(arrow1);
		} else if (arrowOptions == 2) {
			Arrow arrow1 = Arrow.createBeginnerArrow();
			getCost(arrow1);
		} else if (arrowOptions == 3) {
			Arrow arrow1 = Arrow.createMarksmanArrow();
			getCost(arrow1);
		} else if (arrowOptions == 4) {
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
		
		System.out.println("\nThe total cost is: " + total + " gold.");
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
	
	public Arrow () {}
	
	private Arrow(Arrowhead arrowHead, Fletching fletching, int arrowLength){
		this.arrowhead = arrowHead;
		this.fletching = fletching;
		this.arrowLength = arrowLength;
	}
	
	public static Arrow createEliteArrow() {
		return new Arrow(Arrowhead.STEEL, Fletching.PLASTIC, 95);
	}
	
	public static Arrow createBeginnerArrow() {
		return new Arrow(Arrowhead.WOOD, Fletching.GOOSE_FEATHER, 75);
	}
	
	public static Arrow createMarksmanArrow() {
		return new Arrow(Arrowhead.STEEL, Fletching.GOOSE_FEATHER, 65);
	}
	
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