class Room {
    private RoomType roomType;

    public Room(){
        roomType = RoomType.EMPTY;
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