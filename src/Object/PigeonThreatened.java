package Object;

import Shape.Point;
import Window.Configuration;

import java.util.Random;

public class PigeonThreatened implements Runnable {
    private final Pigeon pigeon;
    private int threatenedTimer;

    private void threatened() throws InterruptedException {
        boolean arrived = false;
        pigeon.setThreatened(true);
        Point pt = new Point(pigeon.getFigure().getPosition().getX() + new Random().nextInt(60),
                pigeon.getFigure().getPosition().getY() + new Random().nextInt(60));

        while (!arrived) {
            Thread.sleep(Configuration.screenRefreshRate);
            pigeon.goTo(pt);

            double distance = Math.sqrt(Math.pow(pt.getX() - pigeon.getFigure().getPosition().getX(), 2)
                    + Math.pow(pt.getY() - pigeon.getFigure().getPosition().getY(), 2));

            if (distance <= pigeon.size / 2f)
                arrived = true;
        }
    }

    public synchronized void setThreatenedTimer() {
        threatenedTimer = new Random().nextInt(Configuration.pigeonMaxThreatenedTimer * 1000);
    }

    public PigeonThreatened(Pigeon pigeon) {
        this.pigeon = pigeon;
        setThreatenedTimer();
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(threatenedTimer);
                pigeon.getFigure().setColor(Configuration.pigeonThreatenedColor);
                threatened();
                pigeon.setThreatened(false);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " - PIGEON_THREATENED couldn't sleep");
                e.printStackTrace();
            }
        }
    }

    public synchronized void interrupt() {
        Thread.currentThread().interrupt();
    }
}
