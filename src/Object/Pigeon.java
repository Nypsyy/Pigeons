package Object;

import Shape.Circle;

import Window.Drawing;

import java.awt.*;
import java.util.Random;

public class Pigeon implements Runnable {
	private static final Color sleep = Color.BLACK;
	private static final Color run = Color.BLUE;
	private static final int radius = 25;
	private static final int thickness = 1;

	private final Circle circle;
	private final Drawing drawing;

	public Pigeon(int x, int y, Drawing drawing) {
		this.circle = new Circle(x, y, sleep, radius, thickness);
		this.drawing = drawing;

		// TODO : Remove
		Thread thread = new Thread(this);
		thread.start();
	}

	public Circle getCircle() {
		return this.circle;
	}

	@Override
	public void run() {
		// TODO : Edit
		this.circle.setColor(run);
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(2000);
				this.circle.getPosition().update(5, 0);
				this.drawing.repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.circle.setColor(sleep);
		this.drawing.repaint();
	}
}
