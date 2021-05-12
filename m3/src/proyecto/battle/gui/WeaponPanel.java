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
        this.setPreferredSize(new Dimension(700,650));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(weaponPanel);
        this.pack();
        this.setLocationRelativeTo(null);

        knife.setIcon(new ImageIcon(ImageIO.read(new File(WeaponContainer.weaponArrayList.get(7).getUrl()))));
        dagger.setIcon(new ImageIcon(ImageIO.read(new File(WeaponContainer.weaponArrayList.get(0).getUrl()))));
        axe.setIcon(new ImageIcon(ImageIO.read(new File(WeaponContainer.weaponArrayList.get(2).getUrl()))));
        twinSwords.setIcon(new ImageIcon(ImageIO.read(new File(WeaponContainer.weaponArrayList.get(3).getUrl()))));
        sword.setIcon(new ImageIcon(ImageIO.read(new File(WeaponContainer.weaponArrayList.get(1).getUrl()))));
        scimitar.setIcon(new ImageIcon(ImageIO.read(new File(WeaponContainer.weaponArrayList.get(4).getUrl()))));
        bow.setIcon(new ImageIcon(ImageIO.read(new File(WeaponContainer.weaponArrayList.get(5).getUrl()))));
        katana.setIcon(new ImageIcon(ImageIO.read(new File(WeaponContainer.weaponArrayList.get(6).getUrl()))));
        twoHandedAxe.setIcon(new ImageIcon(ImageIO.read(new File(WeaponContainer.weaponArrayList.get(8).getUrl()))));

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

        salirButton.addActionListener(actionEvent -> {
            this.setVisible(false);
            Main.frame.setVisible(true);
        });

        knife.addActionListener(actionEvent -> finishPanel(7));
        dagger.addActionListener(actionEvent -> finishPanel(0));
        axe.addActionListener(actionEvent -> finishPanel(2));
        sword.addActionListener(actionEvent -> finishPanel(1));
        twinSwords.addActionListener(actionEvent -> finishPanel(3));
        bow.addActionListener(actionEvent -> finishPanel(5));
        katana.addActionListener(actionEvent -> finishPanel(6));
        twoHandedAxe.addActionListener(actionEvent -> finishPanel(8));
        scimitar.addActionListener(actionEvent -> finishPanel(4));
    }
    void finishPanel(int id){
        BattlePanel.chosenWeapon = WeaponContainer.weaponArrayList.get(id);
        this.setVisible(false);
        Main.frame.setVisible(true);
    }
}
