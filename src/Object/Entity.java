package Object;

import Shape.Figure;

import java.awt.*;

public abstract class Entity {
    protected Figure figure;
    protected Color defaultColor;
    protected Color eventColor;

    protected int size;
    protected int thickness;

    public Entity(Color defaultColor, Color eventColor, int size, int thickness) {
        this.defaultColor = defaultColor;
        this.eventColor = eventColor;
        this.size = size;
        this.thickness = thickness;
    }

    public Figure getFigure() {
        return figure;
    }

    public int getSize() {
        return size;
    }

    public Color getDefaultColor() {
        return defaultColor;
    }
}
