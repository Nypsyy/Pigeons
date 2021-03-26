package Object;

import Shape.Square;

import java.awt.*;
import java.util.ArrayList;

public class FoodOld {
	private static final Color color = Color.RED;
	private static final int length = 10;
	private static final int thickness = 1;

	private final ArrayList<Crumb> crumbs = new ArrayList<>();

	//private static final Food food = new Food();

	//public static Food getInstance() {
	//	return food;
	//}

	public void addFood(int x, int y) {
		//System.out.println("e");
		crumbs.add(new Crumb(x , y));
	}

	public void removeFood(Crumb crumb) {
		crumbs.remove(crumb);
	}

	public ArrayList<Crumb> getCrumbs() {
		return crumbs;
	}

	public Crumb getFreshCrumb() {
		return crumbs.get(crumbs.size() - 1);
	}

	//private final Square square;

	//public Food(int x, int y) {
	//this.square = new Square(x, y, color, length, thickness);
	//}

	//public Square getSquare() {
	//	return this.square;
	//}

	public class Crumb {
		private final Square square;

		public Crumb(int x, int y) {
			this.square = new Square(x, y, color, length, thickness);
		}

		public Square getSquare() {
			return this.square;
		}
	}
}
