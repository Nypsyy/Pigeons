package Action;

public abstract class EntityAction implements Runnable {
	protected final Thread thread;

	/**
	 * Initialise le thread de l'action
	 */
	public EntityAction() {
		thread = new Thread(this);
	}

	public abstract void run();

	/**
	 * Démarre le thread de l'action
	 */
	public void startAction() {
		thread.start();
	}

	/**
	 * Termine le thread de l'action
	 */
	public void interruptAction() {
		thread.interrupt();
	}
}
