package proyecto.battle;

public class Weapon {
    String url;
    public Weapon(Warrior warrior, int speed, int strength, String url){
        warrior.setSpeed(warrior.strength + strength);
        warrior.setStrength(warrior.speed + speed);
    }

    public String getUrl() {
        return url;
    }
}
