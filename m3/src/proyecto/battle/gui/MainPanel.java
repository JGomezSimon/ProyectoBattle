package proyecto.battle.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainPanel extends JFrame{
    private JPanel mainPanel;
    private JButton jugarButton;
    private JButton escogerPersonajeButton;
    private JButton salirButton;
    private JButton escogerArmaButton;
    private JLabel imagenLabel;

    public MainPanel() throws IOException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        BufferedImage bufferedImage = ImageIO.read(new File("assets/gui/background.png"));
        imagenLabel.setIcon(new ImageIcon(bufferedImage));
        escogerArmaButton.addActionListener(actionEvent -> {
            JFrame frame = new WeaponPanel();
            this.setVisible(false);
            frame.setVisible(true);
        });
    }
}