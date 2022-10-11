package fr.epu.bicycle;

import java.util.ArrayList;
import java.util.List;

public class Station {
    private final ArrayList<Bike> bikes = new ArrayList<>();

    public void addBike(Bike bike) {
        bikes.add(bike);
    }

    public void removeBike(Bike bike) {
        bikes.remove(bike);
    }

    public int getNbBikes() {
        return bikes.size();
    }

    public List<Bike> getBikes() {
        return bikes;
    }
    public boolean hasBike(Bike bike) {
        return bikes.contains(bike);
    }
}
