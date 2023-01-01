package TD1.fr.epu.vehicles;

/**
 * Battery represents a battery that can be charged and discharged.
 *
 * @author Appadoo Apoorva Srinivas
 */
public class Battery {

    private int charge = 0;
    private final int maxCharge;
    public static final int DEFAULT_MAX_CHARGE = 100;

    public int getCharge() {
        return charge;
    }


    public Battery(int maxLevel) {
        if (maxLevel <= 0) {
            throw new IllegalArgumentException("Max charge must be positive");
        }
        maxCharge = maxLevel;
    }

    public Battery() {
        this(DEFAULT_MAX_CHARGE);
    }

    public void charge(int energy) {
        charge += energy;
        if (charge > maxCharge)
            charge = maxCharge;
    }


    public double getChargePercent() {
        return charge * 100 / (double) maxCharge;
    }
}


