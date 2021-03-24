import Shape.Circle;
import Shape.Square;

import javax.swing.*;
import java.awt.*;

public class Drawing extends JPanel {
	private final Pigeon pigeon;
	private final Food food;

	public Drawing() {
		pigeon = new Pigeon(1);
		food = new Food();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (Circle circle : pigeon.getPigeons()) {
			circle.draw(g);
		}

		for (Square square : food.getFood()) {
			square.draw(g);
		}
	}
}
