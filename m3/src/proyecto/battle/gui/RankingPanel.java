package proyecto.battle.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class RankingPanel extends JFrame {
    JPanel panel = new JPanel();
    String[] columnNames = {"Name", "Roll Number", "Department"};
    DefaultTableModel model = new DefaultTableModel(columnNames, 0);

    public RankingPanel() {
        super("main.project.battle");
        this.setPreferredSize(new Dimension(330, 400));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel);
        this.pack();
        this.setLocationRelativeTo(null);

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane();

        this.add(table);
        this.add(scrollPane);
    }

    public void addToRanking(Object[] row) {
        model.addRow(row);
    }
}
