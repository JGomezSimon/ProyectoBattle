package proyecto.battle;

import proyecto.battle.containers.WarriorContainer;
import proyecto.battle.containers.WeaponContainer;

public class Battle {
    public void init(){
        Warrior warrior1 = new Warrior("Lintia", "assets/guerreros/lintia.png", 50, 5, 6, 4, 3);
        Warrior warrior2 = new Warrior("Renil", "assets/guerreros/renil.png", 60, 3, 10, 3, 3);
        WarriorContainer.warriorArrayList.add(warrior1);
        WarriorContainer.warriorArrayList.add(warrior2);
        WeaponContainer.weaponArrayList.add(new Weapon(warrior1, 2,2));
        WeaponContainer.weaponArrayList.add(new Weapon(warrior2, 1,3));
    }
}
