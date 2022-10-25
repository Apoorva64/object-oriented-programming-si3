package fr.epu.vehicles;

import java.util.Optional;

public class Bike implements BorrowableTrackableItem {
    public Optional<Station> getStation() {
        if (station == null) {
            return Optional.empty();
        }
        return Optional.of(station);
    }

    private Station station;

    public Bike(Station station) {
        this.station = station;
    }

    @Override
    public boolean isBorrowable() {
        return station != null;
    }

    @Override
    public void borrow() {
        station.removeBike(this);
        station = null;

    }


    public void returnBike(Station station) {
        this.station = station;
        station.addBike(this);
    }

    @Override
    public void returnBorrowable() {
        throw new IllegalStateException("Use returnBike instead");
    }

    @Override
    public Optional<Position> getPosition() {
        return Optional.empty();
    }
}
