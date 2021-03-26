package Object;

import Shape.Circle;
import Shape.Point;

import Window.World;
import Window.Configuration;

public class Pigeon extends MovingEntity {
	public Pigeon(int x, int y) {
		super(Configuration.pigeonDefaultColor, Configuration.pigeonEventColor, Configuration.pigeonSize, Configuration.pigeonThickness, Configuration.pigeonMaxSpeed);
		figure = new Circle(x, y, defaultColor, size, thickness);
	}

	@Override
	public void run() {
		while (thread.isAlive()) {
			if (World.getFreshFood() != null) {
				runFood();
			}
		}
	}

	private void runFood() {
		figure.setColor(eventColor);
		updateDestination();
		while (destination != null) {
			figure.getPosition().update(destination.getX(), destination.getY());
			try {
				Thread.sleep(Configuration.screenRefreshRate);
			} catch (InterruptedException e) {
				thread.interrupt();
			}
			tryEatFood();
			updateDestination();
		}
		figure.setColor(defaultColor);
	}

	private void updateDestination() {
		Food freshFood = World.getFreshFood();

		if (freshFood == null) {
			destination = null;
			return;
		}

		Point foodPoint = freshFood.getFigure().getPosition();
		Point pigeonPoint = figure.getPosition();

            if (crumb == null) {
                this.destination = null;
                return;
            }

		x = x / length * speed;
		y = y / length * speed;

		destination = new Point((int) x, (int) y);
	}

	private void tryEatFood() {
		Food freshFood = World.getFreshFood();

		if (freshFood == null) {
			destination = null;
			return;
		}

		Point foodPosition = freshFood.getFigure().getPosition();
		Point pigeonPosition = figure.getPosition();
		double distance = Math.sqrt(Math.pow(foodPosition.getX() - pigeonPosition.getX(), 2) + Math.pow(foodPosition.getY() - pigeonPosition.getY(), 2));

		if (distance <= freshFood.size / 2f + size / 2f) {
			destination = null;
			World.eatFood(freshFood);
		}
	}
}
