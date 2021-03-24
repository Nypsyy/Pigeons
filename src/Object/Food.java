package Object;

import Shape.Square;

import java.awt.*;

public class Food {
	private static final Color color = Color.RED;
	private static final int length = 10;
	private static final int thickness = 1;

	private final Square square;

	public Food(int x, int y) {
		this.square = new Square(x, y, color, length, thickness);
	}

	public Square getSquare() {
		return this.square;
	}
}
