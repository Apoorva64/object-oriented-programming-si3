package fr.epu.bicycle;


import java.util.Objects;

/**
 * TP java
 *
 * @author frÃ©dÃ©ric rallo - frederic.rallo@univ-cotedazur.fr
 * @author Mireille Blay-Fornarino
 */
public class Position {
    private final double x;
    private final double y;

    private static final double EPSILON = 0.001;

    // -------------------------- accesseurs ------------

    //We prohibit changing a position externally
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    //-------------- constructeurs ----------------

    /**
     * constructeur normal
     *
     * @param ix l'abscisse du point
     * @param iy l'ordonnÃ©e du point
     */
    public Position(double ix, double iy) {
        x = ix;
        y = iy;
    }

    /**
     * default constructor
     */
    public Position() {
        this(0, 0);
    }

    // ------------------------ public methods

    /**
     * calculate the distance to another position
     *
     * @param p another position
     * @return a norm distance of the vector (this,p)
     */
    public double distance(Position p) {
        return Math.sqrt((p.y - y) * (p.y - y) + (p.x - x) * (p.x - x));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Math.abs(position.x - x) < EPSILON &&
                Math.abs(position.y - y) < EPSILON;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    // ---- Non demandÃ©es dans le TD

    /**
     * calcule le point projetÃ© de ce point sur l'axe des abscisses
     *
     * @return un nouveau Point
     */
    public Position projX() {
        return new Position(x, 0);
    }

    /**
     * calcule le point projetÃ© de ce point sur l'axe des ordonnÃ©es
     *
     * @return un nouveau Point
     */
    public Position projY() {
        return new Position(0, y);
    }
    //------------------------------------


    @Override
    public String toString() {
        return "(" + x + " ; " + y + ")";
    }


}