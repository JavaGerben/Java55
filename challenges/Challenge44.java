import java.util.*;

public class Challenge44 {
	static Scanner myScanner = new Scanner(System.in);
	static Game game;
	
	public static void main (String[] args) {
		mainMenu();
	}
	
	static void mainMenu() {
		System.out.println("1) Start a new game.");
		System.out.println("2) Show rules & info.");
		System.out.println("3) Quit the game.");
		if (game != null) {
			System.out.println("4) Continue the game you were playing.");
		}
		
		boolean validMenuChoise = true;
		do {
			switch(stringToInt(textInput("menu"))) {
				case 1:
					newGame();
					validMenuChoise = true;
					break;
				case 2:
					showInfo("menu");
					validMenuChoise = true;
					break;
				case 3:
					System.out.println("You have quit the game.");
					validMenuChoise = true;
					break;
				case 4:
					if (game != null) {
						//player turn
						validMenuChoise = true;
						System.out.println("This is not a valid choice, please enter a valid choice.");
					} else {
						validMenuChoise = false;
						System.out.println("This is not a valid choice, please enter a valid choice.");
					}
					break;
				default:
					validMenuChoise = false;
					break;
			}
		} while (validMenuChoise == false);
	}
	
	static void newGame() {
		int fieldSize = 0;
		do {
			System.out.println();
			System.out.println("How big do you want the field to be?");
			System.out.println("1) 4x4");
			System.out.println("2) 6x6");
			System.out.println("3) 8x8");
			
			switch(stringToInt(textInput("newGame"))) {
				case 1:
					fieldSize = 4;
					break;
				case 2:
					fieldSize = 6;
					break;
				case 3:
					fieldSize = 8;
				default:
					System.out.println("This is not a valid choice, please enter a valid choice.");
			};
		} while (fieldSize == 0);
		System.out.println();
		
		game = new Game(fieldSize);
		
	}
	
	static String textInput(String previousAction) {
		String input = myScanner.nextLine();
		switch (input.toLowerCase()) {
			case "quit":
				System.out.println("You have quit the game.");
				break;
			case "menu":
				mainMenu();
				break;
			case "help":
				showInfo(previousAction);
				break;
			default:
				return input;
		}
		return null;
	}
	
	static int stringToInt(String input) {
		int number;
		try {
			number = Integer.parseInt(input);
		} catch (NumberFormatException ex) {
			System.out.println("Please enter a valid input.");
			number = stringToInt(myScanner.nextLine());
		}
		return number;
	}
	
	static void showInfo (String action) {
		System.out.println();
		System.out.println("You will start at the entrance and you can move between other rooms by typing commands like the following:\n" +
						   "\"move north\", \"move south\", \"move east\", and \"move west\". You are not be able to move past the end of the map.\n" +
						   "The map size is determined when creating a new game. \n" +
						   "\n" +
						   "Your goal is to find the fountain, enable it and than go back to the entrance.\n" +
						   "But there will be some traps along the way, they can kill you, look out for those.\n" +
						   "\n" +
						   "during playing you can always type in the following commands:\n" +
						   "\"menu\" to show the main menu again.\n" +
						   "\"help\" to show this info again.\n" +
						   "\"quit\" to quit the game.");
		System.out.println();
		System.out.println("Now returning to the previous action.");
		
		// switch (action) {
			// case "menu":
				// mainMenu();
				// break;
			// case "newGame":
				// newGame();
				// break;
			// case "playerTurn":
				// playerTurn();
				// break;
		// }
	}
}

enum RoomType {
	ENTRANCE,
	FOUNTAIN,
	EMPTY
}

enum PlayerStatus {
	ALIVE,
	DEAD
}

class Game {
	HashMap<Coordinate, Room> coordinates = new HashMap<>();
	Player player;
	
	public Game (int mapSize) {
		for (int row = 0; row < mapSize; row++) {
			for (int collumn = 0; collumn < mapSize; collumn++) {
				Coordinate pos = new Coordinate(row, collumn);
				coordinates.put(pos, new Room());
			}
		}
		Room room = coordinates.get(new Coordinate(0, 0));
		room.setRoomType(RoomType.ENTRANCE);
		
		//for now static position of fountain
		room = coordinates.get(new Coordinate(2, 1));
		room.setRoomType(RoomType.FOUNTAIN);
		
		player = new Player();
	}
	
	public Player getPlayer() {
		return player;
	}
}

record Coordinate(int x, int y) { }

class Room {
	private RoomType roomType;
	private boolean active;
	
	public Room(){
		roomType = RoomType.EMPTY;
		active = false;
	}
	
	public RoomType getRoomType () {
		return roomType;
	}
	
	public void setRoomType (RoomType roomType) {
		if (this.roomType == RoomType.EMPTY) {
			this.roomType = roomType;
		}
	}
}

class Player {
	private Coordinate pos;
	private PlayerStatus status;
	
	public Player() {
		pos = new Coordinate (0, 0);
		status = PlayerStatus.ALIVE;
	}
	
	public Coordinate getPos() {
		return pos;
	}
	
	public void setPos(Coordinate pos) {
		this.pos = pos;
	}
	
	public PlayerStatus getStatus() {
		return status;
	}
	
	public void setStatus (PlayerStatus status) {
		if (status == PlayerStatus.ALIVE) {
			this.status = status;
		}
	}
}

