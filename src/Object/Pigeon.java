package Object;

import Shape.Circle;
import Shape.Point;

import Window.World;
import Window.Configuration;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Pigeon extends MovingEntity {
    private final Timer threatenedTimer;
    private TimerTask threatenedTask;

    private boolean isThreatened;

    private void notThreatenedAnymore() {
        isThreatened = false;
    }

    private void initTimerTask() {
        threatenedTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println(thread.getName() + " - afraid");
                isThreatened = true;
                figure.setColor(Configuration.pigeonThreatenedColor);

                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        notThreatenedAnymore();
                    }
                }, 1000);
            }
        };
    }

    public void resetThreatening() {
        threatenedTask.cancel();
        threatenedTimer.purge();
        setThreatening();
    }

    public void setThreatening() {
        initTimerTask();
        System.out.println(thread.getName() + " - Setting timer...");
        threatenedTimer.schedule(threatenedTask, new Random().nextInt(Configuration.pigeonMaxThreatenedTimer * 1000));
    }

    public Pigeon(int x, int y) {
        super(Configuration.pigeonDefaultColor, Configuration.pigeonEventColor, Configuration.pigeonSize, Configuration.pigeonThickness, Configuration.pigeonMaxSpeed);
        figure = new Circle(x, y, defaultColor, size, thickness);
        isThreatened = false;
        // Timing
        threatenedTimer = new Timer();
        setThreatening();

        thread.start();
    }

    @Override
    public void run() {
        while (!thread.isInterrupted()) {
            if (!isThreatened)
                figure.setColor(defaultColor);

            if (World.getFreshFood() != null) {
                runFood();
            }
            Point self = figure.getPosition();
            Point random = new Point(new Random().nextInt(960), new Random().nextInt(720));
            float x = random.getX() - self.getX();
            float y = random.getY() - self.getY();
        }
    }

    private void runFood() {
        if (isThreatened)
            return;

        figure.setColor(eventColor);
        updateDestination();

        while (destination != null && !isThreatened) {
            figure.getPosition().update(destination.getX(), destination.getY());
            try {
                Thread.sleep(Configuration.screenRefreshRate);
            } catch (InterruptedException e) {
                thread.interrupt();
            }
            tryEatFood();
            updateDestination();
        }
    }

    private void updateDestination() {
        Food freshFood = World.getFreshFood();

        if (freshFood == null) {
            destination = null;
            return;
        }

        Point foodPoint = freshFood.getFigure().getPosition();
        Point pigeonPoint = figure.getPosition();

        float x = foodPoint.getX() - pigeonPoint.getX();
        float y = foodPoint.getY() - pigeonPoint.getY();
        float length = (float) Math.sqrt(x * x + y * y);

        x = x / length * speed;
        y = y / length * speed;

        destination = new Point((int) x, (int) y);
    }

    private void tryEatFood() {
        Food freshFood = World.getFreshFood();

        if (freshFood == null) {
            destination = null;
            return;
        }

        Point foodPosition = freshFood.getFigure().getPosition();
        Point pigeonPosition = figure.getPosition();
        double distance = Math.sqrt(Math.pow(foodPosition.getX() - pigeonPosition.getX(), 2) + Math.pow(foodPosition.getY() - pigeonPosition.getY(), 2));

        if (distance <= freshFood.size / 2f + size / 2f) {
            destination = null;
            World.eatFood(freshFood);
        }
    }
}
