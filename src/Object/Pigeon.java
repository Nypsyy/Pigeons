package Object;

import Shape.Circle;
import Shape.Point;

import Window.Drawing;

import java.awt.*;
import java.util.Random;

public class Pigeon implements Runnable {
	private static final Color sleep = Color.BLACK;
	private static final Color run = Color.BLUE;
	private static final int radius = 25;
	private static final int thickness = 1;
	private static final int maxSpeed = 5;

	private final Circle circle;
	private Point destination;
	private final Drawing drawing;
	private final Thread thread;
	// TODO : Temp
	private int speed = 5;

	public Pigeon(int x, int y, Drawing drawing) {
		this.circle = new Circle(x, y, sleep, radius, thickness);
		this.drawing = drawing;

		// TODO : Remove
		this.thread = new Thread(this);
		//thread.start();
	}

	public Circle getCircle() {
		return this.circle;
	}

	// TODO : Update notify system
	public void foodNotify() {
		this.destination = computeNextPosition();
		thread.start();
	}

	@Override
	public void run() {
		// TODO : Edit
		this.circle.setColor(run);
		while (this.destination != null) {
			try {
				Thread.sleep(50);
				this.circle.getPosition().update(this.destination.getX(), this.destination.getY());
				this.drawing.repaint();
				this.destination = computeNextPosition();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.circle.setColor(sleep);
		this.drawing.repaint();
	}

	private Point computeNextPosition() {
		Food food = this.drawing.getFreshFood();
		if (food != null) {
			Point foodPoint = food.getSquare().getPosition();
			Point pigeonPoint = this.circle.getPosition();

			float x = foodPoint.getX() - pigeonPoint.getX();
			float y = foodPoint.getY() - pigeonPoint.getY();
			float length = (float) Math.sqrt(x*x + y*y);

			x /= length;
			y /= length;
			x *= this.speed;
			y *= this.speed;

			return new Point((int) x, (int) y);
		}
		return null;
	}
}
