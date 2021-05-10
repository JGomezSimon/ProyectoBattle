package proyecto.battle;

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
    }
}