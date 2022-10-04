package fr.epu.bicycle;


/**
 * Position represents a position in a 2D space.
 *
 * @author Appadoo Apoorva Srinivas
 */
public class Position {
    private double x;
    private double y;

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


}

