package Shape;

import java.awt.*;

public class Circle extends Figure {
    public Circle(int x, int y, Color color, int radius, int thickness) {
        super(x, y, color, thickness, radius);
    }

    /**
     * Dessine un cercle
     * @param g
     */
    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.drawOval(position.getX() - size / 2, position.getY() - size / 2, size, size);
    }
}
