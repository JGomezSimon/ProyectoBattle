import javax.swing.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Test {
    public static JFrame loginPanel;
    public static JFrame mainPanel;
    public static JFrame weaponPanel;
    public static JFrame warriorPanel;
    public static JFrame battlePanel;
    public static JFrame rankingPanel;
    public static Logger logger = Logger.getLogger(Test.class.getName());
    public static String resource_root = "src/main/resources";

    public static void main(String[] args) {
        Events.CreateJSON();
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