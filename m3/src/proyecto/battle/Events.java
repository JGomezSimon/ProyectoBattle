package proyecto.battle;


import proyecto.battle.containers.WeaponContainer;

import java.sql.*;
import java.util.*;

public class Events {

    public static void importDB() throws SQLException, ClassNotFoundException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/battle?serverTimezone=UTC", "root", "root");
        Class.forName("com.mysql.cj.jdbc.Driver");

        Statement stmnt = connection.createStatement();

        String query = "select * from weapons";
        ResultSet rs = stmnt.executeQuery(query);

        while (rs.next()) {
            System.out.println(" Boost_Fuerza= "+rs.getInt(4)+" Boost_Velocidad= "+ rs.getInt(5));
        }

        WeaponContainer weaponContainer = new WeaponContainer();
        /*WarriorContainer warriorContainer = new WarriorContainer();*/
        query = "select weapon_strength_boost, weapon_speed_boost from weapons";
        rs = stmnt.executeQuery(query);

        while (rs.next()) {
            WeaponContainer.weaponArrayList.add(new Weapon(rs.getInt(1), rs.getInt(2)));
        }

        for (Weapon weapon : WeaponContainer.weaponArrayList) {
            System.out.println(weapon);
        }
    }
}