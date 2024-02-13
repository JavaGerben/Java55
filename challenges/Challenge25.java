package challenges;
import java.util.*;

public class Challenge25 {
	static Scanner myScanner = new Scanner(System.in);
	public static void main (String[] args) {
	
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