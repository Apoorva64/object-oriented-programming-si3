package fr.epu.bicycle;

import java.util.ArrayList;
import java.util.List;

public class Fleet {
    private final ArrayList<Trackable> vehicles = new ArrayList<>();

    int numberOfVehicles() {
        return vehicles.size();
    }

    void addVehicle(Trackable vehicle) {
        vehicles.add(vehicle);
    }

    Trackable getVehicle(int index) {
        return vehicles.get(index);
    }

    void removeVehicle(int index) {
        vehicles.remove(index);
    }

    void removeVehicle(Trackable vehicle) {
        vehicles.remove(vehicle);
    }

    void removeAllVehicles() {
        vehicles.clear();
    }

    List<Trackable> getVehiclesAround(Position position, double radius) {
        return vehicles.stream()
                .filter(vehicle -> vehicle.getPosition().orElse(new Position(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY)).distance(position) <= radius)
                .toList();
    }

}
