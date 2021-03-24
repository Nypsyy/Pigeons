package Shape;

import java.awt.*;

public class Circle extends Figure {
	private final int radius;
	private final int thickness;

	public Circle(Point position, Color color, int radius, int thickness) {
		super(position, color);
		this.radius = Math.abs(radius);
		this.thickness = Math.abs(thickness);
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D graphics2D = (Graphics2D) g;

		g.setColor(this.color);
		graphics2D.setStroke(new BasicStroke(this.thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		graphics2D.drawOval(this.position.getX() + radius, this.position.getY() + radius, radius, radius);
	}
}
