package fr.epu.bicycle;

/**
 * EBike implements the computer part of an EBike that would have a battery and a location.
 *
 * @author Appadoo Apoorva Srinivas
 */
public class EBike extends ElectricVehicle {
    static final int INITIAL_DISTANCE = 1;


    /**
     * Creates an EBike with a given initial charge and initial distance.
     */
    public EBike() {
        super();
        this.km = INITIAL_DISTANCE;
    }
    @Override
    public String toString() {
        return "EBike [km=" + km + ", gps=" + gps + ", battery=" + battery + "]";
    }


}