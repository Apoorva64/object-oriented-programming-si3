package TD1.fr.epu.fleets;

import TD1.fr.epu.vehicles.Bike;
import TD1.fr.epu.vehicles.Position;
import TD1.fr.epu.vehicles.Station;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class FleetOfBike extends FleetOfTrackable<Bike> {
    Set<Station> stationAround(Position currentPosition, int maxKm) {
        return trackables.stream()
                .map(Bike::getStation)
                .filter(Optional::isPresent)
                .filter(station -> station.get().getPosition().distance(currentPosition) <= maxKm)
                .map(Optional::get)
                .collect(Collectors.toSet());
    }
}
