package proyecto.battle;

public class Race {
    String name, url;
    int life, strength, defense, agility, speed;

    public Race(String name, String url, int life, int strength, int defense, int agility, int speed) {
        this.name = name;
        this.url = url;
        this.life = life;
        this.strength = strength;
        this.defense = defense;
        this.agility = agility;
        this.speed = speed;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }

    public int getLife() { return life; }

    public void setLife(int life) { this.life = life; }

    public int getStrength() { return strength; }

    public void setStrength(int strength) { this.strength = strength; }

    public int getDefense() { return defense; }

    public void setDefense(int defense) { this.defense = defense; }

    public int getAgility() { return agility; }

    public void setAgility(int agility) { this.agility = agility; }

    public int getSpeed() { return speed; }

    public void setSpeed(int speed) { this.speed = speed; }
}
