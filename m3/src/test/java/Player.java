import java.sql.SQLException;

public class Player {
    String name, password;
    float points, won, lost;
    Warrior warrior;

    public Player(String name, String password, float points, float win, float lost) {
        this.name = name;
        this.points = points;
        this.won = win;
        this.lost = lost;
        this.password = password;
    }

    public Warrior getWarrior() {
        return warrior;
    }

    public void setWarrior(Warrior warrior) {
        this.warrior = warrior;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void setPoints(int points) throws SQLException {
        this.points = points;
        Events.setPointsDB(points);
    }

    public float getWon() {
        return won;
    }

    public void setWon(int won) throws SQLException, ClassNotFoundException {
        this.won = won;
        Events.setWonDB(won);
    }

    public float getLost() {
        return lost;
    }

    public void setLost(int lost) throws SQLException {
        this.lost = lost;
        Events.setLostDB(lost);
    }
}
