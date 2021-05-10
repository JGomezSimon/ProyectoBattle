package proyecto.battle.containers;

import proyecto.battle.Warrior;

import java.util.ArrayList;

public class WarriorContainer {
    public ArrayList<Warrior> warriorArrayList = new ArrayList<>();

    public ArrayList<Warrior> getWarriorArrayList() {
        return warriorArrayList;
    }

    public void setWarriorArrayList(ArrayList<Warrior> warriorArrayList) {
        this.warriorArrayList = warriorArrayList;
    }
}
