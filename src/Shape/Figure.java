package Shape;

import java.awt.*;

public abstract class Figure {
	protected Point position;
	protected Color color;

	protected int size;
	protected int thickness;

	public Figure(int x, int y, Color color, int thickness, int size) {
		this.position = new Point(x, y);
		this.color = color;
		this.size = Math.abs(size);
		this.thickness = Math.abs(thickness);
	}

	public Point getPosition() {
		return position;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void draw(Graphics g) {
		g.setColor(color);
		((Graphics2D) g).setStroke(new BasicStroke(thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
	}
}
