package Object;

import Shape.Circle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Pigeon extends JFrame {
	private final ArrayList<Circle> pigeons = new ArrayList<>();

	public Pigeon(int number) {
		instantiatePigeons(number);
	}

	private void instantiatePigeons(int number) {
		for (int i = 0; i < number; i++) {
			// TODO : Random ?
			pigeons.add(new Circle(100, 100, Color.BLACK, 25, 1));
		}
	}

	public ArrayList<Circle> getPigeons() {
		return pigeons;
	}
}
