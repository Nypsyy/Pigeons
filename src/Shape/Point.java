package Shape;

public class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = Math.abs(x);
		this.y = Math.abs(y);
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void update(int x, int y) {
		this.x += Math.abs(x);
		this.y += Math.abs(y);
	}
}
