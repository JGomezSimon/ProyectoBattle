package proyecto.battle;

public class Weapon {
    String name,url;
    int speed, strength, weapon_points;

    public Weapon(String name, String url, int speed, int strength, int weapon_points) {
        this.name = name;
        this.url = url;
        this.speed = speed;
        this.strength = strength;
        this.weapon_points = weapon_points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) { this.speed = speed; }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) { this.strength = strength; }

    public int getWeapon_points() { return weapon_points; }

    public void setWeapon_points(int weapon_points) { this.weapon_points = weapon_points; }
}
