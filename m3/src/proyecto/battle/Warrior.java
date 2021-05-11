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
    public void Weapon(Warrior warrior, int speed, int strength){
        warrior.setSpeed(warrior.strength + strength);
        warrior.setStrength(warrior.speed + speed);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}