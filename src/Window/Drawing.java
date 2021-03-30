package Window;

import Object.Pigeon;
import Object.Food;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Drawing extends JPanel {
    private final Game world;

    public Drawing(Game world) {
        this.world = world;

        // Initialise le listener pour détecter un click
        initClickListener();
        // Configure un temps de rafraîchissement
        initRepaintTimer();
    }

    /**
     * Dessine le composant (zone de dessin)
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Accède aux pigeons de manière synchronisée pour dessiner leur figure
        synchronized (world.getPigeons()) {
            for (Pigeon pigeon : world.getPigeons())
                pigeon.getFigure().draw(g);
        }

        // Accède à la nourriture de manière synchronisée pour dessiner leur figure
        synchronized (world.getFood()) {
            for (Food food : world.getFood())
                food.getFigure().draw(g);
        }
    }

    /**
     * Configure le temps de rafraîchissement de l'écran
     */
    private void initRepaintTimer() {
        new Timer(Configuration.screenRefreshRate, e -> repaint()).start();
    }

    /**
     * Listener de click sur la zone de dessin
     */
    private void initClickListener() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                // Ajoute de la nourriture avec un clic gauche
                if (e.getButton() == MouseEvent.BUTTON1)
                    synchronized (world.getFood()) {
                        world.addFood(e.getX(), e.getY());
                    }
                // Ajoute un pigeon avec un clic droit
                else if (e.getButton() == MouseEvent.BUTTON3)
                    synchronized (world.getPigeons()) {
                        world.addPigeon(e.getX(), e.getY());
                    }
                // Réinitialise le jeu avec un clic molette
                else if (e.getButton() == MouseEvent.BUTTON2)
                    world.resetWorld();
            }
        });
    }
}
