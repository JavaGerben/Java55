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
        if (this.roomType == RoomType.EMPTY || this.roomType == RoomType.MAELSTROM) {
            this.roomType = roomType;
        }
    }
}