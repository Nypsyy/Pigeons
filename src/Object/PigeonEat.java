package Object;

import Shape.Point;
import Window.World;

public class PigeonEat implements Runnable {
    private final Pigeon pigeon;

    private void tryToEat(Food food) {
        Point foodPoint = food.getFigure().getPosition();
        double distance = Math.sqrt(Math.pow(foodPoint.getX() - pigeon.getFigure().getPosition().getX(), 2)
                + Math.pow(foodPoint.getY() - pigeon.getFigure().getPosition().getY(), 2));

        if (distance <= food.size / 2f + pigeon.size / 2f)
            World.eatFood(food);
    }

    public PigeonEat(Pigeon pigeon) {
        this.pigeon = pigeon;

        new Thread(this).start();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            Food freshFood = World.getFreshFood();
            if (freshFood != null) {
                tryToEat(freshFood);
            }
        }
    }

    public void interrupt() {
        Thread.currentThread().interrupt();
    }
}
