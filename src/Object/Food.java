package Object;

import Shape.Square;

import Window.Configuration;
import Window.World;

import java.util.Timer;
import java.util.TimerTask;

public class Food extends Entity {
    private final int freshTimer;
    private boolean isFresh;

    public Timer lifeTimer;

    private void delete() {
        World.removeFood(this);
    }

    private void rotten() {
        isFresh = false;
        figure.setColor(eventColor);
    }

    public Food(int x, int y) {
        super(Configuration.foodDefaultColor, Configuration.foodEventColor, Configuration.foodSize, Configuration.foodThickness);

        figure = new Square(x, y, defaultColor, size, thickness);
        freshTimer = Configuration.freshTimer;
        isFresh = true;

        lifeTimer = new Timer();

        lifeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                rotten();
            }
        }, freshTimer);

        lifeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                delete();
            }
        }, 3 * freshTimer / 2);
    }

    public boolean isFresh() {
        return isFresh;
    }
}
