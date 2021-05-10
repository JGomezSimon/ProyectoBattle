package proyecto.battle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Events {

    public static void importDB() throws SQLException, ClassNotFoundException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/battle?serverTimezone=UTC", "root", "root");
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection.createSQLXML();
    }
}
