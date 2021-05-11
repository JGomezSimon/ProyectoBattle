package proyecto.battle;

public class Weapon {
    int speed, strength;

    public Weapon(int speed, int strength) {
        this.speed = speed;
        this.strength = strength;
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
}
