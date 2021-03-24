package Window;

import Shape.Circle;
import Shape.Square;
import Object.Pigeon;
import Object.Food;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Drawing extends JPanel {
	private final Pigeon pigeon;
	private final Food food;

	public Drawing() {
		this.pigeon = new Pigeon();
		this.food = new Food();

		initClickListener();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (Circle circle : this.pigeon.getPigeons()) {
			circle.draw(g);
		}

		for (Square square : this.food.getFood()) {
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
		this.food.addFood(x, y);
		repaint();
	}

	public void spawnPigeons(int number) {
		Random random = new Random();
		for (int i = 0; i < number; i++) {
			this.pigeon.addPigeon(random.nextInt(getSize().width), random.nextInt(getSize().height));
		}
	}
}
