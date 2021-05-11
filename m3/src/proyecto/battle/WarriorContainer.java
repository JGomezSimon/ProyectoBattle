package proyecto.battle;

import proyecto.battle.Warrior;

import java.util.ArrayList;

public class WarriorContainer {

    public static ArrayList<Warrior> warriorArrayList = new ArrayList<>();

    public static ArrayList<Warrior> getWarriorArrayList() { return warriorArrayList; }

    public static void setWarriorArrayList(ArrayList<Warrior> warriorArrayList) {
        WarriorContainer.warriorArrayList = warriorArrayList;
    }
}
