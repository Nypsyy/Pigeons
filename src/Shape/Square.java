package Shape;

import java.awt.*;

public class Square extends Figure {
	private final int length;

	public Square(int x, int y, Color color, int length, int thickness) {
		super(x, y, color, thickness);
		this.length = Math.abs(length);
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D graphics2D = (Graphics2D) g;

		g.setColor(this.color);
		graphics2D.setStroke(new BasicStroke(this.thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		graphics2D.drawRect(this.position.getX(), this.position.getY(), this.length, this.length);
	}
}
