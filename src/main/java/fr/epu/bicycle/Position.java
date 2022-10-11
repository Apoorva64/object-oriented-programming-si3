package fr.epu.bicycle;


import java.util.Objects;

/**
 * Position represents a position in a 2D space.
 *
 * @author Appadoo Apoorva Srinivas
 */
public class Position {
    private double x;
    private double y;
    private static final double EPSILON = 0.0001;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return position.x - x < EPSILON && position.y - y < EPSILON;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    /**
     * Creates a position with a given x and y.
     *
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x coordinate of the position.
     *
     * @return the x coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the y coordinate of the position.
     *
     * @return the y coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * Sets the x coordinate of the position.
     *
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Sets the y coordinate of the position.
     *
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Position [x=" + x + ", y=" + y + "]";
    }

    /**
     * Calculates the distance between the current position and the given position.
     *
     * @param position the position to calculate the distance to
     * @return the distance between the current position and the given position
     */
    public double distanceTo(Position position) {
        double xDelta = position.getX() - this.getX();
        double yDelta = position.getY() - this.getY();
        return Math.sqrt(xDelta * xDelta + yDelta * yDelta);


    }

}

