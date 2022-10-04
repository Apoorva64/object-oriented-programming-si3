package fr.epu.bicycle;

/**
 * EBike implements the computer part of an EBike that would have a battery and a location.
 *
 * @author Appadoo Apoorva Srinivas
 */
public class EBike {
    static final int INITIAL_DISTANCE = 1;
    static final int INITIAL_CHARGE = 100;
    private final GPS gps;
    private final Battery battery;
    private int km;


    /**
     * Creates an EBike with a given initial charge and initial distance.
     */
    public EBike() {
        this.km = INITIAL_DISTANCE;
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

    @Override
    public String toString() {
        return "EBike [km=" + km + ", gps=" + gps + ", battery=" + battery + "]";
    }


}