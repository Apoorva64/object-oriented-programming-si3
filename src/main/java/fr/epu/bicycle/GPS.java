package fr.epu.bicycle;

/**
 * GPS represents a GPS that can be used to get the position of a bicycle.
 *
 * @author Appadoo Apoorva Srinivas
 */
public class GPS {
    private final Position position;

    /**
     * Creates a GPS with at 0,0.
     */
    public GPS() {
        this.position = new Position(0, 0);
    }


    /**
     * Sets the position of the GPS.
     *
     * @param x the x to set
     * @param y the y to set
     */
    public void move(double x, double y) {
        this.position.setX(this.position.getX() + x);
        this.position.setY(this.position.getY() + y);
    }

    /**
     * Returns the position of the GPS.
     *
     * @return the position of the GPS
     */
    public Position getPosition() {
        return position;
    }
}
