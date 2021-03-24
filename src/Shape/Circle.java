package Shape;

import java.awt.*;

public class Circle extends Figure {
	private final int radius;

	public Circle(int x, int y, Color color, int radius, int thickness) {
		super(x, y, color, thickness);
		this.radius = Math.abs(radius);
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D graphics2D = (Graphics2D) g;

		g.setColor(this.color);
		graphics2D.setStroke(new BasicStroke(this.thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		graphics2D.drawOval(this.position.getX(), this.position.getY(), radius, radius);
	}
}
