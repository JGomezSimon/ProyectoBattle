package proyecto.battle;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageComponent extends JPanel {
    private BufferedImage image;

    public ImageComponent(String urlFoto) {
        try {
            image = ImageIO.read(new File(urlFoto));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int x = 0, y = 0;
        g2d.drawImage(image.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH), x, y, this);
    }

    public void setImage(String urlFoto) {
        System.out.println("establecemos en el panel la foto " + urlFoto);
        try {
            this.image = ImageIO.read(new File(urlFoto));
        } catch (IOException e) {
            e.printStackTrace();
        }
        repaint();
    }
}
