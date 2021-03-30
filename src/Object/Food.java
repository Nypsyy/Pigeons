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

		figure = new Square(x, y, defaultColor, size, thickness);
		isFresh = true;

		initTimer();
	}

	private void initTimer() {
		int freshTimer = Configuration.freshTimer * 1000;

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

	private void rotten() {
		isFresh = false;
		figure.setColor(eventColor);
	}

	private void delete() {
		Game.removeFood(this);
	}

	public boolean isFresh() {
		return isFresh;
	}
}
