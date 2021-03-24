package Object;

import Shape.Square;

import java.awt.*;
import java.util.ArrayList;

public class Food {
	private final ArrayList<Square> food = new ArrayList<>();

	public void addFood(int x, int y) {
		// TODO : Random
		food.add(new Square(x, y, Color.CYAN, 50, 1));
	}

	public ArrayList<Square> getFood() {
		return food;
	}
}
