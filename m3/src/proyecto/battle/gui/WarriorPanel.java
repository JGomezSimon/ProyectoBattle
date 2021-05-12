package proyecto.battle.gui;

import proyecto.battle.Main;
import proyecto.battle.containers.WarriorContainer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class WarriorPanel extends MainPanel{
    private JPanel warriorPanel;
    private JButton guerrero1;
    private JButton guerrero2;
    private JButton guerrero3;
    private JButton guerrero4;
    private JButton guerrero5;
    private JButton guerrero6;
    private JButton guerrero7;
    private JButton guerrero8;
    private JButton guerrero9;
    private JButton salirButton;

    public WarriorPanel() throws IOException {
        this.setPreferredSize(new Dimension(400,950));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(warriorPanel);
        this.pack();
        this.setLocationRelativeTo(null);

        guerrero1.setIcon(new ImageIcon(ImageIO.read(new File(WarriorContainer.warriorArrayList.get(0).getUrl()))));
        guerrero2.setIcon(new ImageIcon(ImageIO.read(new File(WarriorContainer.warriorArrayList.get(1).getUrl()))));
        guerrero3.setIcon(new ImageIcon(ImageIO.read(new File(WarriorContainer.warriorArrayList.get(2).getUrl()))));
        guerrero4.setIcon(new ImageIcon(ImageIO.read(new File(WarriorContainer.warriorArrayList.get(3).getUrl()))));
        guerrero5.setIcon(new ImageIcon(ImageIO.read(new File(WarriorContainer.warriorArrayList.get(4).getUrl()))));
        guerrero6.setIcon(new ImageIcon(ImageIO.read(new File(WarriorContainer.warriorArrayList.get(5).getUrl()))));
        guerrero7.setIcon(new ImageIcon(ImageIO.read(new File(WarriorContainer.warriorArrayList.get(6).getUrl()))));
        guerrero8.setIcon(new ImageIcon(ImageIO.read(new File(WarriorContainer.warriorArrayList.get(7).getUrl()))));
        guerrero9.setIcon(new ImageIcon(ImageIO.read(new File(WarriorContainer.warriorArrayList.get(8).getUrl()))));

        salirButton.addActionListener(actionEvent -> {
            this.setVisible(false);
            Main.frame.setVisible(true);
        });

        guerrero1.addActionListener(actionEvent -> finishPanel(0));
        guerrero2.addActionListener(actionEvent -> finishPanel(1));
        guerrero3.addActionListener(actionEvent -> finishPanel(2));
        guerrero4.addActionListener(actionEvent -> finishPanel(3));
        guerrero5.addActionListener(actionEvent -> finishPanel(4));
        guerrero6.addActionListener(actionEvent -> finishPanel(5));
        guerrero7.addActionListener(actionEvent -> finishPanel(6));
        guerrero8.addActionListener(actionEvent -> finishPanel(7));
        guerrero9.addActionListener(actionEvent -> finishPanel(8));
    }
    void finishPanel(int id){
        BattlePanel.chosenWarrior = WarriorContainer.warriorArrayList.get(id);
        try { Main.weaponPanel = new WeaponPanel();
        } catch (IOException e) {e.printStackTrace();}
        this.setVisible(false);
        Main.frame.setVisible(true);
    }


}
