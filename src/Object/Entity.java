package Object;

import Shape.Figure;

import java.awt.*;

public abstract class Entity {
    protected Figure figure;
    protected Color defaultColor;
    protected Color eventColor;

    protected int size;
    protected int thickness;

    /**
     * Configure une entité avec une couleur par défaut, une couleur lors d'un évènement, une taille
     * et une finesse
     * @param defaultColor
     * @param eventColor
     * @param size
     * @param thickness
     */
    public Entity(Color defaultColor, Color eventColor, int size, int thickness) {
        this.defaultColor = defaultColor;
        this.eventColor = eventColor;
        this.size = size;
        this.thickness = thickness;
    }

    /**
     * Récupère la figure
     * @return
     */
    public Figure getFigure() {
        return figure;
    }

    /**
     * Récupère la taille
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * Récupère la couleur de base
     * @return
     */
    public Color getDefaultColor() {
        return defaultColor;
    }
}
