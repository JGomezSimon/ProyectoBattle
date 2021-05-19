import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.logging.Level;

public class Events {

    private static Connection connection;

    // Function to create json files
    public static void CreateJSON(String name) {
        try {
            File myObj = new File(name + ".json");
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
        // Import JSON that contains the players
        JSONParser playerParser = new JSONParser();
        try (FileReader reader = new FileReader("users.json")) {
            Object obj = playerParser.parse(reader);
            JSONArray playerList = (JSONArray) obj;
            playerList.forEach(emp -> parsePlayerObject((JSONObject) emp));
        } catch (IOException | ParseException ignored) {
        }
        // Import JSON that contains the warriors
        JSONParser warriorParser = new JSONParser();
        try (FileReader reader = new FileReader("warriors.json")) {
            Object obj = warriorParser.parse(reader);
            JSONArray warriorList = (JSONArray) obj;
            warriorList.forEach(emp -> parseWarriorObject((JSONObject) emp));
        } catch (IOException | ParseException ignored) {
        }
        // Import JSON that contains the weapons
        JSONParser weaponParser = new JSONParser();
        try (FileReader reader = new FileReader("weapons.json")) {
            Object obj = weaponParser.parse(reader);
            JSONArray weaponList = (JSONArray) obj;
            weaponList.forEach(emp -> parseWeaponObject((JSONObject) emp));
        } catch (IOException | ParseException ignored) {
        }
    }

    // Parse Player object
    private static void parsePlayerObject(JSONObject player) {
        try {
            for (int i = 1; i < Double.POSITIVE_INFINITY; i++) {
                JSONObject playerObject = (JSONObject) player.get("player" + i);
                String name = (String) playerObject.get("name");
                String password = (String) playerObject.get("password");
                double points = (double) playerObject.get("points");
                double won = (double) playerObject.get("won");
                double lost = (double) playerObject.get("lost");
                PlayerContainer.playerArrayList.add(new Player(name, password, new BigDecimal(points).floatValue(), new BigDecimal(won).floatValue(), new BigDecimal(lost).floatValue()));
            }
        } catch (NullPointerException ignored) {
        }
    }

    // Parse Warrior object
    private static void parseWarriorObject(JSONObject warrior) {
        for (int i = 0; i < 9; i++) {
            JSONObject warriorObject = (JSONObject) warrior.get("warrior" + i);
            String name = (String) warriorObject.get("name");
            String url = (String) warriorObject.get("url");
            long life = (long) warriorObject.get("life");
            long strength = (long) warriorObject.get("strength");
            long defense = (long) warriorObject.get("defense");
            long agility = (long) warriorObject.get("agility");
            long speed = (long) warriorObject.get("speed");
            long race_id = (long) warriorObject.get("race_id");
            long points = (long) warriorObject.get("points");
            WarriorContainer.warriorArrayList.add(new Warrior(
                    name,
                    url,
                    new BigDecimal(life).intValue(),
                    new BigDecimal(strength).intValue(),
                    new BigDecimal(defense).intValue(),
                    new BigDecimal(agility).intValue(),
                    new BigDecimal(speed).intValue(),
                    new BigDecimal(race_id).intValue(),
                    new BigDecimal(points).intValue()
            ));
        }
    }

    // Parse Weapon object
    private static void parseWeaponObject(JSONObject weapon) {
        for (int i = 0; i < 9; i++) {
            JSONObject weaponObject = (JSONObject) weapon.get("weapon" + i);
            String name = (String) weaponObject.get("name");
            String url = (String) weaponObject.get("url");
            long points = (long) weaponObject.get("points");
            long speed = (long) weaponObject.get("speed");
            long strength = (long) weaponObject.get("strength");
            WeaponContainer.weaponArrayList.add(new Weapon(
                    new BigDecimal(strength).intValue(),
                    new BigDecimal(speed).intValue(),
                    url,
                    name,
                    new BigDecimal(points).intValue()
            ));
        }
    }

    // Function to add players to DB
    public static void addPlayerDB(Player player) throws SQLException, ClassNotFoundException, NullPointerException {
        int next_id = 0;
        Statement stmnt = connection.createStatement();

        String update = "insert into players(player_id, player_name, passwd, points, wins, losses) values (? , ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(update);

        ResultSet rs = stmnt.executeQuery("select player_id from players order by player_id limit 1");
        if (rs.next()) {
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

    // Function to add players to JSON file
    public static void addPlayerNoDB(Player player) {
        JSONParser jsonParser = new JSONParser();
        try {
            Object obj = jsonParser.parse(new FileReader("users.json"));
            JSONArray jsonArray = (JSONArray) obj;
            JSONObject playerDetails = new JSONObject();
            playerDetails.put("name", player.getName());
            playerDetails.put("password", player.getPassword());
            playerDetails.put("points", player.getPoints());
            playerDetails.put("won", player.getWon());
            playerDetails.put("lost", player.getLost());
            JSONObject playerObject = new JSONObject();
            playerObject.put("player" + PlayerContainer.playerArrayList.size(), playerDetails);
            jsonArray.add(playerObject);
            FileWriter file = new FileWriter("users.json");
            file.write(jsonArray.toJSONString());
            file.flush();
            file.close();
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }
}