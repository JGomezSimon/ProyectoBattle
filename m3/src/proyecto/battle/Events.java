package proyecto.battle;

import proyecto.battle.containers.PlayerContainer;
import proyecto.battle.containers.WarriorContainer;
import proyecto.battle.containers.WeaponContainer;

import java.sql.*;

public class Events {

    private static Connection connection;

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
        WarriorContainer.warriorArrayList.add(new Warrior("Nedraec Forgeshaper", "assets/warriors/nedraec.jpeg", 60, 6, 4, 5, 3, 1, 21));
        WarriorContainer.warriorArrayList.add(new Warrior("Safomli Platebreaker", "assets/warriors/samfoli.jpg", 60, 6, 4, 5, 3, 1, 21));
        WarriorContainer.warriorArrayList.add(new Warrior("Khekroc Heavyshoulder", "assets/warriors/khekroc.png", 60, 6, 4, 5, 3, 1, 21));
        WarriorContainer.warriorArrayList.add(new Warrior("Edwaradrin Ohmswis", "assets/warriors/edwaradrin.jpg", 50, 5, 3, 6, 5, 3, 20));
        WarriorContainer.warriorArrayList.add(new Warrior("Legomoreno", "assets/warriors/legomoreno.jpg", 50, 5, 3, 6, 5, 3, 20));
        WarriorContainer.warriorArrayList.add(new Warrior("Roferolas Elfbrooks", "assets/warriors/roferolas.jpg", 50, 5, 3, 6, 5, 3, 20));
        WarriorContainer.warriorArrayList.add(new Warrior("Maol-Chaluim Maoileanach", "assets/warriors/maol-chaluim.jpg", 40, 4, 2, 7, 7, 2, 19));
        WarriorContainer.warriorArrayList.add(new Warrior("Gillìosa Fòlais", "assets/warriors/gilliosa.jpg", 40, 4, 2, 7, 7, 2, 19));
        WarriorContainer.warriorArrayList.add(new Warrior("Seumas Forsàidh", "assets/warriors/seumas.jpg", 40, 4, 2, 7, 7, 2, 19));
        // ADD to container all weapons
        WeaponContainer.weaponArrayList.add(new Weapon(3, 0, "assets/weapons/dagger.jpg", "Dagger", 10)); // Dagger
        WeaponContainer.weaponArrayList.add(new Weapon(1, 1, "assets/weapons/sword.jpg", "Sword", 10)); // Sword
        WeaponContainer.weaponArrayList.add(new Weapon(3, 0, "assets/weapons/axe.png", "Axe", 10)); // Axe
        WeaponContainer.weaponArrayList.add(new Weapon(2, 2, "assets/weapons/twinSwords.jpg", "TwinSwords", 14)); // TwinSwords
        WeaponContainer.weaponArrayList.add(new Weapon(1, 2, "assets/weapons/scimitar.jpg", "Scimitar", 14)); // Scimitar
        WeaponContainer.weaponArrayList.add(new Weapon(1, 5, "assets/weapons/bow.jpg", "Bow", 15)); // Bow
        WeaponContainer.weaponArrayList.add(new Weapon(2, 3, "assets/weapons/katana.jpg", "Katana", 18)); // Katana
        WeaponContainer.weaponArrayList.add(new Weapon(0, 4, "assets/weapons/knife.jpg", "Knife", 12)); // Knife
        WeaponContainer.weaponArrayList.add(new Weapon(5, 0, "assets/weapons/twoHandedAxe.jpg", "TwoHandedAxe", 20)); // TwoHandedAxe
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

    public static void addPlayerNoDB(Player player) {
    }
}