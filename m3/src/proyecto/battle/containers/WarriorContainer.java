package proyecto.battle.containers;

import proyecto.battle.Warrior;

import java.util.*;

public class WarriorContainer {
    ArrayList<Warrior> warriorArrayList = new ArrayList<>();

    public ArrayList<Warrior> getWarriorArrayList() {
        return warriorArrayList;
    }

    public void setWarriorArrayList(ArrayList<Warrior> warriorArrayList) {
        this.warriorArrayList = warriorArrayList;
    }
}
