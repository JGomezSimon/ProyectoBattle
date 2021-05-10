package proyecto.battle;

public class Warrior {
    String nom, url;
    Weapon weapon;
    int life, strength, defense, agility, speed;

    public Warrior(String nom, String url, Weapon weapon, int life, int strength, int defense, int agility, int speed) {
        this.nom = nom;
        this.url = url;
        this.weapon = weapon;
        this.life = life;
        this.strength = strength + weapon.strength;
        this.defense = defense;
        this.agility = agility;
        this.speed = speed + weapon.speed;
    }
}
