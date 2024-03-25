import java.util.HashMap;

class Game {
    private final HashMap<Coordinate, Room> coordinates = new HashMap<>();
    private final Player player;
    private FountainStatus fountainStatus;
    int mapSize;
    public Game (int mapSize) {
        this.mapSize = mapSize;
        fountainStatus = FountainStatus.DISABLED;
        for (int row = 0; row < mapSize; row++) {
            for (int collumn = 0; collumn < mapSize; collumn++) {
                Coordinate pos = new Coordinate(row, collumn);
                coordinates.put(pos, new Room());
            }
        }

        int multipleRoomsCount = switch(mapSize) {
            case 4 -> 1;
            case 6 -> 2;
            case 8 -> 4;
            default -> throw new IllegalStateException("Unexpected value: " + mapSize);
        };

        player = new Player();
        randomRoomPlacement(RoomType.ENTRANCE, 1);
        randomRoomPlacement(RoomType.FOUNTAIN, 1);
        randomRoomPlacement(RoomType.MAELSTROM, multipleRoomsCount);
        randomRoomPlacement(RoomType.PIT, multipleRoomsCount);
    }
    private void randomRoomPlacement(RoomType roomType, int times) {
        for (int i = 0; i < times; i++) {
            Room room;
            Coordinate pos;
            int randX;
            int randY;
            do {
                randX = (int) (Math.random() * mapSize);
                randY = (int) (Math.random() * mapSize);
                pos = new Coordinate(randX, randY);
                room = coordinates.get(pos);
            } while (room.getRoomType() != RoomType.EMPTY && pos != player.getPos());

            if (roomType == RoomType.ENTRANCE) {
                player.setPos(new Coordinate(randX, randY));
            }
            room.setRoomType(roomType);
        }
    }
    public Player getPlayer() {
        return player;
    }
    public RoomType getRoomType (Coordinate coordinate) {
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
    public boolean disableFountain () {
        if (coordinates.get(player.getPos()).getRoomType() == RoomType.FOUNTAIN) {
            fountainStatus = FountainStatus.DISABLED;
            return true;
        } else {
            return false;
        }
    }
    public void playerInMaelstromRoom (Coordinate roomPos) {
        Room maelstromRoom = coordinates.get(roomPos);
        maelstromRoom.setRoomType(RoomType.EMPTY);

        moveMaelstrom(roomPos);
        movePlayer(roomPos);
    }
    private void moveMaelstrom (Coordinate roomPos) {
        int maelstromX = roomPos.x()-2;
        int maelstromY = roomPos.y()-1;

        for (int row = maelstromX; row < mapSize; row++) {
            for (int collumn = maelstromY; collumn < mapSize; collumn++) {
                Coordinate pos = new Coordinate(row, collumn);
                if (coordinates.containsKey(pos)) {
                    Room room = coordinates.get(pos);
                    room.setRoomType(RoomType.MAELSTROM);
                    return;
                }
            }
        }
    }
    private void movePlayer (Coordinate roomPos) {
        int playerX = roomPos.x()+2;
        int playerY = roomPos.y()+1;

        for (int row = playerX; row >= 0; row--) {
            for (int collumn = playerY; collumn >= 0; collumn--) {
                Coordinate pos = new Coordinate(row, collumn);
                if (coordinates.containsKey(pos)) {
                    player.setPos(pos);
                    return;
                }
            }
        }
    }
    public void cheat () {
        coordinates.forEach((key, value) -> System.out.println(key.x() + ", " + key.y() + " - " + value.getRoomType()));
    }
}