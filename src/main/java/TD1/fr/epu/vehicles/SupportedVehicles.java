package TD1.fr.epu.vehicles;

public enum SupportedVehicles {
    EBIKE(EBike.class),
    SCOOTER(Scooter.class),
    BIKE(Bike.class),
    UNICYCLE(Unicycle.class);

    private final Class<? extends Trackable> trackableClass;

    SupportedVehicles(Class<? extends Trackable> trackableClass) {
        this.trackableClass = trackableClass;
    }

    public Class<? extends Trackable> getTrackableClass() {
        return trackableClass;
    }
}
