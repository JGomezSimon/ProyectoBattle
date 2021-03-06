import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static Logger logger = Logger.getLogger(Main.class.getName());
    public static Player player;
    public static JFrame loginPanel;
    public static JFrame mainPanel;
    public static JFrame weaponPanel;
    public static JFrame warriorPanel;
    public static JFrame battlePanel;
    public static JFrame rankingPanel;

    public static void main(String[] args) throws IOException {
        Events.CreateJSON("users");
        // Try import DB if fail, do it manually
        try {
            Events.importDB();
        } catch (SQLException | ClassNotFoundException throwables) {
            logger.log(Level.INFO, "Error importing with DB, importing with no DB...");
            Events.importNoDB();
        }
        // Initialize Login Panel
        loginPanel = new LoginPanel();
        loginPanel.setVisible(true);
    }
}