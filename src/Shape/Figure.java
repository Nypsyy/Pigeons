package Shape;

import java.awt.*;

public abstract class Figure {
	protected Point position;
	protected Color color;

	protected int size;
	protected int thickness;

	/**
	 * Initialise la position, couleur, taille et finesse d'une figure
	 * @param x
	 * @param y
	 * @param color
	 * @param thickness
	 * @param size
	 */
	public Figure(int x, int y, Color color, int thickness, int size) {
		this.position = new Point(x, y);
		this.color = color;
		this.size = Math.abs(size);
		this.thickness = Math.abs(thickness);
	}

	/**
	 * Récupère la position de la figure
	 * @return
	 */
	public Point getPosition() {
		return position;
	}

	/**
	 * Modifie la couleur de la figure
	 * @param color
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * Dessine la figure sans remplissage
	 * @param g
	 */
	public void draw(Graphics g) {
		g.setColor(color);
		((Graphics2D) g).setStroke(new BasicStroke(thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
	}
}
