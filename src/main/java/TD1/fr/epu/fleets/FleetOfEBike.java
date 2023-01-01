package TD1.fr.epu.fleets;

import TD1.fr.epu.vehicles.EBike;

import java.util.List;

public class FleetOfEBike extends Fleet<EBike> {
    public List<EBike> EBikesWithMileageOver(int maxKm) {
        return trackables.stream().filter(eBike -> eBike.getKm() > maxKm).toList();
    }
}
