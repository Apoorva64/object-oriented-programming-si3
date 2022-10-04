package fr.epu.bicycle;

/**
 * Battery represents a battery that can be charged and discharged.
 *
 * @author Appadoo Apoorva Srinivas
 */
public class Battery {
    private int charge;
    private int maxCharge = 100;

    /**
     * Creates a battery with a given charge.
     *
     * @param initialCharge the initial charge of the battery
     */
    public Battery(int initialCharge) {
        this.charge = initialCharge;
    }

    /**
     * Returns the current charge of the battery.
     *
     * @return the current charge of the battery
     */
    public int getCharge() {
        return charge;
    }


    /**
     * Charges the battery by <code>nbChargeToAdd</code> units. The charge cannot exceed the maximum charge.
     *
     * @param charge the charge to set
     */
    public void charge(int charge) {
        this.charge += charge;
        if (this.charge > maxCharge) {
            this.charge = maxCharge;
        }
    }

    /**
     * Discharges the battery by <code>nbChargeToSubtract</code> units. The charge cannot be negative.
     *
     * @param charge the charge to set
     */
    public void discharge(int charge) {
        this.charge -= charge;
        if (this.charge < 0) {
            this.charge = 0;
        }
    }

    /**
     * set the maximum charge of the battery.
     *
     * @param maxCharge the maximum charge of the battery
     */
    public void setMaxCharge(int maxCharge) {
        this.maxCharge = maxCharge;
    }

    /**
     * Returns the maximum charge of the battery.
     *
     * @return the maximum charge of the battery
     */
    public int getMaxCharge() {
        return maxCharge;
    }

}
