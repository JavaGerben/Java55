import java.util.Scanner;
import java.lang.Math;

public class AlphabetAnimalGame {
	public static void main (String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("This is the animal game.\n");
		System.out.println("If it's one's turn, one types in an animal which will start");
		System.out.println("with the same letter as the last letter of the previous animal.\n");
		
		String[] knownAnimals = {"Ant", "Bear", "Bee", "Bird", "Butterfly", "Camel", "Cat", "Caterpillar", "Chicken", "Cow", "Crab", "Crocodile",
		"Deer", "Dog", "Dolphin", "Donkey", "Duck", "Elephant", "Fish", "Giraffe", "Goat", "Hamster", "Hedgehog", "Horse", "Jellyfish", "Ladybird",
		"Sheep", "Lion", "Mole", "Monkey", "Octopus", "Mouse", "Owl", "Panda", "Penguin", "Pig", "Pony", "Rabbit", "Seahorse", "Snake", "Spider",
		"Starfish", "Stingray", "Tiger", "Turkey", "Turtle", "Unicorn", "Whale", "Worm", "Zebra", "Pigeon", "Dinosaur", "Dragon", "Kangaroo", "Clownfish",
		"Rhinoceros", "Toad", "Puppy", "Hippo", "Rat", "Ostrich", "Peacock"};
		
		int randomNumber = (int)(Math.random() * knownAnimals.length);
		String animalBase = knownAnimals[randomNumber];
		System.out.println("I'll start. With... " + knownAnimals[randomNumber]);
		knownAnimals[randomNumber] = " ";
		System.out.print("What will you choose? ");
		String animalAnswer = myScanner.nextLine();
		animalCompareLetters(animalBase, animalAnswer, knownAnimals);
	}
	
	static void animalCompareLetters(String lastLetterAnimal, String firstLetterAnimal, String[] knownAnimals) {
		firstLetterAnimal = firstLetterAnimal.toLowerCase();
		if (lastLetterAnimal.charAt(lastLetterAnimal.length() - 1) == firstLetterAnimal.charAt(0)) {
			System.out.println("Well done.\n");
			computerAnimal(firstLetterAnimal, knownAnimals);
		}
		else {
			System.out.println("To bad that is not correct.");
			endGame(false);
		}
	}
	
	static void computerAnimal(String lastLetterAnimal, String[] knownAnimals) {
		Scanner myScanner = new Scanner(System.in);
		boolean animalFound = false;
		String animalAnswer;
		
		for (int i = 0; i < knownAnimals.length; i++) {
			String lowerCaseAnimal = knownAnimals[i].toLowerCase();
			if (lastLetterAnimal.charAt(lastLetterAnimal.length() - 1) == lowerCaseAnimal.charAt(0)) {
				System.out.println("I will go with... " + knownAnimals[i]);
				knownAnimals[i] = " ";
				animalFound = true;
				System.out.print("What will you choose? ");
				animalAnswer = myScanner.nextLine();
				animalCompareLetters(lowerCaseAnimal, animalAnswer, knownAnimals);
				break;
			}
		}
		if (!animalFound) {
			endGame(true);
		}
	}
	
	static void endGame(boolean playerWin) {
		if(playerWin) {
			System.out.println("Congratulations you won, I couldn't find an animal that fit the bill.");
		} else {
			System.out.println("To bad, that answer is wrong, it seems i won.");
		}
	}
}