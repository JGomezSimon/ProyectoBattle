package proyecto.battle;

public class Weapon {
    public Weapon(Warrior warrior, int speed, int strength){
        warrior.setSpeed(warrior.strength + strength);
        warrior.setStrength(warrior.speed + speed);
    }
}
