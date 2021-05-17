package proyecto.battle.gui;

import proyecto.battle.Main;
import proyecto.battle.containers.WeaponContainer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

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

        switch (LoginPanel.player.getWarrior().getRace_id()) {
            case 1: // Enano
                comboBox1.addItem(WeaponContainer.weaponArrayList.get(2).getName());
                comboBox1.addItem(WeaponContainer.weaponArrayList.get(7).getName());
                comboBox1.addItem(WeaponContainer.weaponArrayList.get(3).getName());
                comboBox1.addItem(WeaponContainer.weaponArrayList.get(8).getName());
                break;
            case 2: // Elfo
                comboBox1.addItem(WeaponContainer.weaponArrayList.get(7).getName());
                comboBox1.addItem(WeaponContainer.weaponArrayList.get(0).getName());
                comboBox1.addItem(WeaponContainer.weaponArrayList.get(3).getName());
                comboBox1.addItem(WeaponContainer.weaponArrayList.get(1).getName());
                comboBox1.addItem(WeaponContainer.weaponArrayList.get(4).getName());
                comboBox1.addItem(WeaponContainer.weaponArrayList.get(5).getName());
                break;
            case 3: // Humano
                comboBox1.addItem(WeaponContainer.weaponArrayList.get(7).getName());
                comboBox1.addItem(WeaponContainer.weaponArrayList.get(0).getName());
                comboBox1.addItem(WeaponContainer.weaponArrayList.get(2).getName());
                comboBox1.addItem(WeaponContainer.weaponArrayList.get(3).getName());
                comboBox1.addItem(WeaponContainer.weaponArrayList.get(1).getName());
                comboBox1.addItem(WeaponContainer.weaponArrayList.get(4).getName());
                comboBox1.addItem(WeaponContainer.weaponArrayList.get(6).getName());
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
            Main.mainPanel.setVisible(true);
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
    void finishPanel(int id) {
        LoginPanel.player.getWarrior().setWeapon(WeaponContainer.weaponArrayList.get(id));
        Main.logger.log(Level.INFO, "The player have choose " + WeaponContainer.weaponArrayList.get(id).getName() + " [weapon]");
        this.setVisible(false);
        Main.mainPanel.setVisible(true);
    }
}
