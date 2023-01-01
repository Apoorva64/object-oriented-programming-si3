package TD1.fr.epu.fleets;

import TD1.fr.epu.vehicles.Position;
import TD1.fr.epu.vehicles.SupportedVehicles;
import TD1.fr.epu.vehicles.Trackable;

import java.util.EnumMap;
import java.util.Optional;

public class Manager {

    EnumMap<SupportedVehicles, FleetOfTrackable<?>> fleets = new EnumMap<>(SupportedVehicles.class);

    Manager(SupportedVehicles... supportedVehicles) {
        for (SupportedVehicles supportedVehicle : supportedVehicles) {
            fleets.put(supportedVehicle, FleetFactory.createFleetOfTrackable(supportedVehicle));
        }
    }

    Optional<Trackable> getNearestTrackable(SupportedVehicles supportedVehicle, Position position) {
        var fleet = fleets.get(supportedVehicle);
        return fleet.getNearestTrackable(position);
    }
}