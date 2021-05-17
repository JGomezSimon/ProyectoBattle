package proyecto.battle.gui;

import proyecto.battle.Player;
import proyecto.battle.containers.PlayerContainer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class RankingPanel extends JFrame {
    JPanel panel = new JPanel();

    public RankingPanel() {
        super("main.project.battle");
        this.setPreferredSize(new Dimension(455, 400));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        String[] columnNames = {"Name", "Points", "Won", "Lost", "%Won"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        addToRanking(model);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setShowGrid(true);
        table.setBorder(null);
        this.add(scrollPane);
    }

    public void addToRanking(DefaultTableModel model) {
        for (Player i : PlayerContainer.playerArrayList) {
            Object[] row1 = {
                    i.getName(),
                    String.valueOf(i.getPoints()),
                    String.valueOf(i.getWon()),
                    String.valueOf(i.getLost()),
                    String.valueOf((i.getWon() / (i.getWon() + i.getLost())) * 100)
            };
            model.addRow(row1);
        }
    }
}
