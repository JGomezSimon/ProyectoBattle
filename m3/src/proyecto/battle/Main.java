package proyecto.battle;

import proyecto.battle.containers.WarriorContainer;
import proyecto.battle.containers.WeaponContainer;
import proyecto.battle.gui.MainPanel;
import proyecto.battle.gui.WarriorPanel;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static JFrame frame;
    public static JFrame weaponPanel;
    public static JFrame warriorPanel;
    public static JFrame battlePanel;
    public static void main(String[] args) throws IOException {
        // Testing // ADD to container all warriors
        WarriorContainer.warriorArrayList = new ArrayList<>();
        WarriorContainer.warriorArrayList.add(new Warrior("Nedraec Forgeshaper", "assets/warriors/nedraec.jpeg", 60, 6, 4, 5, 3, 1));
        WarriorContainer.warriorArrayList.add(new Warrior("Safomli Platebreaker", "assets/warriors/samfoli.jpg", 60, 6, 4, 5, 3, 1));
        WarriorContainer.warriorArrayList.add(new Warrior("Khekroc Heavyshoulder", "assets/warriors/khekroc.png", 60, 6, 4, 5, 3, 1));
        WarriorContainer.warriorArrayList.add(new Warrior("Edwaradrin Ohmswis", "assets/warriors/edwaradrin.jpg", 50, 5, 3, 6, 5, 3));
        WarriorContainer.warriorArrayList.add(new Warrior("Legomoreno", "assets/warriors/legomoreno.jpg", 50, 5, 3, 6, 5, 3));
        WarriorContainer.warriorArrayList.add(new Warrior("Roferolas Elfbrooks", "assets/warriors/roferolas.jpg", 50, 5, 3, 6, 5, 3));
        WarriorContainer.warriorArrayList.add(new Warrior("Maol-Chaluim Maoileanach", "assets/warriors/maol-chaluim.jpg", 40, 4, 2, 7, 7, 2));
        WarriorContainer.warriorArrayList.add(new Warrior("Gillìosa Fòlais", "assets/warriors/gilliosa.jpg", 40, 4, 2, 7, 7, 2));
        WarriorContainer.warriorArrayList.add(new Warrior("Seumas Forsàidh", "assets/warriors/seumas.jpg", 40, 4, 2, 7, 7, 2));
        // Testing // ADD to container all weapons
        WeaponContainer.weaponArrayList = new ArrayList<>();
        WeaponContainer.weaponArrayList.add(new Weapon(3, 0, "assets/weapons/dagger.jpg", "Dagger")); // Dagger
        WeaponContainer.weaponArrayList.add(new Weapon(1, 1, "assets/weapons/sword.jpg", "Sword")); // Sword
        WeaponContainer.weaponArrayList.add(new Weapon(3, 0, "assets/weapons/axe.png", "Axe")); // Axe
        WeaponContainer.weaponArrayList.add(new Weapon(2, 2, "assets/weapons/twinSwords.jpg", "TwinSwords")); // TwinSwords
        WeaponContainer.weaponArrayList.add(new Weapon(1, 2, "assets/weapons/scimitar.jpg", "Scimitar")); // Scimitar
        WeaponContainer.weaponArrayList.add(new Weapon(1, 5, "assets/weapons/bow.jpg", "Bow")); // Bow
        WeaponContainer.weaponArrayList.add(new Weapon(2, 3, "assets/weapons/katana.jpg", "Katana")); // Katana
        WeaponContainer.weaponArrayList.add(new Weapon(0, 4, "assets/weapons/knife.jpg", "Knife")); // Knife
        WeaponContainer.weaponArrayList.add(new Weapon(5, 0, "assets/weapons/twoHandedAxe.jpg", "TwoHandedAxe")); // TwoHandedAxe
        // Initialize All Panels
        frame = new MainPanel();
        frame.setVisible(true);
        warriorPanel = new WarriorPanel();

    }
}