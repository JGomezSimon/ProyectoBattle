package proyecto.battle;

public class Warrior {
    String nom, url;
    Weapon weapon;
    Race race;

    public Warrior(String nom, String url, Weapon weapon, Race race) {
        this.nom = nom;
        this.url = url;
        this.weapon = weapon;
        this.race = race;
    }

    public String getNom() { return nom; }

    public void setNom(String nom) { this.nom = nom; }

    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }

    public Weapon getWeapon() { return weapon; }

    public void setWeapon(Weapon weapon) { this.weapon = weapon; }

    public Race getRace() { return race; }

    public void setRace(Race race) { this.race = race; }
}