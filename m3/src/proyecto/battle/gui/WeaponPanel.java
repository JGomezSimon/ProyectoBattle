package proyecto.battle.gui;

import proyecto.battle.Main;
import proyecto.battle.containers.WeaponContainer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class WeaponPanel extends MainPanel{
    private JPanel weaponPanel;
    private JButton knife;
    private JButton dagger;
    private JButton axe;
    private JButton twinSwords;
    private JButton sword;
    private JButton scimitar;
    private JButton bow;
    private JButton katana;
    private JButton twoHandedAxe;
    private JButton salirButton;

    public WeaponPanel() throws IOException {
        this.setPreferredSize(new Dimension(345,650));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(weaponPanel);
        this.pack();
        this.setLocationRelativeTo(null);

        knife.setIcon(new ImageIcon(ImageIO.read(new File(WeaponContainer.weaponArrayList.get(7).getUrl()))));
        knife.setBorderPainted(false);
        knife.setContentAreaFilled(false);
        dagger.setIcon(new ImageIcon(ImageIO.read(new File(WeaponContainer.weaponArrayList.get(0).getUrl()))));
        dagger.setBorderPainted(false);
        dagger.setContentAreaFilled(false);
        axe.setIcon(new ImageIcon(ImageIO.read(new File(WeaponContainer.weaponArrayList.get(2).getUrl()))));
        axe.setBorderPainted(false);
        axe.setContentAreaFilled(false);
        twinSwords.setIcon(new ImageIcon(ImageIO.read(new File(WeaponContainer.weaponArrayList.get(3).getUrl()))));
        twinSwords.setBorderPainted(false);
        twinSwords.setContentAreaFilled(false);
        sword.setIcon(new ImageIcon(ImageIO.read(new File(WeaponContainer.weaponArrayList.get(1).getUrl()))));
        sword.setBorderPainted(false);
        sword.setContentAreaFilled(false);
        scimitar.setIcon(new ImageIcon(ImageIO.read(new File(WeaponContainer.weaponArrayList.get(4).getUrl()))));
        scimitar.setBorderPainted(false);
        scimitar.setContentAreaFilled(false);
        bow.setIcon(new ImageIcon(ImageIO.read(new File(WeaponContainer.weaponArrayList.get(5).getUrl()))));
        bow.setBorderPainted(false);
        bow.setContentAreaFilled(false);
        katana.setIcon(new ImageIcon(ImageIO.read(new File(WeaponContainer.weaponArrayList.get(6).getUrl()))));
        katana.setBorderPainted(false);
        katana.setContentAreaFilled(false);
        twoHandedAxe.setIcon(new ImageIcon(ImageIO.read(new File(WeaponContainer.weaponArrayList.get(8).getUrl()))));
        twoHandedAxe.setBorderPainted(false);
        twoHandedAxe.setContentAreaFilled(false);

        salirButton.addActionListener(actionEvent -> {
            this.setVisible(false);
            Main.frame.setVisible(true);
        });

        switch (BattlePanel.chosenWarrior.getId()){
            case 1: // Enano
                knife.setEnabled(true);
                axe.setEnabled(true);
                twinSwords.setEnabled(true);
                twoHandedAxe.setEnabled(true);
                break;
            case 2: // Elfo
                knife.setEnabled(true);
                dagger.setEnabled(true);
                twinSwords.setEnabled(true);
                sword.setEnabled(true);
                scimitar.setEnabled(true);
                bow.setEnabled(true);
                break;
            case 3: // Humano
                knife.setEnabled(true);
                dagger.setEnabled(true);
                axe.setEnabled(true);
                twinSwords.setEnabled(true);
                sword.setEnabled(true);
                scimitar.setEnabled(true);
                katana.setEnabled(true);
        }

        knife.addActionListener(actionEvent -> {BattlePanel.chosenWeapon = WeaponContainer.weaponArrayList.get(7);} );
        dagger.addActionListener(actionEvent -> {BattlePanel.chosenWeapon = WeaponContainer.weaponArrayList.get(0);});
        axe.addActionListener(actionEvent -> {BattlePanel.chosenWeapon = WeaponContainer.weaponArrayList.get(2);});
        sword.addActionListener(actionEvent -> {BattlePanel.chosenWeapon = WeaponContainer.weaponArrayList.get(1);});
        twinSwords.addActionListener(actionEvent -> {BattlePanel.chosenWeapon = WeaponContainer.weaponArrayList.get(3);});
        bow.addActionListener(actionEvent -> {BattlePanel.chosenWeapon = WeaponContainer.weaponArrayList.get(5);});
        katana.addActionListener(actionEvent -> {BattlePanel.chosenWeapon = WeaponContainer.weaponArrayList.get(6);});
        twoHandedAxe.addActionListener(actionEvent -> {BattlePanel.chosenWeapon = WeaponContainer.weaponArrayList.get(8);});
        scimitar.addActionListener(actionEvent -> {BattlePanel.chosenWeapon = WeaponContainer.weaponArrayList.get(4);});
    }
}
