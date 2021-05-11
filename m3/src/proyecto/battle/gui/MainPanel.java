package proyecto.battle.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainPanel extends JFrame{
    private JPanel mainPanel;
    private JButton jugarButton;
    private JButton escojerPersonajeButton1;
    private JButton salirButton;
    private JButton escojerArmaButton;
    private JLabel imagenLabel;

    public MainPanel() throws IOException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        BufferedImage bufferedImage = ImageIO.read(new File("assets/gui/background.png"));
        imagenLabel.setIcon(new ImageIcon(bufferedImage));
    }
}