package Window;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private final int width;
    private final int height;

    /**
     * Initialisation de la fenêtre
     * @param name
     * @param width
     * @param height
     * @param drawing
     */
    public Window(String name, int width, int height, Drawing drawing) {
        super(name);

        // Taille de la fenêtre
        this.width = Math.abs(width);
        this.height = Math.abs(height);

        // Configuration de la zone de dessin
        configureContainer(drawing);
        // Configuration de la fenêtre
        configureWindow();
    }

    /**
     * Configuration de la fenêtre
     */
    private void configureWindow() {
        // Définition de l'opération de fermeture
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Définition de la taille de la fenêtre
        setSize(width, height);
        // Rend la fenêtre visible
        setVisible(true);
    }

    /**
     * Configuration de la zone de dessin
     * @param drawing
     */
    private void configureContainer(Drawing drawing) {
        // Initialise le container
        Container container = getContentPane();
        // Ajoute la zone de dessin
        container.add(drawing, BorderLayout.CENTER);
    }
}
