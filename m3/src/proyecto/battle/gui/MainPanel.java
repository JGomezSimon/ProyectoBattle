package proyecto.battle.gui;

import proyecto.battle.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel implements ActionListener {

    public MainPanel() {
        JButton myButton1 = new JButton("Jugar");
        JButton myButton2 = new JButton("Escollir personatge");
        JButton myButton3 = new JButton("Escollir arma");
        JButton myButton4 = new JButton("Sortir");
        Main.tabbedPane.add("Main", this);
        myButton1.addActionListener(this);
        myButton2.addActionListener(this);
        myButton3.addActionListener(this);
        myButton4.addActionListener(this);
        add(myButton1);
        add(myButton2);
        add(myButton3);
        add(myButton4);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("Enviar")) {
        }
    }
}

