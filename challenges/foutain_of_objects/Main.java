package foutain_of_objects;

import java.util.*;

public class Main {
	static Scanner myScanner = new Scanner(System.in);
	static Game game;
	
	public static void main (String[] args) {
		mainMenu();
	}
	
	static void mainMenu() {
		System.out.println("1) Start a new game.");
		System.out.println("2) Show rules & info.");
		System.out.println("3) Quit the game.");
		if (game != null && game.getPlayer().getStatus() == PlayerStatus.ALIVE) {
			System.out.println("4) Continue the game you were playing.");
		}
		
		do {
			String input = myScanner.nextLine();
			if (defaultFunction(input)) {
				defaultFunctionExecute(input);
				return;
			}
			
			switch(input) {
				case "1":
					newGame();
					return;
				case "2":
					showInfo();
					return;
				case "3":
					System.out.println("You have quit the game.");
					return;
				case "4":
					if (game != null) {
						winStatus();
						return;
					}
					break;
			}
			System.out.println("This is not a valid command, please try again.");
		} while (true);
	}
	
	static void newGame () {
		int fieldSize;
		
		do {
			System.out.println();
			System.out.println("How big do you want the field to be?");
			System.out.println("1) 4x4");
			System.out.println("2) 6x6");
			System.out.println("3) 8x8");
			
			String input = myScanner.nextLine();
			
			if (defaultFunction(input)) {
				defaultFunctionExecute(input);
				return;
			}
			
			fieldSize = switch(input) {
				case "1", "4x4" -> 4;
				case "2", "6x6" -> 6;
				case "3", "8x8" -> 8;
				default 		-> 0;
			};
			
			if (fieldSize != 0) break;
		} while (true);
		
		game = new Game(fieldSize);
		System.out.println("You created a new game with a field size of " + fieldSize + "x" + fieldSize + ".");
		
		winStatus();
	}
	
	static boolean defaultFunction (String input) {
		return switch (input.toLowerCase()) {
			case "quit", "menu", "help" -> true;
			default -> false;
		};
	}
	
	static void defaultFunctionExecute (String input) {
		switch (input.toLowerCase()) {
			case "quit":
				System.out.println("You have quit the game.");
				System.exit(0);
				break;
			case "menu":
				mainMenu();
				break;
			case "help":
				showInfo();
				break;
			default:
		}
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
	
	static void winStatus() {
		boolean playerAlive = game.getPlayer().getStatus() == PlayerStatus.ALIVE ? true : false;
		boolean playerEntrance = game.getRoomType(game.getPlayer().getPos()) == RoomType.ENTRANCE ? true : false;
		
		if (playerAlive && game.checkFountain() && playerEntrance) {
			System.out.println("You have won");
		}else if (!playerAlive) {
			System.out.println("You lost, becasue you have died.");
		} else {
			playerTurn();
		}
	}
	
	static void playerTurn() {
		showPlayerStatus();
		playerChoice();
		winStatus();
	}
	
	static void playerChoice() {
		Player player = game.getPlayer();
		do {
			System.out.print("What do you want to do? ");
			String input = myScanner.nextLine().toLowerCase();
			if (defaultFunction(input)) {
				defaultFunctionExecute(input);
				return;
			}
			
			if (input.equals("enable")) {
				if (game.enableFountain()) {
					break;
				} else {
					System.out.println("There is nothing to enable.");
				}
			}
			if (input.equals("disable")) {
				if (game.disableFountain()) {
					break;
				} else {
					System.out.println("There is nothing to disable.");
				}
			}
			
			Coordinate newCoordinate = switch(input) {
				case "move north" -> player.getPos().plus(0, 1);
				case "move east" -> player.getPos().plus(1, 0);
				case "move south" -> player.getPos().plus(0, -1);
				case "move west" -> player.getPos().plus (-1, 0);
				default -> null;
			};
			
			if (newCoordinate != null && game.coordinatesContains(newCoordinate)) {
				player.setPos(newCoordinate);
				break;
			}
			System.out.println("\"" + input + "\" is not a valid command, please try again.");
		} while (true);
	}
	
	static void showPlayerStatus() {
		spacer();
		System.out.println("You are in the room at (Row = " + game.getPlayer().getPos().x() + ", Column = " + game.getPlayer().getPos().y() + ").");
		
		switch (game.getRoomType(game.getPlayer().getPos())) {
			case RoomType.ENTRANCE:
				System.out.println("You see light coming from the cavern entrance.");
				break;
			case RoomType.FOUNTAIN:
				if (game.checkFountain()) System.out.println("You hear the rushing waters from the Fountain of Objects.");
				else System.out.println("You hear water dripping in this room. The Fountain of Objects is here!");
				break;
		}
	}
	
	static void spacer() {
		System.out.println("------------------------------------------------------------------------");
	}
	
	static void printColor(String color, String text) {
		
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

enum FountainStatus {
	ENABLED,
	DISABLED
}

class Game {
	private HashMap<Coordinate, Room> coordinates = new HashMap<>();
	private Player player;
	private FountainStatus fountainStatus;
	
	public Game (int mapSize) {
		fountainStatus = FountainStatus.DISABLED;
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
	
	public boolean coordinatesContains (Coordinate pos) {
		return coordinates.containsKey(pos);
	}
	
	public boolean checkFountain () {
		return fountainStatus == FountainStatus.ENABLED;
	}
	
	public boolean enableFountain () {
		if (coordinates.get(player.getPos()).getRoomType() == RoomType.FOUNTAIN) {
			fountainStatus = FountainStatus.ENABLED;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean disableFountain() {
		if (coordinates.get(player.getPos()).getRoomType() == RoomType.FOUNTAIN) {
			fountainStatus = FountainStatus.DISABLED;
			return true;
		} else {
			return false;
		}
	}
}

record Coordinate(int x, int y) {
	//make delta ints
	public Coordinate plus (int deltaX, int deltaY) {
		deltaX += x;
		deltaY += y;
		return new Coordinate(deltaX, deltaY);
	}
}

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