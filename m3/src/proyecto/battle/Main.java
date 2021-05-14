package proyecto.battle;

import proyecto.battle.gui.MainPanel;
import proyecto.battle.gui.WarriorPanel;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static JFrame frame;
    public static JFrame weaponPanel;
    public static JFrame warriorPanel;
    public static JFrame battlePanel;

    public static void main(String[] args) {
        // Try import DB if fail, do it manually
        try {
            Events.importDB();
        } catch (SQLException | ClassNotFoundException throwables) {
            Events.importNoDB();
        }
        // Initialize MainPanel and WarriorPanel
        frame = new MainPanel();
        frame.setVisible(true);
        try {
            warriorPanel = new WarriorPanel();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}