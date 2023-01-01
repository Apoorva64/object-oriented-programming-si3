package TD1.fr.epu.vehicles;


public class Scooter extends BorrowableElectricTrackableItem {
    private final double maxSpeed;

    public Scooter(int maxSpeed) {
        super();
        this.maxSpeed = maxSpeed;
    }

    public Scooter(Battery battery, int maxSpeed, GPS gps) {
        super(battery, gps);
        this.maxSpeed = maxSpeed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }
}
