package Action;

public abstract class EntityAction implements Runnable {
	protected final Thread thread;

	public EntityAction() {
		thread = new Thread(this);
	}

	public abstract void run();

	public void startAction() {
		thread.start();
	}

	public void interruptAction() {
		thread.interrupt();
	}
}
