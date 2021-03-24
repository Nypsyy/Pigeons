package Shape;

import java.awt.*;

public abstract class Figure {
	protected Point position;
	protected Color color;

	public Figure(Point position, Color color) {
		this.position = position;
		this.color = color;
	}

	public abstract void draw(Graphics g);
}
