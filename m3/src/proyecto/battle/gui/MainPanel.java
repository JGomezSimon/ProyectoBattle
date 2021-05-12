package proyecto.battle.gui;

import proyecto.battle.Main;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JFrame{
    protected JPanel mainPanel;
    protected JButton jugarButton;
    protected JButton escogerPersonajeButton;
    protected JButton escogerArmaButton;
    protected JButton salirButton;

    public MainPanel() {
        super("main.project.battle");
        this.setPreferredSize(new Dimension(500,300));
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);

        escogerArmaButton.setEnabled(false);

        escogerArmaButton.addActionListener(actionEvent -> {
            this.setVisible(false);
            Main.weaponPanel.setVisible(true);
        });
        escogerPersonajeButton.addActionListener(actionEvent -> {
            this.setVisible(false);
            Main.warriorPanel.setVisible(true);
        });
        salirButton.addActionListener(actionEvent -> System.exit(0));
    }
}