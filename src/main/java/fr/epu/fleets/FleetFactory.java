package fr.epu.fleets;

import fr.epu.vehicles.SupportedVehicles;

class FleetFactory {
    private FleetFactory() {
    }

    public static FleetOfTrackable<?> createFleetOfTrackable(SupportedVehicles supportedVehicles) {
        return switch (supportedVehicles) {
            case EBIKE -> new FleetOfEBike();
            case SCOOTER -> new FleetOfScooter();
            case BIKE -> new FleetOfBike();
            case UNICYCLE -> new FleetOfUnicycle();
        };
    }
}
