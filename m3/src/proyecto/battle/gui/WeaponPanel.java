package proyecto.battle.gui;

import proyecto.battle.Main;
import proyecto.battle.Weapon;
import proyecto.battle.containers.WeaponContainer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class WeaponPanel extends MainPanel {
    private JPanel weaponPanel;
    private JButton salirButton;
    private JComboBox comboBox1;
    private JProgressBar progressBar1;
    private JProgressBar progressBar2;
    private JLabel imageLabel;
    private int selectedWeapon;

    public WeaponPanel() throws IOException {
        this.setPreferredSize(new Dimension(340, 130));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(weaponPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        ArrayList<String> weaponsAvailable = new ArrayList<>();

        switch (BattlePanel.chosenWarrior.getId()) {
            case 1: // Enano
                weaponsAvailable.add("Knife");
                weaponsAvailable.add("Axe");
                weaponsAvailable.add("TwinSwords");
                weaponsAvailable.add("TwoHandedAxe");
                break;
            case 2: // Elfo
                weaponsAvailable.add("Knife");
                weaponsAvailable.add("Dagger");
                weaponsAvailable.add("TwinSwords");
                weaponsAvailable.add("Sword");
                weaponsAvailable.add("Scimitar");
                weaponsAvailable.add("Bow");
                break;
            case 3: // Humano
                weaponsAvailable.add("Knife");
                weaponsAvailable.add("Dagger");
                weaponsAvailable.add("Axe");
                weaponsAvailable.add("TwinSwords");
                weaponsAvailable.add("Sword");
                weaponsAvailable.add("Scimitar");
                weaponsAvailable.add("Katana");
        }

        for (Weapon i : WeaponContainer.weaponArrayList) {
            for (String x : weaponsAvailable) {
                if (i.getName().equals(x))
                    comboBox1.addItem(i.getName());
            }
        }

        progressBar1.setMaximum(5);
        progressBar2.setMaximum(5);

        int temporalID = 0;
        for (int i = 0; i < 9; i++) {
            if (WeaponContainer.weaponArrayList.get(i).getName().equals(comboBox1.getSelectedItem()))
                temporalID = i;
        }

        progressBar1.setString(String.valueOf(WeaponContainer.weaponArrayList.get(temporalID).getStrength()));
        progressBar2.setString(String.valueOf(WeaponContainer.weaponArrayList.get(temporalID).getSpeed()));
        progressBar1.setValue(WeaponContainer.weaponArrayList.get(temporalID).getStrength());
        progressBar2.setValue(WeaponContainer.weaponArrayList.get(temporalID).getSpeed());
        try {
            imageLabel.setIcon(new ImageIcon(ImageIO.read(new File(WeaponContainer.weaponArrayList.get(temporalID).getUrl())).getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
        } catch (IOException e) {
            e.printStackTrace();
        }


        salirButton.addActionListener(actionEvent -> {
            this.setVisible(false);
            Main.frame.setVisible(true);
            finishPanel(selectedWeapon);
        });
        comboBox1.addActionListener(actionEvent -> {
            for (int i = 0; i < 9; i++) {
                if (WeaponContainer.weaponArrayList.get(i).getName().equals(comboBox1.getSelectedItem())) {
                    selectedWeapon = i;
                    try {
                        imageLabel.setIcon(new ImageIcon(ImageIO.read(new File(WeaponContainer.weaponArrayList.get(i).getUrl())).getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    progressBar1.setString(String.valueOf(WeaponContainer.weaponArrayList.get(i).getStrength()));
                    progressBar2.setString(String.valueOf(WeaponContainer.weaponArrayList.get(i).getSpeed()));
                    progressBar1.setValue(WeaponContainer.weaponArrayList.get(i).getStrength());
                    progressBar2.setValue(WeaponContainer.weaponArrayList.get(i).getSpeed());
                }
            }

        });
    }
    void finishPanel(int id){
        BattlePanel.chosenWeapon = WeaponContainer.weaponArrayList.get(id);
        this.setVisible(false);
        Main.frame.setVisible(true);
    }
}
