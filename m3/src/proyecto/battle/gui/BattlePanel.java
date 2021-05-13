package proyecto.battle.gui;

import proyecto.battle.Warrior;
import proyecto.battle.Weapon;
import proyecto.battle.containers.WarriorContainer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class BattlePanel extends MainPanel{
    public static Warrior chosenWarrior;
    public static Weapon chosenWeapon;
    private JLabel label1A;
    private JLabel label2A;
    private JPanel mainPanel;
    private JPanel panel2;
    private JLabel label1B;
    private JLabel label2B;
    private JLabel photoLabel1B;
    private JLabel photoLabel2B;
    private JLabel label3B;
    private JLabel label4B;
    private JProgressBar progressBar5B;
    private JProgressBar progressBar1B;
    private JProgressBar progressBar2B;
    private JProgressBar progressBar3B;
    private JProgressBar progressBar4B;
    private JLabel label3A;
    private JLabel label4A;
    private JProgressBar progressBar5A;
    private JProgressBar progressBar2A;
    private JProgressBar progressBar1A;
    private JProgressBar progressBar3A;
    private JProgressBar progressBar4A;
    private JLabel photoLabel1A;
    private JLabel photoLabel2A;
    private JTextArea textArea1;
    private JButton clearConsoleButton;
    private JButton fightButton;

    public BattlePanel() throws IOException {
        this.setPreferredSize(new Dimension(620,450));
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);

        Warrior cpu = WarriorContainer.warriorArrayList.get(2);

        photoLabel1A.setIcon(new ImageIcon(ImageIO.read(new File("assets/warriors/battle/nedraec.jpeg"))));
        photoLabel1A.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        photoLabel1B.setIcon(new ImageIcon(ImageIO.read(new File("assets/warriors/battle/samfoli.jpg"))));
        photoLabel1B.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        photoLabel2A.setIcon(new ImageIcon(ImageIO.read(new File("assets/weapons/battle/sword.jpg"))));
        photoLabel2B.setIcon(new ImageIcon(ImageIO.read(new File("assets/weapons/battle/axe.png"))));

        Random random = new Random();
        Warrior atacante;
        Warrior defensor;

        if (chosenWarrior == null){
            System.out.println("le cagao");
        }
        if (chosenWarrior.getSpeed() > cpu.getSpeed()){
            atacante = chosenWarrior;
            defensor = cpu;
        } else if (chosenWarrior.getSpeed() < cpu.getSpeed()){
            atacante = cpu;
            defensor = chosenWarrior;
        } else {
            if (chosenWarrior.getAgility() > cpu.getSpeed()){
                atacante = chosenWarrior;
                defensor = cpu;
            } else if (chosenWarrior.getSpeed() < cpu.getSpeed()){
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
            if (random.nextInt(99)+1 > defensor.getAgility()*10){
                if (random.nextInt(49)+1 < defensor.getAgility()){
                    textArea1.append("Attack evaded\n");
                } else {
                    int attack = (atacante.getStrength() + chosenWeapon.getStrength()) - defensor.getDefense();
                    if (random.nextInt(19)+1 == 1) {
                        textArea1.append("Crítico!! ");
                        attack = ((atacante.getStrength() + chosenWeapon.getStrength()) - defensor.getDefense()) * 2;
                    }
                    defensor.setLife(defensor.getLife() - (attack));
                    textArea1.append("-"+attack+" de vida a "+defensor.getNom()+"\n");
                }
            } else {
                textArea1.append("Attack failed\n");
            }
        });
    }


}
