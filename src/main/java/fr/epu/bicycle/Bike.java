package fr.epu.bicycle;

import java.util.Optional;

public class Bike implements Vehicle {
    private Station station;

    public Bike(Station station) {
        this.station = station;
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
