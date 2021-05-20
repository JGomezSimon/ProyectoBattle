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
}
