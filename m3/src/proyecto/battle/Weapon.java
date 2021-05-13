package proyecto.battle;

public class Weapon {
    String url, name;
    int speed, strength;

    public Weapon(int strength, int speed, String url, String name) {
        this.speed = speed;
        this.strength = strength;
        this.url = url;
        this.name = name;
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
