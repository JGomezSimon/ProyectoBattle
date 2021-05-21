import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;

public class BattlePanel extends MainPanel {
    private JPanel mainPanel;
    private JLabel photoLabel1B;
    private JLabel photoLabel2B;
    private JLabel photoLabel1A;
    private JLabel photoLabel2A;
    private JLabel label1A;
    private JLabel label2A;
    private JLabel label3A;
    private JLabel label4A;
    private JLabel label1B;
    private JLabel label2B;
    private JLabel label3B;
    private JLabel label4B;
    private JLabel namePlayer;
    private JLabel nameCPU;
    private JProgressBar progressBar1B;
    private JProgressBar progressBar2B;
    private JProgressBar progressBar3B;
    private JProgressBar progressBar4B;
    private JProgressBar progressBar5B;
    private JProgressBar progressBar1A;
    private JProgressBar progressBar2A;
    private JProgressBar progressBar3A;
    private JProgressBar progressBar4A;
    private JProgressBar progressBar5A;
    private JButton clearConsoleButton;
    private JTextArea textArea1;
    private JButton fightButton;
    private final JDialog jDialog;
    Warrior cpu;
    JLabel labelDialog;

    public BattlePanel() throws IOException {
        this.setPreferredSize(new Dimension(620, 520));
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);

        Random random = new Random();
        Warrior attacker;
        Warrior defender;

