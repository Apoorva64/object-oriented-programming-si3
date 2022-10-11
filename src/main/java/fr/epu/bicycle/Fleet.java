package fr.epu.bicycle;

import java.util.ArrayList;
import java.util.List;

public class Fleet {
    private final ArrayList<ElectricVehicle> electricVehicles;

    /**
     * Creates a fleet of electric vehicles.
     */
    public Fleet() {
        this.electricVehicles = new ArrayList<>();
    }


    /**
     * Adds an electric vehicle to the fleet.
     *
     * @param electricVehicle the electric vehicle to add
     */
    public void addElectricVehicle(EBike electricVehicle) {
        electricVehicles.add(electricVehicle);
    }

    /**
     * Removes an electric vehicle from the fleet.
     *
     * @param electricVehicle the electric vehicle to remove
     */
    public void removeElectricVehicle(ElectricVehicle electricVehicle) {
        electricVehicles.remove(electricVehicle);
    }

    /**
     * Returns the number of electric vehicles in the fleet.
     *
     * @return the number of electric vehicles in the fleet
     */
    public int getNbElectricVehicles() {
        return electricVehicles.size();
    }

    /**
     * Returns the electric vehicle at the given index.
     *
     * @param index the index of the electric vehicle to get
     * @return the electric vehicle at the given index
     */
    public ElectricVehicle getElectricVehicle(int index) {
        return electricVehicles.get(index);
    }

    /**
     * Returns the electric vehicles that are in a circle of radius <code>radius</code> centered at <code>position</code>.
     *
     * @return the electric vehicles that are around a given position
     */
    public List<ElectricVehicle> getElectricVehiclesAround(Position position, double radius) {
        return electricVehicles.stream()
                .filter(electricVehicle -> electricVehicle.getPosition().distanceTo(position) <= radius)
                .toList();

    }
}
