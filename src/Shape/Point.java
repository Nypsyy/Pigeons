package Shape;

public class Point {
	private final int x;
	private final int y;

	public Point(int x, int y) {
		this.x = Math.abs(x);
		this.y = Math.abs(y);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
