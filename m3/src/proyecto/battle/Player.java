package proyecto.battle;

public class Player {
    String name;
    float points, won, lost;

    public Player(String name, int points, int win, int lost) {
        this.name = name;
        this.points = points;
        this.won = win;
        this.lost = lost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public float getWon() {
        return won;
    }

    public void setWon(int won) {
        this.won = won;
    }

    public float getLost() {
        return lost;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }
}
