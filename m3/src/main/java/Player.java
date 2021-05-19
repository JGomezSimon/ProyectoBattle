import java.sql.SQLException;

public class Player {
    String name, password;
    float points, won, lost;
    int hp, pId, wepId, opoId;
    Warrior warrior;

    public Player(String name, String password, float points, float win, float lost) {
        this.name = name;
        this.points = points;
        this.won = win;
        this.lost = lost;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", points=" + points +
                ", won=" + won +
                ", lost=" + lost +
                ", warrior=" + warrior +
                '}';
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

    public void setPoints(int points) {
        this.points = points;
        try {
            Events.setPointsDB(points);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public float getWon() {
        return won;
    }

    public void setWon(int won) {
        this.won = won;
        try {
            Events.setWonDB(won);
        } catch (SQLException | ClassNotFoundException ignored) {
        }
    }

    public float getLost() {
        return lost;
    }

    public void setLost(int lost) {
        this.lost = lost;
        try {
            Events.setLostDB(lost);
        } catch (SQLException ignored) {
        }
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }
    //Getters and Setters for opopnent stats

    // Oponent Weapon

    public int getOpoId() {
        return opoId;
    }

    public void setOpoId(int opoId) {
        this.opoId = opoId;
    }


    // Oponent Warrior


    public int getWepId() {
        return wepId;
    }

    public void setWepId(int wepId) {
        this.wepId = wepId;
    }

    // Oponent Health left
    public int getHp() { return hp; }

    public void setHp(int hp) { this.hp = hp; }

}
