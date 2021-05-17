package proyecto.battle.gui;

import proyecto.battle.Main;
import proyecto.battle.Warrior;
import proyecto.battle.containers.WarriorContainer;
import proyecto.battle.containers.WeaponContainer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class BattlePanel extends MainPanel{
    public static Warrior chosenWarrior;
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

    public BattlePanel() throws IOException {
        this.setPreferredSize(new Dimension(620, 490));
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);

        Random random = new Random();
        Warrior atacante;
        Warrior defensor;

        JButton button1 = new JButton("Return to Menu");
        JButton button2 = new JButton("Play again");
        jDialog = new JDialog(this, "", true);
        jDialog.add(new JLabel());
        jDialog.setLocationRelativeTo(null);
        jDialog.setLayout(new FlowLayout());
        jDialog.setSize(250, 100);
        jDialog.add(button1);
        jDialog.add(button2);
        button1.addActionListener(e -> {
            jDialog.setVisible(false);
            this.dispose();
            this.setVisible(false);
            Main.mainPanel.setVisible(true);
        });
        button2.addActionListener (e -> {
            this.dispose();
            try {
                Main.battlePanel = new BattlePanel();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            Main.battlePanel.setVisible(true);
            jDialog.setVisible(false);
        });
        jDialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                button1.doClick();
            }
        });

        int random9 = random.nextInt(8);
        if (WarriorContainer.warriorArrayList.get(random9) == chosenWarrior) random9 = random9 - 1;
        cpu = WarriorContainer.warriorArrayList.get(random9);
        cpu.setWeapon(WeaponContainer.weaponArrayList.get(random9));

        int totalLifeCPU = cpu.getLife();
        int totalLifePlayer = cpu.getLife();

        progressBar5A.setMaximum(chosenWarrior.getLife());
        progressBar5A.setValue(chosenWarrior.getLife());
        progressBar5B.setMaximum(cpu.getLife());
        progressBar5B.setValue(cpu.getLife());

        progressBar1B.setMaximum(11);
        progressBar2B.setMaximum(7);
        progressBar3B.setMaximum(12);
        progressBar4B.setMaximum(4);
        progressBar1B.setValue(chosenWarrior.getStrength() + chosenWarrior.getWeapon().getStrength());
        progressBar1B.setString(String.valueOf(chosenWarrior.getStrength() + chosenWarrior.getStrength()));
        progressBar2B.setValue(chosenWarrior.getAgility());
        progressBar2B.setString(String.valueOf(chosenWarrior.getAgility()));
        progressBar3B.setValue(chosenWarrior.getSpeed() + chosenWarrior.getWeapon().getSpeed());
        progressBar3B.setString(String.valueOf(chosenWarrior.getSpeed() + chosenWarrior.getSpeed()));
        progressBar4B.setValue(chosenWarrior.getDefense());
        progressBar4B.setString(String.valueOf(chosenWarrior.getDefense()));

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

        photoLabel1A.setIcon(new ImageIcon(ImageIO.read(new File(cpu.getUrl()))));
        photoLabel1A.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        photoLabel1B.setIcon(new ImageIcon(ImageIO.read(new File(chosenWarrior.getUrl()))));
        photoLabel1B.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        photoLabel2A.setIcon(new ImageIcon(ImageIO.read(new File(cpu.getWeapon().getUrl())).getScaledInstance(75, 75, Image.SCALE_SMOOTH)));
        photoLabel2B.setIcon(new ImageIcon(ImageIO.read(new File(chosenWarrior.getWeapon().getUrl())).getScaledInstance(75, 75, Image.SCALE_SMOOTH)));

        if (chosenWarrior.getSpeed() > cpu.getSpeed()) {
            atacante = chosenWarrior;
            defensor = cpu;
        } else if (chosenWarrior.getSpeed() < cpu.getSpeed()) {
            atacante = cpu;
            defensor = chosenWarrior;
        } else {
            if (chosenWarrior.getAgility() > cpu.getAgility()) {
                atacante = chosenWarrior;
                defensor = cpu;
            } else if (chosenWarrior.getAgility() < cpu.getAgility()){
                atacante = cpu;
                defensor = chosenWarrior;
            } else {
                if (random.nextInt(2) > 0){
                    atacante = cpu;
                    defensor = chosenWarrior;
                }
                else {
                    atacante = chosenWarrior;
                    defensor = cpu;
                }
            }
        }

        fightButton.addActionListener(actionEvent -> {
            if (battle(defensor, atacante, random)){
                if (battle(atacante, defensor, random)){
                    // Update Life
                    progressBar5B.setValue(cpu.getLife());
                    progressBar5A.setValue(chosenWarrior.getLife());
                    if (cpu.getLife() <= totalLifeCPU*0.2){
                        progressBar5B.setForeground(Color.RED);
                    } else if (cpu.getLife() <= totalLifeCPU*0.6){
                        progressBar5B.setForeground(Color.YELLOW);
                    }
                    if (chosenWarrior.getLife() <= totalLifePlayer*0.2){
                        progressBar5A.setForeground(Color.RED);
                    } else if (chosenWarrior.getLife() <= totalLifePlayer*0.6){
                        progressBar5A.setForeground(Color.YELLOW);
                    }
                } else {
                    chosenWarrior.setLife(totalLifePlayer);
                    cpu.setLife(totalLifeCPU);
                    jDialog.setVisible(true);
                }
            } else {
                chosenWarrior.setLife(totalLifePlayer);
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
                    textArea1.append("Attack evaded\n");
                } else {
                    int attack = (attacker.getStrength() + chosenWarrior.getWeapon().getStrength()) - defender.getDefense();
                    if (random.nextInt(19) + 1 == 1) {
                        textArea1.append("Critic!! ");
                        attack = (attacker.getStrength() + chosenWarrior.getWeapon().getStrength()) * 2 - defender.getDefense();
                    }
                    defender.setLife(defender.getLife() - (attack));
                    textArea1.append("-" + attack + " of life to " + defender.getName() + "\n");
                }
            } else {
                textArea1.append("Attack failed\n");
            }
            if (defender.getLife() <= 0) {
                if (defender == chosenWarrior)
                    jDialog.setTitle("You have won!! ;D");
                else
                    jDialog.setTitle("You have lost.. :(");
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
}
