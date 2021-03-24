package Object;

import Shape.Square;

import java.awt.*;
import java.util.ArrayList;

public class Food {
	private final ArrayList<Square> food = new ArrayList<>();

	public void addFood(int x, int y) {
		// TODO : Random
		this.food.add(new Square(x, y, Color.RED, 10, 1));
	}

	public ArrayList<Square> getFood() {
		return this.food;
	}
}
