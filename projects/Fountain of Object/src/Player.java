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