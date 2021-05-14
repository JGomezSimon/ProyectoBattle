package proyecto.battle;


import proyecto.battle.containers.WeaponContainer;

import java.sql.*;

public class Events {
    //Objective of class is to introduce all elements from the database inside the programm
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
            WeaponContainer.weaponArrayList.add(new Weapon(rs.getString(2),rs.getString(3),rs.getInt(4), rs.getInt(5),rs.getInt(6)));
        }

        /*for (Weapon weapon : WeaponContainer.weaponArrayList) {
            System.out.println(weapon.getSpeed());
        }*/ //Loop to check if elements have been introduced into the class

        query = "select * from warriors";
        rs = stmnt.executeQuery(query);

        while (rs.next()){
            WarriorContainer.warriorArrayList.add(new Warrior(rs.getString(2),rs.getString(3),rs.getInt(1),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10)));
        }
        //Esto es para comprobar si github va bien o esta rallao de la cabeza

    }
}