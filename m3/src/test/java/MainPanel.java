import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainPanel extends JFrame{
    private JPanel mainPanel;
    private JButton jugarButton;
    private JButton escogerPersonajeButton;
    private JButton escogerArmaButton;
    private JButton salirButton;
    private JButton confirmarButton;
    private JButton confirmarButton1;
    private JButton resetButton;
    private JButton rankingButton;
    private final JDialog jDialog;

    public MainPanel() {
        super("main.project.battle");
        this.setPreferredSize(new Dimension(500,300));
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);

        JButton button = new JButton("Ok");
        jDialog = new JDialog(this, "", true);
        jDialog.add(new JLabel ("You can't confirm before choosing"));
        jDialog.setLocationRelativeTo(null);
        jDialog.setLayout(new FlowLayout());
        jDialog.setSize(250,100);
        jDialog.add(button);
        button.addActionListener (e -> jDialog.setVisible(false));

        escogerArmaButton.setEnabled(false);
        jugarButton.setEnabled(false);
        confirmarButton1.setEnabled(false);

        escogerArmaButton.addActionListener(actionEvent -> {
            this.setVisible(false);
            Test.weaponPanel.setVisible(true);
        });
        escogerPersonajeButton.addActionListener(actionEvent -> {
            this.setVisible(false);
            Test.warriorPanel.setVisible(true);
        });
        confirmarButton.addActionListener(actionEvent -> {
            if (LoginPanel.player.getWarrior() != null) {
                escogerArmaButton.setEnabled(true);
                escogerPersonajeButton.setEnabled(false);
                confirmarButton.setEnabled(false);
                confirmarButton1.setEnabled(true);
            } else {
                jDialog.setVisible(true);
            }
        });
        confirmarButton1.addActionListener(actionEvent -> {
            if (LoginPanel.player.getWarrior().getWeapon() != null) {
                escogerArmaButton.setEnabled(false);
                jugarButton.setEnabled(true);
                confirmarButton1.setEnabled(false);
            } else {
                jDialog.setVisible(true);
            }
        });
        salirButton.addActionListener(actionEvent -> System.exit(0));
        jugarButton.addActionListener(actionEvent -> {
            jugarButton.setEnabled(false);
            try {
                Test.battlePanel = new BattlePanel();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.setVisible(false);
            Test.battlePanel.setVisible(true);
            escogerPersonajeButton.setEnabled(true);
            confirmarButton.setEnabled(true);
        });
        resetButton.addActionListener(actionEvent -> {
            try {
                Test.weaponPanel.dispose();
            } catch (NullPointerException ignored) {
            }
            Test.warriorPanel.dispose();
            try {
                Test.warriorPanel = new WarriorPanel();
            } catch (IOException e) {
                e.printStackTrace();
            }
            jugarButton.setEnabled(false);
            escogerPersonajeButton.setEnabled(true);
            escogerArmaButton.setEnabled(false);
            confirmarButton.setEnabled(true);
            confirmarButton1.setEnabled(false);
        });
        rankingButton.addActionListener(actionEvent -> {
            this.setVisible(false);
            Test.rankingPanel = new RankingPanel();
            Test.rankingPanel.setVisible(true);
        });
    }
}