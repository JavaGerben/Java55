package challenges;
import java.util.*;

public class Challenge24 {
	static Scanner myScanner = new Scanner(System.in);
	public static void main (String[] args) {
		do getFood();
		while (Combination.food == null);
		
		do getIngredient();
		while (Combination.ingredient == null);
		
		do getSeasoning();
		while (Combination.seasoning == null);
		
		System.out.println("We will prepare a " + Combination.food + " with " + 
							Combination.ingredient + " and make it " + Combination.seasoning);
	}
	
	static void getFood() {
		System.out.println("What food type do you want? You can pick any of these options: ");
		System.out.println(java.util.Arrays.asList(Food.values()));
		Combination.food =  switch (myScanner.nextLine().toLowerCase()) {
			case "soup" 	-> Food.SOUP;
			case "stew" 	-> Food.STEW;
			case "gumbo" 	-> Food.GUMBO;
			default -> null;
		};
	}
	
	static void getIngredient() {
		System.out.println("What Ingredient do you want? You can pick any of these options: ");
		System.out.println(java.util.Arrays.asList(Ingredient.values()));
		Combination.ingredient =  switch (myScanner.nextLine().toLowerCase()) {
			case "mushrooms", "mushroom" 	-> Ingredient.MUSHROOMS;
			case "chicken" 					-> Ingredient.CHICKEN;
			case "carrots", "carrot" 		-> Ingredient.CARROTS;
			case "potatoes", "potatoe"		-> Ingredient.POTATOES;
			default -> null;
		};
	}
	
	static void getSeasoning() {
		System.out.println("What seasoning do you want? You can pick any of these options: ");
		System.out.println(java.util.Arrays.asList(Seasoning.values()));
		Combination.seasoning =  switch (myScanner.nextLine().toLowerCase()) {
			case "spicy" -> Seasoning.SPICY;
			case "salty" -> Seasoning.SALTY;
			case "sweet" -> Seasoning.SWEET;
			default -> null;
		};
	}
}
enum Food {
	SOUP,
	STEW,
	GUMBO
}

enum Ingredient {
	MUSHROOMS,
	CHICKEN,
	CARROTS,
	POTATOES
}

enum Seasoning {
	SPICY,
	SALTY,
	SWEET
}

class Combination {
	static Food food;
	static Ingredient ingredient;
	static Seasoning seasoning;
}