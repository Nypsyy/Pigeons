package Shape;

import java.awt.*;

public abstract class Figure {
	protected Point position;
	protected Color color;
	protected int thickness;

	public Figure(int x, int y, Color color, int thickness) {
		this.position = new Point(x, y);
		this.color = color;
		this.thickness = Math.abs(thickness);
	}

	public abstract void draw(Graphics g);
}
