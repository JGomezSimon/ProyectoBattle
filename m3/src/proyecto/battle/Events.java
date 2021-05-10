package proyecto.battle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Events {

    public void importDB() throws SQLException, ClassNotFoundException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/battle", "", "");
        Class.forName("com.mysql.jdbc.Driver");
        connection.createSQLXML();
    }
}
