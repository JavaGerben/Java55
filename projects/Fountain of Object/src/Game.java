import java.util.HashMap;

class Game {
    private final HashMap<Coordinate, Room> coordinates = new HashMap<>();
    private final Player player;
    private FountainStatus fountainStatus;

    public Game (int mapSize) {
        fountainStatus = FountainStatus.DISABLED;
        for (int row = 0; row < mapSize; row++) {
            for (int collumn = 0; collumn < mapSize; collumn++) {
                Coordinate pos = new Coordinate(row, collumn);
                coordinates.put(pos, new Room());
            }
        }

        player = new Player();

        randomRoomPlacement(RoomType.ENTRANCE, mapSize, player);
        randomRoomPlacement(RoomType.FOUNTAIN, mapSize, player);
    }

    private void randomRoomPlacement(RoomType roomType, int fieldSize, Player player) {
        Room room;
        int randX;
        int randY;
        do {
            randX = (int) (Math.random() * fieldSize);
            randY = (int) (Math.random() * fieldSize);
            room = coordinates.get(new Coordinate(randX, randY));
        } while (room.getRoomType() != RoomType.EMPTY);

        if (roomType == RoomType.ENTRANCE) {
            player.setPos(new Coordinate(randX, randY));
        }
        room.setRoomType(roomType);
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