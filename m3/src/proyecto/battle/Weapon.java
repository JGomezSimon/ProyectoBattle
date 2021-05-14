package proyecto.battle;

public class Weapon {
    String url, name;
    int speed, strength, points;

    public Weapon(int strength, int speed, String url, String name, int points) {
        this.speed = speed;
        this.strength = strength;
        this.url = url;
        this.name = name;
        this.points = points;
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

}
