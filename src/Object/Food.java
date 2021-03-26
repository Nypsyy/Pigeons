package Object;

import Shape.Square;

import Window.Configuration;
import Window.World;

public class Food extends Entity {
    private final int freshTimer;
    private boolean isFresh;

    public Food(int x, int y) {
        super(Configuration.foodDefaultColor, Configuration.foodEventColor, Configuration.foodSize, Configuration.foodThickness);

        figure = new Square(x, y, defaultColor, size, thickness);
        freshTimer = Configuration.freshTimer;
        isFresh = true;
        thread.start();
    }

    public boolean isFresh() {
        return isFresh;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(freshTimer);
        } catch (InterruptedException e) {
            thread.interrupt();
        }

        isFresh = false;
        figure.setColor(eventColor);

        try {
            Thread.sleep(freshTimer / 2);
        } catch (InterruptedException e) {
            thread.interrupt();
        }

        World.removeFood(this);
    }
}
