public class Weapon {
    String url, name;
    int speed, strength, points, weId;

    public Weapon(int strength, int speed, String url, String name, int points) {
        this.speed = speed;
        this.strength = strength;
        this.url = url;
        this.name = name;
        this.points = points;
        this.weId = weId;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public int getStrength() {
        return strength;
    }

    public String getUrl() {
        return url;
    }

    public int getWeId() { return weId;
    }

    public void setWeId(int weId) { this.weId = weId;
    }
}
