package Object;

import Shape.Point;

import java.awt.*;
import java.util.Random;

public abstract class MovingEntity extends Entity {
	protected int speed;

	public MovingEntity(Color defaultColor, Color eventColor, int size, int thickness, int speed) {
		super(defaultColor, eventColor, size, thickness);
		this.speed = new Random().nextInt(speed - 2) + 2;
	}

	public abstract void goTo(Point dest);
}
