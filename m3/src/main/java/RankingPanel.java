import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RankingPanel extends JFrame {
    JPanel panel = new JPanel();

    public RankingPanel() {
        super("main.project.battle");
        this.setPreferredSize(new Dimension(520, 520));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        String[] columnNames = {"Name", "Points", "Won", "Lost", "%Won"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        addToRanking(model);

        // Sort the table
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(model);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
        sortKeys.add(new RowSorter.SortKey(1, SortOrder.DESCENDING));
        sorter.setSortKeys(sortKeys);

        JButton button = new JButton("Salir");
        JTable table = new JTable(model);
        this.add(button);

        JScrollPane scrollPane = new JScrollPane(table);
        table.setRowSorter(sorter);
        this.add(scrollPane);

        // Button event to close the panel
        button.addActionListener(actionEvent -> {
            this.dispose();
            Main.mainPanel.setVisible(true);
        });
    }

    // Function that loads the players to the table
    public void addToRanking(DefaultTableModel model) {
        for (Player i : PlayerContainer.playerArrayList) {
            String winRatio;
            try {
                winRatio = String.valueOf((i.getWon() / (i.getWon() + i.getLost())) * 100);
            } catch (ArithmeticException e) {
                winRatio = "0";
            }
            Object[] row1 = {
                    i.getName(),
                    String.valueOf(i.getPoints()),
                    String.valueOf(i.getWon()),
                    String.valueOf(i.getLost()),
                    winRatio
            };
            model.addRow(row1);
        }
    }
}
