package proyecto.battle.gui;

import proyecto.battle.Battle;

import javax.swing.*;

public class WeaponPanel extends JFrame{
    private JPanel weaponPanel;
    private JButton imgButton;
    private JButton imgButton1;
    private JButton imgButton2;
    private JButton imgButton3;
    private JButton imgButton4;
    private JButton imgButton5;
    private JButton imgButton6;
    private JButton imgButton7;
    private JButton imgButton8;
    private JButton salirButton;

    public WeaponPanel() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(weaponPanel);
        this.pack();
        switch (Battle.warrior1.getId()){
            case 1:
                imgButton.setEnabled(true);
            case 2:
            case 3:
        }
    }
}