        // creation of the the win/lost dialog
        JButton button1 = new JButton("Return to Menu");
        JButton button2 = new JButton("Play again");
        labelDialog = new JLabel("");
        jDialog = new JDialog(this, "", true);
        jDialog.add(new JLabel());
        jDialog.setLocationRelativeTo(null);
        jDialog.setLayout(new FlowLayout());
        jDialog.setSize(250, 100);
        jDialog.add(button1);
        jDialog.add(button2);
        jDialog.add(labelDialog);
        // Button event to return to menu
        button1.addActionListener(e -> {
            jDialog.setVisible(false);
            this.dispose();
            this.setVisible(false);
            Main.mainPanel.setVisible(true);
        });
        // Button event to play again
        button2.addActionListener(e -> {
            this.dispose();
            try {
                Main.battlePanel = new BattlePanel();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            Main.battlePanel.setVisible(true);
            jDialog.setVisible(false);
        });
        // If the player close the dialog do the button1 event
        jDialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                button1.doClick();
            }
        });

        // Generate random warrior to the CPU
        int random9 = random.nextInt(8);
        if (WarriorContainer.warriorArrayList.get(random9) == Main.player.getWarrior()) {
            if (random9 == 0)
                random9 = random9 + 1;
            else
                random9 = random9 - 1;
        }
        cpu = WarriorContainer.warriorArrayList.get(random9);
        cpu.setWeapon(WeaponContainer.weaponArrayList.get(random9));

        // Set the tag to view the warrior name of the player and CPU
        namePlayer.setText(Main.player.getWarrior().getName() + " [You]");
        nameCPU.setText(cpu.getName() + " [CPU]");

        //Add into player class the enemy Weapon_Id and Warrior_Id
        Main.player.setOpoId(cpu.getWaId());
        Main.player.setWepId(cpu.getWeapon().getWeId());


        int totalLifeCPU = cpu.getLife();
        int totalLifePlayer = cpu.getLife();

        // Set-up of the Bars
        progressBar5A.setMaximum(Main.player.getWarrior().getLife());
        progressBar5A.setValue(Main.player.getWarrior().getLife());
        progressBar5B.setMaximum(cpu.getLife());
        progressBar5B.setValue(cpu.getLife());
        progressBar1B.setMaximum(11);
        progressBar2B.setMaximum(7);
        progressBar3B.setMaximum(12);
        progressBar4B.setMaximum(4);
        progressBar1B.setValue(Main.player.getWarrior().getStrength() + Main.player.getWarrior().getWeapon().getStrength());
        progressBar1B.setString(String.valueOf(Main.player.getWarrior().getStrength() + Main.player.getWarrior().getStrength()));
        progressBar2B.setValue(Main.player.getWarrior().getAgility());
        progressBar2B.setString(String.valueOf(Main.player.getWarrior().getAgility()));
        progressBar3B.setValue(Main.player.getWarrior().getSpeed() + Main.player.getWarrior().getWeapon().getSpeed());
        progressBar3B.setString(String.valueOf(Main.player.getWarrior().getSpeed() + Main.player.getWarrior().getSpeed()));
        progressBar4B.setValue(Main.player.getWarrior().getDefense());
        progressBar4B.setString(String.valueOf(Main.player.getWarrior().getDefense()));
        progressBar1A.setMaximum(11);
        progressBar2A.setMaximum(7);
        progressBar3A.setMaximum(12);
        progressBar4A.setMaximum(4);
        progressBar1A.setValue(cpu.getStrength() + cpu.getWeapon().getStrength());
        progressBar1A.setString(String.valueOf(cpu.getStrength() + cpu.getWeapon().getStrength()));
        progressBar2A.setValue(cpu.getAgility());
        progressBar2A.setString(String.valueOf(cpu.getAgility()));
        progressBar3A.setValue(cpu.getSpeed() + cpu.getWeapon().getSpeed());
        progressBar3A.setString(String.valueOf(cpu.getSpeed() + cpu.getWeapon().getSpeed()));
        progressBar4A.setValue(cpu.getDefense());
        progressBar4A.setString(String.valueOf(cpu.getDefense()));

        // Set-up images of the warrior and weapon
        photoLabel1A.setIcon(new ImageIcon(ImageIO.read(new File(cpu.getUrl()))));
        photoLabel1A.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        photoLabel1B.setIcon(new ImageIcon(ImageIO.read(new File(Main.player.getWarrior().getUrl()))));
        photoLabel1B.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        photoLabel2A.setIcon(new ImageIcon(ImageIO.read(new File(cpu.getWeapon().getUrl())).getScaledInstance(75, 75, Image.SCALE_SMOOTH)));
        photoLabel2B.setIcon(new ImageIcon(ImageIO.read(new File(Main.player.getWarrior().getWeapon().getUrl())).getScaledInstance(75, 75, Image.SCALE_SMOOTH)));

        // Determinate who begins the battle
        if (Main.player.getWarrior().getSpeed() > cpu.getSpeed()) {
            attacker = Main.player.getWarrior();
            defender = cpu;
        } else if (Main.player.getWarrior().getSpeed() < cpu.getSpeed()) {
            attacker = cpu;
            defender = Main.player.getWarrior();
        } else {
            if (Main.player.getWarrior().getAgility() > cpu.getAgility()) {
                attacker = Main.player.getWarrior();
                defender = cpu;
            } else if (Main.player.getWarrior().getAgility() < cpu.getAgility()) {
                attacker = cpu;
                defender = Main.player.getWarrior();
            } else {
                if (random.nextInt(2) > 0) {
                    attacker = cpu;
                    defender = Main.player.getWarrior();
                } else {
                    attacker = Main.player.getWarrior();
                    defender = cpu;
                }
            }
        }

        fightButton.addActionListener(actionEvent -> {
            if (battle(defender, attacker, random)) {
                if (battle(attacker, defender, random)) {
                    // Update Life of the bars
                    progressBar5B.setValue(cpu.getLife());
                    progressBar5A.setValue(Main.player.getWarrior().getLife());
                    if (cpu.getLife() <= totalLifeCPU * 0.2) {
                        progressBar5B.setForeground(Color.RED);
                    } else if (cpu.getLife() <= totalLifeCPU * 0.6) {
                        progressBar5B.setForeground(Color.YELLOW);
                    }
                    if (Main.player.getWarrior().getLife() <= totalLifePlayer * 0.2) {
                        progressBar5A.setForeground(Color.RED);
                    } else if (Main.player.getWarrior().getLife() <= totalLifePlayer * 0.6) {
                        progressBar5A.setForeground(Color.YELLOW);
                    }
                } else {
                    // finish turn
                    Main.player.getWarrior().setLife(totalLifePlayer);
                    cpu.setLife(totalLifeCPU);
                    jDialog.setVisible(true);
                }
            } else {
                // finish turn
                Main.player.getWarrior().setLife(totalLifePlayer);
                cpu.setLife(totalLifeCPU);
                jDialog.setVisible(true);
            }
        });
        clearConsoleButton.addActionListener(actionEvent -> textArea1.setText(null));
    }

    boolean battle(Warrior defender, Warrior attacker, Random random) {
        boolean salir = true;
        while (salir) {
            if (random.nextInt(99) + 1 > defender.getAgility() * 10) {
                if (random.nextInt(49) + 1 < defender.getAgility()) {
                    textArea1.append(attacker.getName() + " evaded the attack\n");
                } else {
                    int attack = (attacker.getStrength() + attacker.getWeapon().getStrength()) - defender.getDefense();
                    if (random.nextInt(19) + 1 == 1) {
                        textArea1.append("Critic!! ");
                        attack = (attacker.getStrength() + attacker.getWeapon().getStrength()) * 2 - defender.getDefense();
                    }
                    defender.setLife(defender.getLife() - (attack));
                    textArea1.append("-" + attack + " of life to " + attacker.getName() + "\n");
                }
            } else {
                textArea1.append(defender.getName() + " missed the attack\n");
            }
            // finish battle and determinate if the player has won
            if (defender.getLife() <= 0) {
                if (defender == Main.player.getWarrior()) {
                    labelDialog.setText("You have won!! ;D");
                    Main.logger.log(Level.INFO, "The player won the game +" + (cpu.getPoints() + cpu.getWeapon().getPoints()));
                    Main.player.setPoints((int) (Main.player.getPoints() + (cpu.getPoints() + cpu.getWeapon().getPoints())));
                    Main.player.setWon((int) (Main.player.getWon() + 1));
                } else {
                    labelDialog.setText("You have lost.. :(");
                    Main.logger.log(Level.INFO, "The player lost the game");
                    Main.player.setLost((int) (Main.player.getLost() + 1));
                }
                try {
                    Events.updatePlayerStatsDB();
                    Events.saveBattleDB();
                } catch (SQLException | NullPointerException throwables) {
                    try {
                        Events.updatePlayerStatsJSON();
                    } catch (IOException ignored) {
                    }
                }
                return false;
            }
            if (attacker.getSpeed() <= defender.getSpeed()) {
                salir = false;
            } else {
                if (!((attacker.getSpeed() - defender.getSpeed()) * 10 > random.nextInt(99) + 1)) {
                    salir = false;
                }
            }
        }
        return true;
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
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(panel1, gbc);
        label1B = new JLabel();
        label1B.setInheritsPopupMenu(true);
        label1B.setText("Power");
        label1B.setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(label1B, gbc);
        label2B = new JLabel();
        label2B.setText("Agility");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(label2B, gbc);
        progressBar5B = new JProgressBar();
        progressBar5B.setForeground(new Color(-16518144));
        progressBar5B.setPreferredSize(new Dimension(219, 30));
        progressBar5B.setStringPainted(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(progressBar5B, gbc);
        photoLabel1B = new JLabel();
        photoLabel1B.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.NORTH;
        panel1.add(photoLabel1B, gbc);
        photoLabel2B = new JLabel();
        photoLabel2B.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridheight = 4;
        gbc.anchor = GridBagConstraints.WEST;
        panel1.add(photoLabel2B, gbc);
        label3B = new JLabel();
        label3B.setText("Speed");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(label3B, gbc);
        label4B = new JLabel();
        label4B.setText("Defense");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(label4B, gbc);
        progressBar1B = new JProgressBar();
        progressBar1B.setForeground(new Color(-6476004));
        progressBar1B.setIndeterminate(false);
        progressBar1B.setStringPainted(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel1.add(progressBar1B, gbc);
        progressBar2B = new JProgressBar();
        progressBar2B.setForeground(new Color(-8380803));
        progressBar2B.setStringPainted(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel1.add(progressBar2B, gbc);
        progressBar3B = new JProgressBar();
        progressBar3B.setForeground(new Color(-5258988));
        progressBar3B.setStringPainted(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel1.add(progressBar3B, gbc);
        progressBar4B = new JProgressBar();
        progressBar4B.setForeground(new Color(-14538880));
        progressBar4B.setStringPainted(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel1.add(progressBar4B, gbc);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        mainPanel.add(panel2, gbc);
        label1A = new JLabel();
        label1A.setText("Power");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(label1A, gbc);
        label2A = new JLabel();
        label2A.setText("Agility");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(label2A, gbc);
        progressBar5A = new JProgressBar();
        progressBar5A.setForeground(new Color(-16518144));
        progressBar5A.setMinimumSize(new Dimension(10, 40));
        progressBar5A.setPreferredSize(new Dimension(219, 30));
        progressBar5A.setStringPainted(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(progressBar5A, gbc);
        photoLabel1A = new JLabel();
        photoLabel1A.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.NORTH;
        panel2.add(photoLabel1A, gbc);
        photoLabel2A = new JLabel();
        photoLabel2A.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridheight = 4;
        gbc.anchor = GridBagConstraints.WEST;
        panel2.add(photoLabel2A, gbc);
        label3A = new JLabel();
        label3A.setText("Speed");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(label3A, gbc);
        label4A = new JLabel();
        label4A.setText("Defense");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(label4A, gbc);
        progressBar1A = new JProgressBar();
        progressBar1A.setForeground(new Color(-6476004));
        progressBar1A.setStringPainted(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel2.add(progressBar1A, gbc);
        progressBar2A = new JProgressBar();
        progressBar2A.setForeground(new Color(-8380803));
        progressBar2A.setStringPainted(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel2.add(progressBar2A, gbc);
        progressBar3A = new JProgressBar();
        progressBar3A.setForeground(new Color(-5258988));
        progressBar3A.setStringPainted(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel2.add(progressBar3A, gbc);
        progressBar4A = new JProgressBar();
        progressBar4A.setForeground(new Color(-14538880));
        progressBar4A.setStringPainted(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel2.add(progressBar4A, gbc);
        clearConsoleButton = new JButton();
        clearConsoleButton.setText("Clear Console");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(clearConsoleButton, gbc);
        fightButton = new JButton();
        fightButton.setText("Fight");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(fightButton, gbc);
        final JScrollPane scrollPane1 = new JScrollPane();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(scrollPane1, gbc);
        textArea1 = new JTextArea();
        textArea1.setEditable(false);
        textArea1.setRows(5);
        scrollPane1.setViewportView(textArea1);
        namePlayer = new JLabel();
        namePlayer.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(namePlayer, gbc);
        nameCPU = new JLabel();
        nameCPU.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(nameCPU, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}
