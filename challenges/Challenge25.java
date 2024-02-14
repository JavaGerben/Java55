package challenges;
import java.util.*;
import util.*;

public class Challenge25 {
	static Scanner myScanner = new Scanner(System.in);
	
	public static void main (String[] args) {
		do getArrowhead();
		while (Arrow.arrowhead == null);
		
		AskForNumberInRange arrowTemp = new AskForNumberInRange("What arrow length would you like, between 60 and 100 cm", 60, 100);
		Arrow.arrowLength = arrowTemp.getResult();
		
		do getFletching();
		while (Arrow.fletching == null);
		
		getCost();
	}
	
	static void getArrowhead() {
		System.out.println("What arrowhead would you like, here are your options:");
		System.out.println(java.util.Arrays.asList(Arrowhead.values()));
		
		Arrow.arrowhead =  switch (myScanner.nextLine().toLowerCase()) {
			case "steel" 		-> Arrowhead.STEEL;
			case "wood" 		-> Arrowhead.WOOD;
			case "obsidian" 	-> Arrowhead.OBSIDIAN;
			default 			-> null;
		};
	}
	
	static void getFletching() {
		System.out.println("What fletching would you like, here are your options:");
		System.out.println(java.util.Arrays.asList(Fletching.values()));
		
		Arrow.fletching =  switch (myScanner.nextLine().toLowerCase()) {
			case "plastic" 											-> Fletching.PLASTIC;
			case "turkey", "turkey feather", "turkey feathers"		-> Fletching.TURKEY_FEATHER;
			case "goose", "goose feather", "goose feathers"			-> Fletching.GOOSE_FEATHER;
			default 												-> null;
		};
	}
	
	static void getCost() {
		float total = 0.0f;
		total += switch (Arrow.arrowhead) {
			case STEEL		-> 10;
			case WOOD 		-> 3;
			case OBSIDIAN	-> 5;
			default 		-> 0;
		};
		
		total += switch (Arrow.fletching) {
			case PLASTIC			-> 10;
			case TURKEY_FEATHER 	-> 5;
			case GOOSE_FEATHER		-> 3;
			default 				-> 0;
		};
		
		total += Arrow.arrowLength * 0.05;
		
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
	static Arrowhead arrowhead;
	static Fletching fletching;
	static int arrowLength;
}