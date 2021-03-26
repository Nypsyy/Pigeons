package Object;

import Shape.Figure;

import java.awt.*;

public abstract class Entity implements Runnable {
	protected Figure figure;
	protected Color defaultColor;
	protected Color eventColor;
	protected Thread thread;

	protected int size;
	protected int thickness;

	public Entity(Color defaultColor, Color eventColor, int size, int thickness) {
		this.defaultColor = defaultColor;
		this.eventColor = eventColor;
		this.size = size;
		this.thickness = thickness;

		thread = new Thread(this);
		thread.start();
	}

	public abstract void run();

	public Figure getFigure() {
		return figure;
	}

	public Thread getThread() {
		return thread;
	}
}
