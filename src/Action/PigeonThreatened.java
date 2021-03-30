package Action;

import Object.Pigeon;
import Shape.Point;
import Window.Configuration;

import java.util.Random;

public class PigeonThreatened extends EntityAction {
    private final Pigeon pigeon;
    private int threatenedTimer;

    /**
     * Configure le thread de peur du pigeon et le démarre
     * @param pigeon
     */
    public PigeonThreatened(Pigeon pigeon) {
        super();

        this.pigeon = pigeon;
        setThreatenedTimer();
        startAction();
    }

    /**
     * Exécution du thread
     */
    @Override
    public void run() {
        // Tourne tant que le thread n'est pas terminé
        while (!thread.isInterrupted()) {
            try {
                // Ajoute un temps de pause
                Thread.sleep(threatenedTimer);
                // Change la couleur du pigeon (état de peur)
                pigeon.getFigure().setColor(pigeon.getThreatenedColor());
                // Fuite du pigeon
                threatened();
            } catch (InterruptedException e) {
                return;
            }
            // La pigeon n'a plus peur
            pigeon.setThreatened(false);
        }
    }

    /**
     * Modifie le timer de peur
     */
    public synchronized void setThreatenedTimer() {
        threatenedTimer = new Random().nextInt(Configuration.pigeonMaxThreatenedTimer * 1000);
    }

    /**
     * Déclenche la fuite du pigeon
     * @throws InterruptedException
     */
    private void threatened() throws InterruptedException {
        Point pigeonPos = pigeon.getFigure().getPosition();
        boolean arrived = false;

        // Le pigeon a peur
        pigeon.setThreatened(true);
        // Calcul les coordonnées de destination (aléatoire)
        Point pt = new Point(pigeonPos.getX() + new Random().nextInt(200) - 100, pigeonPos.getY() + new Random().nextInt(200) - 100);

        // Tant que le pigeon n'est pas à destination
        while (!arrived) {
            // Ajoute un temps de pause
            Thread.sleep(Configuration.screenRefreshRate);
            // Déplacement, étape par étape, le pigeon vers sa destination
            pigeon.goTo(pt);

            // Détermine si le pigeon est proche de sa destination
            double distance = Math.sqrt(Math.pow(pt.getX() - pigeonPos.getX(), 2) + Math.pow(pt.getY() - pigeonPos.getY(), 2));
            arrived = distance <= pigeon.getSize() / 2f;
        }
    }
}
