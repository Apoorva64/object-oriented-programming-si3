package fr.epu.bicycle;

public abstract class ElectricVehicle {

    protected int km;
    protected GPS gps;
    protected Battery battery;
    static final int INITIAL_CHARGE = 100;


    /**
     * Creates an ElectricVehicle with a given initial charge and initial distance.
     */
    protected ElectricVehicle() {
        this.km = 0;
        this.gps = new GPS();
        this.battery = new Battery(INITIAL_CHARGE);
    }

    /**
     * Returns the current distance of the EBike.
     *
     * @return the km
     */
    public int getKm() {
        return km;
    }

    /**
     * Sets the distance of the EBike. The distance cannot be negative.
     *
     * @param km the km to set
     */
    private void setKm(int km) {
        if (km < 0) {
            throw new IllegalArgumentException("The distance cannot be negative");
        }
        this.km = km;
    }

    /**
     * Modifies the number of km traveled by adding <code>nbKmToAdd</code> km.
     *
     * @param nbKmToAdd the number of km to add
     */
    public void addKm(int nbKmToAdd) {
        if (nbKmToAdd > 0) {
            setKm(getKm() + nbKmToAdd);
        }
    }

    /**
     * Returns the current charge of the battery.
     *
     * @return the charge of the battery
     */
    public int getCharge() {
        return battery.getCharge();
    }

    /**
     * Returns the current position of the EBike.
     *
     * @return the gps position
     */
    public Position getPosition() {
        return gps.getPosition();
    }

}
