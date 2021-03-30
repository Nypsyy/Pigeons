package Action;

import Object.Pigeon;
import Object.Food;
import Shape.Point;
import Window.Game;

public class PigeonEat extends EntityAction {
	private final Pigeon pigeon;

	/**
	 * Configure le thread pour manger et le démarre
	 * @param pigeon
	 */
	public PigeonEat(Pigeon pigeon) {
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
			// Récupère la nourriture fraîche
			Food freshFood = Game.getFreshFood();
			// Essaie de manger si la nourriture existe et si le pigeon n'est pas effrayé
			if (freshFood != null && !pigeon.isThreatened())
				tryToEat(freshFood);
		}
	}

	/**
	 * Essaie de manger la nourriture en paramètre
	 * @param food
	 */
	private void tryToEat(Food food) {
		Point foodPoint = food.getFigure().getPosition();
		Point pigeonPoint = pigeon.getFigure().getPosition();
		// Calcul la distance entre la nourriture et le pigeon
		double distance = Math.sqrt(Math.pow(foodPoint.getX() - pigeonPoint.getX(), 2) + Math.pow(foodPoint.getY() - pigeonPoint.getY(), 2));

		// Si le pigeon est proche, mange la nourriture fraîche
		if (distance <= food.getSize() / 2f + pigeon.getSize() / 2f)
			Game.eatFood(food);
	}
}
