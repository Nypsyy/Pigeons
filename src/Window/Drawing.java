package Window;

import Shape.Circle;
import Shape.Square;
import Object.Pigeon;
import Object.Food;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Drawing extends JPanel {
	private final Pigeon pigeon;
	private final Food food;

	public Drawing() {
		pigeon = new Pigeon(1);
		food = new Food();

		initClickListener();
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

	private void initClickListener() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				spawnFood(e.getX(), e.getY());
			}
		});
	}

	private void spawnFood(int x, int y) {
		food.addFood(x, y);
		repaint();
	}
}
