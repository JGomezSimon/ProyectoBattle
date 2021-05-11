package proyecto.battle;

import proyecto.battle.gui.MainPanel;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        JFrame frame = new MainPanel();
        frame.setVisible(true);
    }
}