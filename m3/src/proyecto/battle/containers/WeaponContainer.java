package proyecto.battle.containers;

import proyecto.battle.Weapon;

import java.util.ArrayList;

public class WeaponContainer {

    public static ArrayList<Weapon> weaponArrayList = new ArrayList<>();

    public ArrayList<Weapon> getWeaponArrayList() {
        return weaponArrayList;
    }

    public void setWeaponArrayList(ArrayList<Weapon> weaponArrayList) {
        WeaponContainer.weaponArrayList = weaponArrayList;
    }
}
