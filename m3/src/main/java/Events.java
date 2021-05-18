import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;

public class Events {

    private static Connection connection;

    public static void CreateJSON() {
        try {
            File myObj = new File("users.json");
            if (myObj.createNewFile()) {
                Main.logger.log(Level.INFO, "File created: " + myObj.getName());
            } else {
                Main.logger.log(Level.INFO, "File already exists.");
            }
        } catch (IOException e) {
            Main.logger.log(Level.INFO, "An error occurred.");
            e.printStackTrace();
        }
    }

    public static void importDB() throws SQLException, ClassNotFoundException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost/battle?serverTimezone=UTC", "root", "root");
        Class.forName("com.mysql.cj.jdbc.Driver");

        Statement stmnt = connection.createStatement();

        String query = "select * from weapons";
        ResultSet rs = stmnt.executeQuery(query);

        while (rs.next()) {
            WeaponContainer.weaponArrayList.add(new Weapon(rs.getInt(5), rs.getInt(4), rs.getString(3), rs.getString(2), rs.getInt(6)));
        }

        // Loop to check if elements have been introduced into the class
        query = "select * from warriors";
        rs = stmnt.executeQuery(query);

        while (rs.next()) {
            WarriorContainer.warriorArrayList.add(new Warrior(rs.getString(2), rs.getString(3), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(4), rs.getInt(10)));
        }

        query = "select * from players";
        rs = stmnt.executeQuery(query);

        while (rs.next()) {
            PlayerContainer.playerArrayList.add(new Player(rs.getString(2), rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6)));
        }
    }

    public static void importNoDB() {
        // TODO: 5/17/21
        // Import from file the players

        // ADD to container all warriors
        WarriorContainer.warriorArrayList.add(new Warrior("Nedraec Forgeshaper", Main.resource_root + "/warriors/nedraec.jpeg", 60, 6, 4, 5, 3, 1, 21));
        WarriorContainer.warriorArrayList.add(new Warrior("Safomli Platebreaker", Main.resource_root + "/warriors/samfoli.jpg", 60, 6, 4, 5, 3, 1, 21));
        WarriorContainer.warriorArrayList.add(new Warrior("Khekroc Heavyshoulder", Main.resource_root + "/warriors/khekroc.png", 60, 6, 4, 5, 3, 1, 21));
        WarriorContainer.warriorArrayList.add(new Warrior("Edwaradrin Ohmswis", Main.resource_root + "/warriors/edwaradrin.jpg", 50, 5, 3, 6, 5, 3, 20));
        WarriorContainer.warriorArrayList.add(new Warrior("Legomoreno", Main.resource_root + "/warriors/legomoreno.jpg", 50, 5, 3, 6, 5, 3, 20));
        WarriorContainer.warriorArrayList.add(new Warrior("Roferolas Elfbrooks", Main.resource_root + "/warriors/roferolas.jpg", 50, 5, 3, 6, 5, 3, 20));
        WarriorContainer.warriorArrayList.add(new Warrior("Maol-Chaluim Maoileanach", Main.resource_root + "/warriors/maol-chaluim.jpg", 40, 4, 2, 7, 7, 2, 19));
        WarriorContainer.warriorArrayList.add(new Warrior("Gillìosa Fòlais", Main.resource_root + "/warriors/gilliosa.jpg", 40, 4, 2, 7, 7, 2, 19));
        WarriorContainer.warriorArrayList.add(new Warrior("Seumas Forsàidh", Main.resource_root + "/warriors/seumas.jpg", 40, 4, 2, 7, 7, 2, 19));
        // ADD to container all weapons
        WeaponContainer.weaponArrayList.add(new Weapon(3, 0, Main.resource_root + "/weapons/dagger.jpg", "Dagger", 10)); // Dagger
        WeaponContainer.weaponArrayList.add(new Weapon(1, 1, Main.resource_root + "/weapons/sword.jpg", "Sword", 10)); // Sword
        WeaponContainer.weaponArrayList.add(new Weapon(3, 0, Main.resource_root + "/weapons/axe.png", "Axe", 10)); // Axe
        WeaponContainer.weaponArrayList.add(new Weapon(2, 2, Main.resource_root + "/weapons/twinSwords.jpg", "TwinSwords", 14)); // TwinSwords
        WeaponContainer.weaponArrayList.add(new Weapon(1, 2, Main.resource_root + "/weapons/scimitar.jpg", "Scimitar", 14)); // Scimitar
        WeaponContainer.weaponArrayList.add(new Weapon(1, 5, Main.resource_root + "/weapons/bow.jpg", "Bow", 15)); // Bow
        WeaponContainer.weaponArrayList.add(new Weapon(2, 3, Main.resource_root + "/weapons/katana.jpg", "Katana", 18)); // Katana
        WeaponContainer.weaponArrayList.add(new Weapon(0, 4, Main.resource_root + "/weapons/knife.jpg", "Knife", 12)); // Knife
        WeaponContainer.weaponArrayList.add(new Weapon(5, 0, Main.resource_root + "/weapons/twoHandedAxe.jpg", "TwoHandedAxe", 20)); // TwoHandedAxe
    }

    public static void addPlayerDB(Player player) throws SQLException, ClassNotFoundException, NullPointerException {
        int next_id = 0;
        Statement stmnt = connection.createStatement();

        String update = "insert into players(player_id, player_name, passwd, points, wins, losses) values (? , ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(update);

        ResultSet rs = stmnt.executeQuery("select player_id from players order by player_id limit 1");
        if (rs.next()){
            next_id = rs.getInt(1);
        }
        next_id = next_id + 1;

        ps.setInt(1, next_id);
        ps.setString(2, player.getName());
        ps.setString(3, player.getPassword());
        ps.setInt(4, 0);
        ps.setInt(5, 0);
        ps.setInt(6, 0);
        ps.executeUpdate();
    }

    public static void setLostDB(int lost) {
        // TODO: 5/18/21
    }

    public static void setWonDB(int won) {
        // TODO: 5/18/21
    }

    public static void setPointsDB(int points) {
        // TODO: 5/18/21
    }

    public static void addPlayerNoDB(Player player) {

    }

}