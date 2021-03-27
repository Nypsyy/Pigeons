package Object;

import Window.Configuration;
import Window.World;

public class PigeonRun implements Runnable {
    private final Pigeon pigeon;

    public PigeonRun(Pigeon pigeon) {
        this.pigeon = pigeon;

        new Thread(this).start();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            if (!pigeon.isThreatened()) {
                Food freshFood = World.getFreshFood();
                if (freshFood != null) {
                    pigeon.goTo(freshFood.getFigure().getPosition());
                    try {
                        Thread.sleep(Configuration.screenRefreshRate);
                    } catch (InterruptedException e) {
                        System.out.println(Thread.currentThread().getName() + " - PIGEON_RUN couldn't sleep");
                        e.printStackTrace();
                    }
                } else
                    pigeon.getFigure().setColor(pigeon.defaultColor);
            }
        }
    }

    public void interrupt() {
        Thread.currentThread().interrupt();
    }
}
