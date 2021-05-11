package proyecto.battle;


import proyecto.battle.containers.RaceContainer;
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

        query = "select * from weapons";
        rs = stmnt.executeQuery(query);

        while (rs.next()) {
            WeaponContainer.weaponArrayList.add(new Weapon(rs.getString(3),rs.getInt(4), rs.getInt(5)));
        }

        for (Weapon weapon : WeaponContainer.weaponArrayList) {
            System.out.println(weapon.getSpeed());
        }

        query = "select * from races";
        rs = stmnt.executeQuery(query);

        while (rs.next()) {
            RaceContainer.raceArrayList.add(new Race(rs.getString(1),rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7)));
        }
        query = "select * from warriors";
        rs = stmnt.executeQuery(query);

        while (rs.next()){
            WarriorContainer.warriorArrayList.add(new Warrior(rs.getString(2),rs.getString(3),rs.getInt(1)));
        }
    }
}