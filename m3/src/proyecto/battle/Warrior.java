package proyecto.battle;

public class Warrior {
    String nom, url;
    int id, life, strength, defense, agility, speed;
    int race_id;

    public Warrior(String nom, String url, int id, int race_id, int life, int strength, int defense, int agility, int speed) {
        this.nom = nom;
        this.url = url;
        this.id = id;
        this.race_id = race_id;
        this.life = life;
        this.strength = strength;
        this.defense = defense;
        this.agility = agility;
        this.speed = speed;
    }

    public String getNom() { return nom; }

    public void setNom(String nom) { this.nom = nom; }

    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getRace_id() { return race_id; }

    public void setRace_id(int race_id) { this.race_id = race_id; }

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