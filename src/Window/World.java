package Window;

import Object.Food;
import Object.Pigeon;
import Object.PigeonEat;
import Object.PigeonRun;
import Object.PigeonThreatened;

import java.util.ArrayList;

public class World {
    private static ArrayList<Pigeon> pigeons;
    private static ArrayList<PigeonRun> pigeonRuns;
    private static ArrayList<PigeonEat> pigeonEats;
    private static ArrayList<PigeonThreatened> pigeonTheateneds;

    private static ArrayList<Food> food = null;

    public synchronized static void removeFood(Food f) {
        if (f != null) {
            food.remove(f);
        }
    }

    public World() {
        pigeons = new ArrayList<>();
        pigeonRuns = new ArrayList<>();
        pigeonEats = new ArrayList<>();
        pigeonTheateneds = new ArrayList<>();
        food = new ArrayList<>();
    }

    public ArrayList<Pigeon> getPigeons() {
        return pigeons;
    }

    public ArrayList<Food> getFood() {
        return food;
    }

    public synchronized static Food getFreshFood() {
        return food.size() > 0 && food.get(food.size() - 1).isFresh() ? food.get(food.size() - 1) : null;
    }

    public synchronized static void eatFood(Food freshFood) {
        for (PigeonThreatened pt : pigeonTheateneds) {
            pt.setThreatenedTimer();
        }

        freshFood.lifeTimer.cancel();
        removeFood(freshFood);
    }

    public void addFood(int x, int y) {
        food.add(new Food(x, y));
    }

    public void addPigeon(int x, int y) {
        Pigeon p = new Pigeon(x, y);

        pigeons.add(p);
        pigeonRuns.add(new PigeonRun(p));
        pigeonEats.add(new PigeonEat(p));
        pigeonTheateneds.add(new PigeonThreatened(p));
    }

    public synchronized void resetWorld() {
        for (int i = 0; i < pigeons.size(); i++) {
            pigeonRuns.get(i).interrupt();
            pigeonEats.get(i).interrupt();
            pigeonTheateneds.get(i).interrupt();
        }

        pigeons.clear();
        pigeonRuns.clear();
        pigeonEats.clear();
        pigeonTheateneds.clear();

        food.clear();
    }
}
