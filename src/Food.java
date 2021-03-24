import Shape.Square;

import java.awt.*;
import java.util.ArrayList;

public class Food {
	private final ArrayList<Square> food = new ArrayList<>();

	public Food() {
		// TODO : Remove
		addFood();
	}

	private void addFood() {
		// TODO : Random
		food.add(new Square(100, 100, Color.CYAN, 50, 1));
	}

	public ArrayList<Square> getFood() {
		return food;
	}
}
