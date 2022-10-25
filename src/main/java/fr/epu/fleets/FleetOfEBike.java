package fr.epu.fleets;

import fr.epu.vehicles.EBike;

import java.util.List;

public class FleetOfEBike extends FleetOfTrackable<EBike> {
    public List<EBike> EBikesWithMileageOver(int maxKm) {
        return trackables.stream().filter(eBike -> eBike.getKm() > maxKm).toList();
    }
}
