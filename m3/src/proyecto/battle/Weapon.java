package proyecto.battle;

public class Weapon {
    String name,url;
    int speed, strength;

    public Weapon(String name, String url, int speed, int strength) {
        this.name = name;
        this.url = url;
        this.speed = speed;
        this.strength = strength;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getUrl() { return url;}

    public void setUrl(String url) { this.url = url; }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
