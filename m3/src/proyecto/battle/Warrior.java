package proyecto.battle;

public class Warrior {
    String name, url;
    Weapon weapon;
    int life, strength, defense, agility, speed, id;

    public Warrior(String nom, String url, int life, int strength, int defense, int agility, int speed, int id) {
        this.name = nom;
        this.url = url;
        this.life = life;
        this.strength = strength;
        this.defense = defense;
        this.agility = agility;
        this.speed = speed;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int getLife() {
        return life;
    }

    public int getStrength() {
        return strength;
    }

    public int getDefense() {
        return defense;
    }

    public int getAgility() {
        return agility;
    }

    public int getSpeed() {
        return speed;
    }

    public void setLife(int life) {
        this.life = life;
    }

}
