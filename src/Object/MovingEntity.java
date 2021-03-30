package Object;

import Shape.Point;

import java.awt.*;
import java.util.Random;

public abstract class MovingEntity extends Entity {
	protected int speed;

	/**
	 * Configure une entité avec un attribut de vitesse
	 * @param defaultColor
	 * @param eventColor
	 * @param size
	 * @param thickness
	 * @param speed
	 */
	public MovingEntity(Color defaultColor, Color eventColor, int size, int thickness, int speed) {
		super(defaultColor, eventColor, size, thickness);
		this.speed = new Random().nextInt(speed - 2) + 2;
	}

	/**
	 * Définir une destination
	 * @param dest
	 */
	public abstract void goTo(Point dest);
}
