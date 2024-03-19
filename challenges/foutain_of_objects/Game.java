package foutain_of_objects;

import foutain_of_objects.*;
import java.util.*;

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
}