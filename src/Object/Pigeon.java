package Object;

import Shape.Circle;

import java.awt.*;
import java.util.ArrayList;

public class Pigeon {
	private final ArrayList<Circle> pigeons = new ArrayList<>();

	public void addPigeon(int x, int y) {
		this.pigeons.add(new Circle(x, y, Color.BLACK, 25, 1));
	}

	public ArrayList<Circle> getPigeons() {
		return this.pigeons;
	}
}
