package Window;

import Object.Pigeon;
import Object.Food;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Random;

public class Drawing extends JPanel {
	private final ArrayList<Pigeon> pigeons = new ArrayList<>();
	private final ArrayList<Food> food = new ArrayList<>();

	public Drawing() {
		initClickListener();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		synchronized (this.pigeons) {
			for (Pigeon pigeon : this.pigeons) {
				pigeon.getCircle().draw(g);
			}
		}

		// TODO : Synchronized ?
		for (Food food : this.food) {
			food.getSquare().draw(g);
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
		this.food.add(new Food(x, y));
		repaint();
	}

	public void spawnPigeons(int number) {
		synchronized (this.pigeons) {
			Random random = new Random();
			for (int i = 0; i < number; i++) {
				this.pigeons.add(new Pigeon(random.nextInt(getSize().width), random.nextInt(getSize().height), this));
			}
		}
	}
}
