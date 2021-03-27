package Action;

import Object.Pigeon;
import Object.Food;
import Shape.Point;
import Window.Game;

public class PigeonEat extends EntityAction {
	private final Pigeon pigeon;

	public PigeonEat(Pigeon pigeon) {
		super();

		this.pigeon = pigeon;
		startAction();
	}

	@Override
	public void run() {
		while (!thread.isInterrupted()) {
			Food freshFood = Game.getFreshFood();
			if (freshFood != null && !pigeon.isThreatened())
				tryToEat(freshFood);
		}
	}

	private void tryToEat(Food food) {
		Point foodPoint = food.getFigure().getPosition();
		Point pigeonPoint = pigeon.getFigure().getPosition();
		double distance = Math.sqrt(Math.pow(foodPoint.getX() - pigeonPoint.getX(), 2) + Math.pow(foodPoint.getY() - pigeonPoint.getY(), 2));

		if (distance <= food.getSize() / 2f + pigeon.getSize() / 2f)
			Game.eatFood(food);
	}
}
