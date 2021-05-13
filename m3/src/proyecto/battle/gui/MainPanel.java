package proyecto.battle.gui;

import proyecto.battle.Main;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainPanel extends JFrame{
    private JPanel mainPanel;
    private JButton jugarButton;
    private JButton escogerPersonajeButton;
    private JButton escogerArmaButton;
    private JButton salirButton;
    private JButton confirmarButton;
    private JButton confirmarButton1;
    private JButton resetButton;
    private final JDialog jDialog;

    public MainPanel() {
        super("main.project.battle");
        this.setPreferredSize(new Dimension(500,300));
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);

        JButton button = new JButton("Ok");
        jDialog = new JDialog(this, "", true);
        jDialog.add(new JLabel ("You can't confirm before choosing"));
        jDialog.setLocationRelativeTo(null);
        jDialog.setLayout(new FlowLayout());
        jDialog.setSize(250,100);
        jDialog.add(button);
        button.addActionListener (e -> jDialog.setVisible(false));

        escogerArmaButton.setEnabled(false);
        jugarButton.setEnabled(false);
        confirmarButton1.setEnabled(false);

        escogerArmaButton.addActionListener(actionEvent -> {
            this.setVisible(false);
            Main.weaponPanel.setVisible(true);
        });
        escogerPersonajeButton.addActionListener(actionEvent -> {
            this.setVisible(false);
            Main.warriorPanel.setVisible(true);
        });
        confirmarButton.addActionListener(actionEvent -> {
            if (BattlePanel.chosenWarrior != null){
                escogerArmaButton.setEnabled(true);
                escogerPersonajeButton.setEnabled(false);
                confirmarButton.setEnabled(false);
                confirmarButton1.setEnabled(true);
            } else {
                jDialog.setVisible(true);
            }
        });
        confirmarButton1.addActionListener(actionEvent -> {
            if (BattlePanel.chosenWeapon != null){
                escogerArmaButton.setEnabled(false);
                jugarButton.setEnabled(true);
                confirmarButton1.setEnabled(false);
            } else {
                jDialog.setVisible(true);
            }
        });
        salirButton.addActionListener(actionEvent -> System.exit(0));
        jugarButton.addActionListener(actionEvent -> {
            jugarButton.setEnabled(false);
            try {
                Main.battlePanel = new BattlePanel();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.setVisible(false);
            Main.battlePanel.setVisible(true);
            escogerPersonajeButton.setEnabled(true);
            confirmarButton.setEnabled(true);
        });
        resetButton.addActionListener(actionEvent -> {
            escogerPersonajeButton.setEnabled(true);
            escogerArmaButton.setEnabled(false);
            confirmarButton.setEnabled(true);
            confirmarButton1.setEnabled(false);

        });
    }
}