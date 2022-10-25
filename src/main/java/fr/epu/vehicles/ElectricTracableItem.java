package fr.epu.vehicles;

import java.util.Optional;

public abstract class ElectricTracableItem implements Trackable {
    static final int INITIAL_CHARGE = 12;
    private final GPS gps;
    private final Battery battery;
    protected double km;

    protected ElectricTracableItem(Battery battery, GPS gps) {
        this.battery = battery;
        this.gps = gps;
    }

    protected ElectricTracableItem() {
        this(new Battery(), new GPS());
        this.battery.charge(INITIAL_CHARGE);
    }

    /**
     * Convert miles to km
     *
     * @param miles the distance in miles
     */
    public static double milesToKm(double miles) {
        return miles * 1.609344;
    }

    /**
     * Convert km to miles
     *
     * @param km the distance in km
     */
    public static double kmToMiles(double km) {
        return km / 1.609344;
    }

    public double getKm() {
        return km;
    }

    private void setKm(double km) {
        this.km = km;
    }

    /**
     * Modifies the number of km traveled by adding <code>nbKmToAdd</code> km.
     *
     * @param nbKmToAdd the number of km to add
     */
    public void addKm(double nbKmToAdd) {
        if (nbKmToAdd < 0)
            throw new IllegalArgumentException("The number of km to add must be positive");
        setKm(getKm() + nbKmToAdd);
    }

    public int getCharge() {
        return battery.getCharge();
    }

    public void charge(int energy) {
        battery.charge(energy);
    }

    public double getChargePercent() {
        return battery.getChargePercent();
    }

    /**
     * Checks if the battery is not empty and returns the position of the scooter.
     *
     * @return the position
     */
    @Override
    public Optional<Position> getPosition() {
        return Optional.ofNullable(getCharge() > 0 ? gps.getPosition() : null);
    }

    public GPS getGps() {
        return gps;
    }
}
