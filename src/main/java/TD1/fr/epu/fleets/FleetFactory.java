package TD1.fr.epu.fleets;

import TD1.fr.epu.vehicles.SupportedVehicles;

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
