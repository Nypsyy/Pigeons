package Shape;

import java.util.Objects;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Récupère la coordonnée x du point
     * @return
     */
    public int getX() {
        return this.x;
    }

    /**
     * Récupère la coordonnée y du point
     * @return
     */
    public int getY() {
        return this.y;
    }

    /**
     * Modifie les coordonnées
     * @param x
     * @param y
     */
    public void update(int x, int y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
