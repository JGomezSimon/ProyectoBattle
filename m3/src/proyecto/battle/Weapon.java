package proyecto.battle;

public class Weapon {
    String url;
    int speed, strength;

    public Weapon(String url, int speed, int strength) {
        this.speed = speed;
        this.strength = strength;
    }

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
