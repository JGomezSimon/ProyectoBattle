import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;

public class LoginPanel extends MainPanel {
    private JPasswordField passwordField1;
    private JTextArea NameArea;
    private JButton registerButton;
    private JButton loginButton;
    private JLabel labelName;
    private JLabel labelPassword;
    private JPanel panel;
    private JLabel message;

    public LoginPanel() {
        this.setPreferredSize(new Dimension(300, 130));
        this.setContentPane(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);

        // button  event that verifies the name and password is correct and login the player
        loginButton.addActionListener(actionEvent -> {
            int id = 0;
            boolean flag = false;
            for (int i = 0; i < PlayerContainer.playerArrayList.size(); i++) {
                if (PlayerContainer.playerArrayList.get(i).getName().equals(NameArea.getText())) {
                    id = i;
                    flag = true;
                }
            }
            if (flag) {
                if (PlayerContainer.playerArrayList.get(id).getPassword().equals(new String(passwordField1.getPassword()))) {
                    this.dispose();
                    Main.player = PlayerContainer.playerArrayList.get(id);
                    // Initialize MainPanel and WarriorPanel
                    Main.mainPanel = new MainPanel();
                    Main.mainPanel.setVisible(true);
                    try {
                        Main.warriorPanel = new WarriorPanel();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    message.setForeground(Color.RED);
                    message.setText("*Incorrect password");
                }
            } else {
                message.setForeground(Color.RED);
                message.setText("*Incorrect name");
            }
        });
        // button event to register the player to de DB or JSON
        registerButton.addActionListener(actionEvent -> {
            boolean flag = true;
            for (Player i : PlayerContainer.playerArrayList) {
                if (i.getName().equals(NameArea.getText())) {
                    flag = false;
                }
            }
            String string_pass = new String(passwordField1.getPassword());
            if (NameArea.getText().equals("") | string_pass.equals("")) {
                message.setForeground(Color.RED);
                message.setText("*Password or name cant be empty");
            } else {
                if (flag) {
                    message.setForeground(new Color(29, 174, 26));
                    message.setText("*Register Successfully");
                    Main.logger.log(Level.INFO, "User " + NameArea.getText() + " with password " + string_pass + " created successfully");
                    Player new_player = new Player(NameArea.getText(), string_pass, 0, 0, 0);
                    if (PlayerContainer.playerArrayList.size() == 0)
                        new_player.setpId(0);
                    else
                        new_player.setpId(PlayerContainer.playerArrayList.size() + 1);
                    PlayerContainer.playerArrayList.add(new_player);
                    try {
                        Events.addPlayerDB(new_player);
                    } catch (SQLException | ClassNotFoundException | NullPointerException throwables) {
                        Events.addPlayerNoDB(new_player);
                    }
                } else {
                    message.setForeground(Color.RED);
                    message.setText("*This name already exist");
                }
            }
        });
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        labelName = new JLabel();
        labelName.setText("Name");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(labelName, gbc);
        labelPassword = new JLabel();
        labelPassword.setText("Password");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(labelPassword, gbc);
        passwordField1 = new JPasswordField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(passwordField1, gbc);
        NameArea = new JTextArea();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(NameArea, gbc);
        registerButton = new JButton();
        registerButton.setText("Register");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(registerButton, gbc);
        loginButton = new JButton();
        loginButton.setText("Login");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(loginButton, gbc);
        message = new JLabel();
        message.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(message, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel;
    }
}
