package Window;

import Object.Pigeon;
import Object.Food;

import java.util.ArrayList;

public class World {
	private final ArrayList<Pigeon> pigeons;
	private static ArrayList<Food> food = null;

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

	public static Food getFreshFood() {
		return food.size() > 0 && food.get(food.size() - 1).isFresh() ? food.get(food.size() - 1) : null;
	}

	public static void eatFood(Food freshFood) {
		freshFood.getThread().interrupt();
		food.remove(freshFood);
	}

	public void addFood(int x, int y) {
		food.add(new Food(x, y));
	}

	public void addPigeon(int x, int y) {
		pigeons.add(new Pigeon(x, y));
	}

	public void resetWorld() {
		for (int i = 0; i < pigeons.size(); i++) {
			pigeons.get(i).getThread().interrupt();
		}
		pigeons.clear();

		for (int i = 0; i < food.size(); i++) {
			food.get(i).getThread().interrupt();
		}
		food.clear();
	}
}
