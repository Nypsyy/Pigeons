package Action;

import Object.Pigeon;
import Object.Food;
import Window.Configuration;
import Window.Game;

public class PigeonRun extends EntityAction {
    private final Pigeon pigeon;

    public PigeonRun(Pigeon pigeon) {
        super();

        this.pigeon = pigeon;
        startAction();
    }

    @Override
    public void run() {
        while (!thread.isInterrupted()) {
            if (!pigeon.isThreatened()) {
                Food freshFood = Game.getFreshFood();
                if (freshFood != null) {
                    pigeon.goTo(freshFood.getFigure().getPosition());
                    try {
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
