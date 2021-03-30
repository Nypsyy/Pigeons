package Action;

import Object.Pigeon;
import Object.Food;
import Window.Configuration;
import Window.Game;

public class PigeonRun extends EntityAction {
    private final Pigeon pigeon;

    /**
     * Configure le thread de déplacement vers la nourriture fraîche du pigeon et le démarre
     * @param pigeon
     */
    public PigeonRun(Pigeon pigeon) {
        super();

        this.pigeon = pigeon;
        startAction();
    }

    /**
     * Exécution du thread
     */
    @Override
    public void run() {
        // Tourne tant que le thread n'est pas terminé
        while (!thread.isInterrupted()) {
            // Se déplace s'il n'est pas effrayé
            if (!pigeon.isThreatened()) {
                // Récupère la nourriture fraîche
                Food freshFood = Game.getFreshFood();
                if (freshFood != null) {
                    // Se déplace vers la nourriture fraîche
                    pigeon.goTo(freshFood.getFigure().getPosition());
                    try {
                        // Ajoute un temps de pause
                        Thread.sleep(Configuration.screenRefreshRate);
                    } catch (InterruptedException e) {
                        return;
                    }
                } else
                    pigeon.getFigure().setColor(pigeon.getDefaultColor());
            }
        }
    }
}
