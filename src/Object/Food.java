package Object;

import Shape.Square;

import Window.Configuration;
import Window.Game;

import java.util.Timer;
import java.util.TimerTask;

public class Food extends Entity {
	public Timer lifeTimer;
	private boolean isFresh;

	public Food(int x, int y) {
		super(Configuration.foodDefaultColor, Configuration.foodEventColor, Configuration.foodSize, Configuration.foodThickness);

		// Configure la figure et la fraîcheur de la nourriture
		figure = new Square(x, y, defaultColor, size, thickness);
		isFresh = true;

		// Initialise le timer de fraîcheur
		initTimer();
	}

	/**
	 * Initialise le timer de fraîcheur
	 */
	private void initTimer() {
		int freshTimer = Configuration.freshTimer * 1000;

		lifeTimer = new Timer();
		// La nourriture n'est plus fraîche après freshTimer secondes
		lifeTimer.schedule(new TimerTask() {
			@Override
			public void run() {
				rotten();
			}
		}, freshTimer);
		// Supprime la nourriture après freshTimer/2 secondes
		lifeTimer.schedule(new TimerTask() {
			@Override
			public void run() {
				delete();
			}
		}, 3 * freshTimer / 2);
	}

	/**
	 * La nourriture n'est plus fraîche est change sa couleur
	 */
	private void rotten() {
		isFresh = false;
		figure.setColor(eventColor);
	}

	/**
	 * Supprime la nourriture
	 */
	private void delete() {
		Game.removeFood(this);
	}

	/**
	 * Récupère la fraîcheur de la nourriture
	 * @return
	 */
	public boolean isFresh() {
		return isFresh;
	}
}
