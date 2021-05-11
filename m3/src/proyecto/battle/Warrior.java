package proyecto.battle;

public class Warrior {
    String nom, url;
    Weapon weapon;
    int life, strength, defense, agility, speed, id;

    public Warrior(String nom, String url, int life, int strength, int defense, int agility, int speed, int id) {
        this.nom = nom;
        this.url = url;
        this.life = life;
        this.strength = strength;
        this.defense = defense;
        this.agility = agility;
        this.speed = speed;
    }

    public int getId() {
        return id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
