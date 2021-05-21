import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;

public class WarriorPanel extends MainPanel {
    private JPanel warriorPanel;
    private JButton salirButton;
    private JLabel photoLabel1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JProgressBar progressBar1;
    private JProgressBar progressBar2;
    private JProgressBar progressBar3;
    private JProgressBar progressBar4;
    private JComboBox<String> comboBox1;
    private JProgressBar progressBar5;
    private JLabel label5;
    private int selectedWarrior;

    public WarriorPanel() throws IOException {
        this.setPreferredSize(new Dimension(330, 400));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(warriorPanel);
        this.pack();
        this.setLocationRelativeTo(null);

        for (Warrior i : WarriorContainer.warriorArrayList) comboBox1.addItem(i.getName());

        // set of the bars and images
        progressBar1.setMaximum(6);
        progressBar2.setMaximum(7);
        progressBar3.setMaximum(7);
        progressBar4.setMaximum(4);
        progressBar5.setMaximum(60);
        selectedWarrior = 0;
        try {
            photoLabel1.setIcon(new ImageIcon(ImageIO.read(new File(WarriorContainer.warriorArrayList.get(0).getUrl())).getScaledInstance(310, 215, Image.SCALE_SMOOTH)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        progressBar1.setString(String.valueOf(WarriorContainer.warriorArrayList.get(0).getStrength()));
        progressBar2.setString(String.valueOf(WarriorContainer.warriorArrayList.get(0).getAgility()));
        progressBar3.setString(String.valueOf(WarriorContainer.warriorArrayList.get(0).getSpeed()));
        progressBar4.setString(String.valueOf(WarriorContainer.warriorArrayList.get(0).getDefense()));
        progressBar5.setString(String.valueOf(WarriorContainer.warriorArrayList.get(0).getLife()));
        progressBar1.setValue(WarriorContainer.warriorArrayList.get(0).getStrength());
        progressBar2.setValue(WarriorContainer.warriorArrayList.get(0).getAgility());
        progressBar3.setValue(WarriorContainer.warriorArrayList.get(0).getSpeed());
        progressBar4.setValue(WarriorContainer.warriorArrayList.get(0).getDefense());
        progressBar5.setValue(WarriorContainer.warriorArrayList.get(0).getLife());

        // button event to close the panel
        salirButton.addActionListener(actionEvent -> {
            this.setVisible(false);
            Main.mainPanel.setVisible(true);
            finishPanel(selectedWarrior);
        });

        // como box event to determinate what warrior is chosen and change the image
        comboBox1.addActionListener(actionEvent -> {
            for (int i = 0; i < 9; i++) {
                if (WarriorContainer.warriorArrayList.get(i).getName().equals(comboBox1.getSelectedItem())) {
                    selectedWarrior = i;
                    try {
                        photoLabel1.setIcon(new ImageIcon(ImageIO.read(new File(WarriorContainer.warriorArrayList.get(i).getUrl())).getScaledInstance(310, 215, Image.SCALE_SMOOTH)));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    progressBar1.setString(String.valueOf(WarriorContainer.warriorArrayList.get(i).getStrength()));
                    progressBar2.setString(String.valueOf(WarriorContainer.warriorArrayList.get(i).getAgility()));
                    progressBar3.setString(String.valueOf(WarriorContainer.warriorArrayList.get(i).getSpeed()));
                    progressBar4.setString(String.valueOf(WarriorContainer.warriorArrayList.get(i).getDefense()));
                    progressBar5.setString(String.valueOf(WarriorContainer.warriorArrayList.get(i).getLife()));
                    progressBar1.setValue(WarriorContainer.warriorArrayList.get(i).getStrength());
                    progressBar2.setValue(WarriorContainer.warriorArrayList.get(i).getAgility());
                    progressBar3.setValue(WarriorContainer.warriorArrayList.get(i).getSpeed());
                    progressBar4.setValue(WarriorContainer.warriorArrayList.get(i).getDefense());
                    progressBar5.setValue(WarriorContainer.warriorArrayList.get(i).getLife());
                }
            }
        });
    }

    // event when the panel is closed that sets the warrior that the player have chosen
    void finishPanel(int id) {
        if (Main.player.getWarrior() != WarriorContainer.warriorArrayList.get(id)) {
            Main.player.setWarrior(WarriorContainer.warriorArrayList.get(id));
            Main.logger.log(Level.INFO, "The player have choose " + WarriorContainer.warriorArrayList.get(id).getName() + " [warrior]");
            Main.logger.log(Level.INFO, "Resetting players stats to 0");
            Main.player.setLost(0);
            Main.player.setWon(0);
            Main.player.setPoints(0);
            try {
                Events.updatePlayerStatsDB();
                Events.setWarriorDB();
            } catch (SQLException | NullPointerException throwables) {
                try {
                    Events.updatePlayerStatsJSON();
                } catch (IOException ignored) {
                }
            }
        }
        try {
            Main.weaponPanel = new WeaponPanel();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setVisible(false);
        Main.mainPanel.setVisible(true);
    }


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        warriorPanel = new JPanel();
        warriorPanel.setLayout(new GridBagLayout());
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        warriorPanel.add(panel1, gbc);
        panel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        photoLabel1 = new JLabel();
        photoLabel1.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(photoLabel1, gbc);
        comboBox1 = new JComboBox();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(comboBox1, gbc);
        salirButton = new JButton();
        salirButton.setBorderPainted(true);
        salirButton.setContentAreaFilled(true);
        salirButton.setText("Confirm");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(salirButton, gbc);
        label2 = new JLabel();
        label2.setText("Agility");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(label2, gbc);
        label3 = new JLabel();
        label3.setText("Speed");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(label3, gbc);
        label4 = new JLabel();
        label4.setText("Defense");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(label4, gbc);
        progressBar2 = new JProgressBar();
        progressBar2.setForeground(new Color(-8380803));
        progressBar2.setStringPainted(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(progressBar2, gbc);
        progressBar3 = new JProgressBar();
        progressBar3.setForeground(new Color(-5258988));
        progressBar3.setStringPainted(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(progressBar3, gbc);
        progressBar4 = new JProgressBar();
        progressBar4.setForeground(new Color(-14538880));
        progressBar4.setStringPainted(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(progressBar4, gbc);
        progressBar5 = new JProgressBar();
        progressBar5.setForeground(new Color(-16518144));
        progressBar5.setStringPainted(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(progressBar5, gbc);
        progressBar1 = new JProgressBar();
        progressBar1.setForeground(new Color(-6476004));
        progressBar1.setStringPainted(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(progressBar1, gbc);
        label5 = new JLabel();
        label5.setText("Life");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(label5, gbc);
        label1 = new JLabel();
        label1.setText("Strength");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(label1, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return warriorPanel;
    }
}
