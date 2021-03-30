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

        // Configure la figure et le timer de peur
        figure = new Circle(x, y, defaultColor, size, thickness);
        threatenedColor = Configuration.pigeonThreatenedColor;
        threatened = false;
    }

    /**
     * Configure une nouvelle destination pour un pigeon
     * @param dest
     */
    public void goTo(Point dest) {
        // Modifie sa couleur
        figure.setColor(isThreatened() ? threatenedColor : eventColor);

        if (dest == null)
            return;

        // Calcul les nouvelles coordonnées pour le prochain rafraîchissement
        float x = dest.getX() - figure.getPosition().getX();
        float y = dest.getY() - figure.getPosition().getY();
        float length = (float) Math.sqrt(x * x + y * y);

        x = x / length * speed;
        y = y / length * speed;

        // Modifie la position
        figure.getPosition().update((int) x, (int) y);
    }

    /**
     * Modifie l'état de peur
     * @param threatened
     */
    public void setThreatened(boolean threatened) {
        this.threatened = threatened;
    }

    /**
     * Récupère si le pigeon est en état de peur
     * @return
     */
    public boolean isThreatened() {
        return threatened;
    }

    /**
     * Récupère la couleur de peur
     * @return
     */
    public Color getThreatenedColor() {
        return threatenedColor;
    }
}
