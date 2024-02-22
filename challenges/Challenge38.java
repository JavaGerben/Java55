package challenges;
import java.util.*;

public class Challenge38 {
	static Scanner myScanner = new Scanner(System.in);
	static Pack pack;
	
	public static void main (String[] args) {
		startMenu();
	}
	
	private static void startMenu () {
		switch (printStartMenu()) {
			case 1:
				System.out.println();
				newPack();
				break;
			case 2:
				System.out.println();
				if (pack instanceof Pack) {
					packSatus();
				} else {
					System.out.println("Please first make a backpack.");
					System.out.println();
					startMenu();
				}
				break;
			case 3:
				System.out.println();
				if (pack instanceof Pack) {
					packingMenu();
				} else {
					System.out.println("Please first make a backpack.");
					System.out.println();
					startMenu();
				}
				break;
			case 4:
				System.out.println();
				System.out.println("Goodbye.");
				break;
			default:
				System.out.println();
				startMenu ();
		};
	}
	
	private static int printStartMenu() {
		System.out.println("Menu:");
		System.out.println("1. Start a new backpack (discarding others if you have them).");
		System.out.println("2. Check how the status of the backpack.");
		System.out.println("3. Add items to the backpack.");
		System.out.println("4. Quit");
		int result = myScanner.nextInt();
		myScanner.nextLine();
		return result;
	}
	
	private static void newPack () {
		System.out.println("How many items can the backpack hold?");
		int items = myScanner.nextInt();
		System.out.println("How much weight can the backpack hold?");
		double weight = myScanner.nextDouble();
		System.out.println("How much volume can the backpack hold?");
		double volume = myScanner.nextDouble();
		myScanner.nextLine();
		System.out.println();
		pack = new Pack(items, weight, volume);
		startMenu();
	}
	
	private static void printItemList () {
		System.out.println("This is a list of items you can put in your backpack.");
		System.out.println("1. An arrow, it has a weight of 0.1 and a volume of 0.05.");
		System.out.println("2. A bow, it has a weight of 1 and a volume of 4.");
		System.out.println("3. Rope, it has a weight of 1 and a volume of 1.5.");
		System.out.println("4. Water has a weight of 2 and a volume of 3.");
		System.out.println("5. Food rations have a weight of 1 and a volume of 0.5.");
		System.out.println("6. A sword has a weight of 5 and a volume of 3.");
		System.out.println("7. Back to start menu.");
		System.out.println();
	}
	
	private static void packingMenu () {
		printItemList();
		addItem();
	}
	
	private static void addItem () {
		InventoryItem arrow = new Arrow();
		InventoryItem bow = new Bow();
		InventoryItem rope = new Rope();
		InventoryItem water = new Water();
		InventoryItem food_rations = new Food_rations();
		InventoryItem sword = new Sword();
		
		System.out.println("Pick the number of the item you would like to add to you backpack.");
		InventoryItem chosenItem = null;
		switch (myScanner.nextLine()) {
			case "1":
				chosenItem = arrow;
				System.out.println("You try to add a arrow in to your backpack.");
				break;
			case "2":
				chosenItem = bow;
				System.out.println("You try to add a bow in to your backpack.");
				break;
			case "3":
				chosenItem = rope;
				System.out.println("You try to add a rope in to your backpack.");
				break;
			case "4":
				chosenItem = water;
				System.out.println("You try to add some water in to your backpack.");
				break;
			case "5":
				chosenItem = food_rations;
				System.out.println("You try to add some food rations in to your backpack.");
				break;
			case "6":
				chosenItem = sword;
				System.out.println("You try to add a sword in to your backpack.");
				break;
			case "7":
				System.out.println();
				startMenu();
				break;
			default:
				break;
		};
		
		if(chosenItem != null && pack.add(chosenItem)) {
			chosenItem = null;
			System.out.println("It fits! Now the item(s) in your backpack are:");
			System.out.println(pack.toString());
			System.out.println();
			packingMenu();
		} else if (chosenItem != null) {
			System.out.println("Item can't be added. The item(s) in your backpack are:");
			System.out.println(pack.toString());
			System.out.println();
			packingMenu();
		}
	}
	
	private static void packSatus() {
		ArrayList<InventoryItem> Items = pack.getItems();
		System.out.println("Amount of items in the backpack: " + pack.getItems().size() + "out of the max " + pack.getMaxNumberOfItems());
		System.out.println("Packed items weight " + pack.getTotalWeight() + " out of the max " + pack.getMaxWeight());
		System.out.println("Packed items volume " + pack.getTotalVolume() + " out of the max " + pack.getMaxVolume());
		System.out.println("");
		startMenu();
	}
}

class InventoryItem {
	private double weight;
	private double volume;
	
	public InventoryItem (double weight, double volume) {
		this.weight = weight;
		this.volume = volume;
	}
	
	public double getWeight () {
		return weight;
	}
	
	public double getVolume () {
		return volume;
	}
	
	@Override 
		public String toString() {
		return this.getClass().getName();
	}
}

class Arrow extends InventoryItem {
	public Arrow () {
		super(0.1, 0.05);
	}
}

class Bow extends InventoryItem {
	public Bow () {
		super(1, 4);
	}
}

class Rope extends InventoryItem {
	public Rope () {
		super(1, 1.5);
	}
}

class Water extends InventoryItem {
	public Water () {
		super(2,3);
	}
}

class Food_rations extends InventoryItem {
	public Food_rations () {
		super(1, 0.5);
	}
}

class Sword extends InventoryItem {
	public Sword () {
		super(5, 3);
	}
}

class Pack {
	private int maxNumberOfItems;
	private double maxWeight;
	private double maxVolume;
	private ArrayList<InventoryItem> items = new ArrayList<>();
	
	public Pack (int maxNumberOfItems, double maxWeight, double maxVolume) {
		this.maxNumberOfItems = maxNumberOfItems;
		this.maxWeight = maxWeight;
		this.maxVolume = maxVolume;
	}
	
	public boolean add (InventoryItem obj) {
		double totalWeight = 0;
		double totalVolume = 0;
		
		if (!items.isEmpty() && items.size() < maxNumberOfItems) {
			for (InventoryItem i : items) {
				totalWeight += i.getWeight();
				totalVolume += i.getVolume();
			}
			totalWeight += obj.getWeight();
			totalVolume += obj.getVolume();
			if (totalWeight <= maxWeight && totalVolume <= maxVolume) {
				items.add(obj);
				return true;
			}
		} else if(items.isEmpty()) {
			totalWeight += obj.getWeight();
			totalVolume += obj.getVolume();
			items.add(obj);
			return true;
		}
		return false;
	}
	
	public double getTotalWeight () {
		double totalWeight = 0;
		for (InventoryItem i : items) {
			totalWeight += i.getWeight();
		}
		return totalWeight;
	}
	
	public double getTotalVolume () {
		double totalVolume = 0;
		for (InventoryItem i : items) {
			totalVolume += i.getVolume();
		}
		return totalVolume;
	}
	
	public int getMaxNumberOfItems () {
		return maxNumberOfItems;
	}
	
	public double getMaxWeight () {
		return maxWeight;
	}
	
	public double getMaxVolume () {
		return maxVolume;
	}
	
	public ArrayList<InventoryItem> getItems () {
		return items;
	}
	
	@Override 
	public String toString() {
		String names = "";
		for (InventoryItem item : items) {
			names = names + item.toString().replace("challenges.", "") + " ";
		}
		
		return names;
	}
}