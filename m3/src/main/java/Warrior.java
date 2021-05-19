public class Warrior {
    String name, url;
    Weapon weapon;
    int life, strength, defense, agility, speed, race_id, points, waId;

    public Warrior(String name, String url, int life, int strength, int defense, int agility, int speed, int race_id, int points) {
        this.name = name;
        this.url = url;
        this.life = life;
        this.strength = strength;
        this.defense = defense;
        this.agility = agility;
        this.speed = speed;
        this.race_id = race_id;
        this.points = points;
    }


    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getPoints() {
        return points;
    }

    public int getRace_id() {
        return race_id;
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

    public int getWaId() {
        return waId;
    }

    public void setWaId(int waId) {
        this.waId = waId;
    }
}
