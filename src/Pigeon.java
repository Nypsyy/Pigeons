import Shape.Circle;
import Shape.Point;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Pigeon extends JFrame {
	private final ArrayList<Circle> pigeons = new ArrayList<>();
	private final int number;

	public Pigeon(int number) {
		this.number = Math.abs(number);
		instantiatePigeons();
	}

	private void instantiatePigeons() {
		for (int i = 0; i < this.number; i++) {
			// TODO : Random ?
			pigeons.add(new Circle(new Point(100, 100), Color.BLACK, 25, 1));
		}
	}

	public ArrayList<Circle> getPigeons() {
		return pigeons;
	}
}
