package Object;

import Shape.Circle;
import Shape.Point;
import Window.Configuration;

import java.awt.*;

public class Pigeon extends MovingEntity {
    private final Color threatenedColor;
    private boolean threatened;

    public Pigeon(int x, int y) {
        super(Configuration.pigeonDefaultColor, Configuration.pigeonEventColor, Configuration.pigeonSize, Configuration.pigeonThickness, Configuration.pigeonMaxSpeed);

        figure = new Circle(x, y, defaultColor, size, thickness);
        threatenedColor = Configuration.pigeonThreatenedColor;
        threatened = false;
    }

    public void goTo(Point dest) {
        figure.setColor(isThreatened() ? threatenedColor : eventColor);

        if (dest == null)
            return;

        float x = dest.getX() - figure.getPosition().getX();
        float y = dest.getY() - figure.getPosition().getY();
        float length = (float) Math.sqrt(x * x + y * y);

        x = x / length * speed;
        y = y / length * speed;

        figure.getPosition().update((int) x, (int) y);
    }

    public void setThreatened(boolean threatened) {
        this.threatened = threatened;
    }

    public boolean isThreatened() {
        return threatened;
    }

    public Color getThreatenedColor() {
        return threatenedColor;
    }
}
