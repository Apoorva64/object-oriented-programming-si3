package fr.epu.bicycle;

/**
 * @author MBF
 */
public class GPS {

    private Position position = new Position(0,0);

    public Position getPosition() {
        return position;
    }

    public void move(double dx, double dy){
        position = new Position(position.getX()+dx, position.getY()+dy);
    }

}