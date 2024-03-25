class Player {
    private Coordinate pos = new Coordinate (0, 0);
    private PlayerStatus status = PlayerStatus.ALIVE;
    private int arrows = 5;
    public Coordinate getPos() {
        return pos;
    }
    public void setPos(Coordinate pos) {
        this.pos = pos;
    }
    public PlayerStatus getStatus () {
        return status;
    }
    public void setStatus (PlayerStatus status) {
        if (this.status == PlayerStatus.ALIVE) {
            this.status = status;
        }
    }
    public int getArrows() {
        return arrows;
    }
    public void shootArrow() {
        if (arrows >= 0) {
            arrows--;
        }
    }
}