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
		//this.speed = new Random().nextInt(maxSpeed);

		// TODO : Remove ?
		this.thread = new Thread(this);
		this.thread.start();
	}

	public Circle getCircle() {
		return this.circle;
	}

	@Override
	public void run() {
		while (true) {
			waitForEvent();
		}
	}

	private void waitForEvent() {
		//synchronized (this.drawing.getFood()) {
			try {
				System.out.println("Wait " + this.thread.getName());
				this.drawing.getFood().wait();
				System.out.println("Wait2 " + this.thread.getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Food " + this.thread.getName());
			if (this.drawing.getFood().isEmpty()) {
				System.out.println("Jump Scare");
			} else {
				runFood();
			}
		//}
	}

	private void runFood() {
		this.circle.setColor(run);
		updateDestination();
		while (!this.drawing.getFood().isEmpty() && this.destination != null) {
			this.circle.getPosition().update(this.destination.getX(), this.destination.getY());
			this.drawing.repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			updateDestination();
		}
		this.circle.setColor(sleep);
		this.drawing.repaint();
	}

	private void updateDestination() {
		Food food = this.drawing.getFreshFood();

		if (food == null) {
			this.destination = null;
			return;
		}

		Point foodPoint = food.getSquare().getPosition();
		Point pigeonPoint = this.circle.getPosition();

		float x = foodPoint.getX() - pigeonPoint.getX();
		float y = foodPoint.getY() - pigeonPoint.getY();
		float length = (float) Math.sqrt(x*x + y*y);

		x /= length;
		y /= length;
		x *= this.speed;
		y *= this.speed;

		this.destination = new Point((int) x, (int) y);
	}
}
