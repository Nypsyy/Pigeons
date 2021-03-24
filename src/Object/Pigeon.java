package Object;

import Shape.Circle;

import java.awt.*;

public class Pigeon {
	private static final Color sleep = Color.BLACK;
	private static final Color run = Color.BLUE;
	private static final int radius = 25;
	private static final int thickness = 1;

	private final Circle circle;

	public Pigeon(int x, int y) {
		this.circle = new Circle(x, y, sleep, radius, thickness);
	}

	public Circle getCircle() {
		return this.circle;
	}
}
