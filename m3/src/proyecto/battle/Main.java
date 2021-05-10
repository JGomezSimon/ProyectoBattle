package proyecto.battle;

import proyecto.battle.containers.WarriorContainer;
import proyecto.battle.containers.WeaponContainer;
import proyecto.battle.gui.MainPanel;

import javax.swing.*;

public class Main extends JFrame {
    public static JTabbedPane tabbedPane = new JTabbedPane();

    public Main() {
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        add(tabbedPane);
    }

    public static void main(String[] args) {
        new Main();
        new MainPanel();
        WarriorContainer warriorContainer = new WarriorContainer();
        WeaponContainer weaponContainer = new WeaponContainer();
        Warrior warrior1 = new Warrior("Lintia", "assets/guerreros/lintia.png", 50, 5, 6, 4, 3);
        warriorContainer.warriorArrayList.add(warrior1);
        weaponContainer.weaponArrayList.add(new Weapon(warrior1, 1,2));
    }
}