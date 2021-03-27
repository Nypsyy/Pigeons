package Action;

import Object.Pigeon;
import Shape.Point;
import Window.Configuration;

import java.util.Random;

public class PigeonThreatened extends EntityAction {
    private final Pigeon pigeon;
    private int threatenedTimer;

    public PigeonThreatened(Pigeon pigeon) {
        super();

        this.pigeon = pigeon;
        setThreatenedTimer();
        startAction();
    }

    @Override
    public void run() {
        while (!thread.isInterrupted()) {
            try {
                Thread.sleep(threatenedTimer);
                pigeon.getFigure().setColor(pigeon.getThreatenedColor());
                threatened();
            } catch (InterruptedException e) {
                return;
            }
            pigeon.setThreatened(false);
        }
    }

    public synchronized void setThreatenedTimer() {
        threatenedTimer = new Random().nextInt(Configuration.pigeonMaxThreatenedTimer * 1000);
    }

    private void threatened() throws InterruptedException {
        Point pigeonPos = pigeon.getFigure().getPosition();
        boolean arrived = false;

        pigeon.setThreatened(true);
        Point pt = new Point(pigeonPos.getX() + new Random().nextInt(60), pigeonPos.getY() + new Random().nextInt(60));

        while (!arrived) {
            Thread.sleep(Configuration.screenRefreshRate);
            pigeon.goTo(pt);

            double distance = Math.sqrt(Math.pow(pt.getX() - pigeonPos.getX(), 2) + Math.pow(pt.getY() - pigeonPos.getY(), 2));
            arrived = distance <= pigeon.getSize() / 2f;
        }
    }
}
