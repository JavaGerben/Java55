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
		
		boolean validMenuChoise = false;
		do {
			String input = myScanner.nextLine();
			switch(input) { //textInput("menu")
				case "1":
					newGame();
					validMenuChoise = true;
					break;
				case "2":
					showInfo();
					validMenuChoise = true;
					break;
				case "3":
					System.out.println("You have quit the game.");
					validMenuChoise = true;
					break;
				case "4":
					if (game != null) {
						playerTurn();
						validMenuChoise = true;
					} else {
						validMenuChoise = false;
						System.out.println("This is not a valid choice, please enter a valid choice.");
					}
					break;
				default:
					if (!defaultFunctionExecuted(input)) {
						System.out.println("This is not a valid choice, please enter a valid choice.");
						validMenuChoise = false;
					} else {
						validMenuChoise = true;
					}
					break;
			}
		} while (!validMenuChoise);
	}
	
	static void newGame () {
		int fieldSize = 0;
		boolean validMenuChoise = true;
		
		do {
			System.out.println();
			System.out.println("How big do you want the field to be?");
			System.out.println("1) 4x4");
			System.out.println("2) 6x6");
			System.out.println("3) 8x8");
			
			String input = myScanner.nextLine();
			
			switch(input) {
				case "1":
					fieldSize = 4;
					validMenuChoise = true;
					break;
				case "2":
					fieldSize = 6;
					validMenuChoise = true;
					break;
				case "3":
					fieldSize = 8;
					validMenuChoise = true;
					break;
				default:
					if (!defaultFunctionExecuted(input)) {
						System.out.println("This is not a valid choice, please enter a valid choice.");
						validMenuChoise = false;
					} else {
						validMenuChoise = true;
					}
					break;
			};
		} while (!validMenuChoise);
		game = new Game(fieldSize);
		System.out.println("You created a new game with a field size of " + fieldSize + "x" + fieldSize + ".");
		
		playerTurn();
	}
	
	static boolean defaultFunctionExecuted (String input) {
		switch (input.toLowerCase()) {
			case "quit":
				System.out.println("You have quit the game.");
				break;
			case "menu":
				mainMenu();
				break;
			case "help":
				showInfo();
				break;
			default:
				return false;
		}
		return true;
	}
	
	static void showInfo () {
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
		
		mainMenu();
	}
	
	static void playerTurn() {
		Player player = game.getPlayer();
		System.out.println();
		System.out.println("You are in the room at (Row = " + player.getPos().x() + ", Column = " + player.getPos().y() + ").");
		
		RoomType roomType = game.getRoomType(player.getPos());
		switch (roomType) {
			case RoomType.ENTRANCE:
				System.out.println("You see light coming from the cavern entrance.");
				break;
			case RoomType.FOUNTAIN:
				break;
		}
		
		System.out.print("What do you want to do? ");
		boolean validMenuChoise = false;
		do {
			String input = myScanner.nextLine().toLowerCase();
			switch(input) {
				case "move north":
					validMenuChoise = true;
					//check if move in that derection is possible
					player.setPos(player.getPos().x(), player.getPos().y()+1)
					break;
				case "move east":
					//check if move in that derection is possible
					player.setPos(player.getPos().x()+1, player.getPos().y())
					validMenuChoise = true;
					break;
				case "move south":
					//check if move in that derection is possible
					player.setPos(player.getPos().x(), player.getPos().y()-1)
					validMenuChoise = true;
					break;
				case "move west":
					//check if move in that derection is possible
					player.setPos(player.getPos().x()-1, player.getPos().y())
					validMenuChoise = true;
					break;
				default:
					if (!defaultFunctionExecuted(input)) {
						System.out.println("This is not a valid choice, please enter a valid choice.");
						validMenuChoise = false;
					} else {
						validMenuChoise = true;
					}
					break;
			}
		} while (!validMenuChoise);
		
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
	
	public RoomType getRoomType(Coordinate coordinate) {
		Room room = coordinates.get(coordinate);
		return room.getRoomType();
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

