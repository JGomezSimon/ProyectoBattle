package proyecto.battle.containers;

import proyecto.battle.Race;

import java.util.ArrayList;

public class RaceContainer {
    public static ArrayList<Race> raceArrayList = new ArrayList<>();

    public static ArrayList<Race> getRaceArrayList() { return raceArrayList; }

    public static void setRaceArrayList(ArrayList<Race> raceArrayList) { RaceContainer.raceArrayList = raceArrayList; }
}
