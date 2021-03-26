package Window;

import Object.Pigeon;
import Object.Food;

import java.util.ArrayList;

public class World {
    private static ArrayList<Pigeon> pigeons;
    private static ArrayList<Food> food = null;

    public synchronized static void removeFood(Food f) {
        if (f != null) {
            if (f.getThread().isAlive())
                f.getThread().interrupt();
            food.remove(f);
        }
    }

    public synchronized static void resetPigeonThreateningTimers() {
        for (Pigeon p : pigeons) {
            p.resetThreatening();
        }
    }

    public World() {
        pigeons = new ArrayList<>();
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
        if (freshFood.getThread().isAlive())
            freshFood.getThread().interrupt();

        resetPigeonThreateningTimers();

        removeFood(freshFood);
    }

    public void addFood(int x, int y) {
        food.add(new Food(x, y));
    }

    public void addPigeon(int x, int y) {
        pigeons.add(new Pigeon(x, y));
    }

    public synchronized void resetWorld() {
        for (Pigeon p : pigeons)
            p.getThread().interrupt();
        pigeons.clear();

        for (Food f : food)
            f.getThread().interrupt();
        food.clear();
    }
}
