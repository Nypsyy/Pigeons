package Window;

import Object.Food;
import Object.Pigeon;
import Action.PigeonEat;
import Action.PigeonRun;
import Action.PigeonThreatened;

import java.util.ArrayList;

public class Game {
    private static ArrayList<Pigeon> pigeons;
    private static ArrayList<PigeonRun> pigeonRuns;
    private static ArrayList<PigeonEat> pigeonEats;
    private static ArrayList<PigeonThreatened> pigeonThreatened;

    private static ArrayList<Food> food = null;

    public Game() {
        pigeons = new ArrayList<>();
        pigeonRuns = new ArrayList<>();
        pigeonEats = new ArrayList<>();
        pigeonThreatened = new ArrayList<>();
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

    public void addFood(int x, int y) {
        food.add(new Food(x, y));
    }

    public void addPigeon(int x, int y) {
        Pigeon p = new Pigeon(x, y);

        pigeons.add(p);
        pigeonRuns.add(new PigeonRun(p));
        pigeonEats.add(new PigeonEat(p));
        pigeonThreatened.add(new PigeonThreatened(p));
    }

    public synchronized static void eatFood(Food freshFood) {
        for (PigeonThreatened pt : pigeonThreatened)
            pt.setThreatenedTimer();

        freshFood.lifeTimer.cancel();
        removeFood(freshFood);
    }

    public synchronized static void removeFood(Food f) {
        if (f != null)
            food.remove(f);
    }

    public synchronized void resetWorld() {
        for (int i = 0; i < pigeons.size(); i++) {
            pigeonRuns.get(i).interruptAction();
            pigeonEats.get(i).interruptAction();
            pigeonThreatened.get(i).interruptAction();
        }

        pigeons.clear();
        pigeonRuns.clear();
        pigeonEats.clear();
        pigeonThreatened.clear();

        food.clear();
    }
}
