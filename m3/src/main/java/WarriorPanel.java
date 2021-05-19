import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
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
        Main.player.setWarrior(WarriorContainer.warriorArrayList.get(id));
        Main.logger.log(Level.INFO, "The player have choose " + WarriorContainer.warriorArrayList.get(id).getName() + " [warrior]");
        try {
            Main.weaponPanel = new WeaponPanel();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setVisible(false);
        Main.mainPanel.setVisible(true);
    }


}
