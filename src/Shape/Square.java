package Shape;

import java.awt.*;

public class Square extends Figure {
	public Square(int x, int y, Color color, int length, int thickness) {
		super(x, y, color, thickness, length);
	}

	@Override
	public void draw(Graphics g) {
		super.draw(g);
		g.drawRect(position.getX() - size / 2, position.getY() - size / 2, size, size);
	}
}
