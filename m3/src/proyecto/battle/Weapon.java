package proyecto.battle;

public class Weapon {
    String url;
    int speed, strength;

    public Weapon(int speed, int strength, String url) {
        this.speed = speed;
        this.strength = strength;
        this.url = url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

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

    public String getUrl() {
        return url;
    }
}
