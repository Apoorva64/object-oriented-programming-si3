package TD1.fr.epu.fleets;

import TD1.fr.epu.vehicles.Position;
import TD1.fr.epu.vehicles.Trackable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FleetOfTrackable<T extends Trackable> {
    protected final ArrayList<T> trackables = new ArrayList<>();

    public int size() {
        return trackables.size();
    }

    public void add(T vehicle) {
        trackables.add(vehicle);
    }

    T get(int index) {
        return trackables.get(index);
    }

    void remove(int index) {
        trackables.remove(index);
    }

    void remove(T vehicle) {
        trackables.remove(vehicle);
    }

    void removeAll() {
        trackables.clear();
    }

    public List<Position> getPositions() {
        List<Position> positions = new ArrayList<>();
        for (T vehicle : trackables) {
            positions.add(vehicle.getPosition().orElse(null));
        }
        return positions;
    }

    public List<T> closeTo(Position position, double distance) {
        return trackables.stream()
                .filter(vehicle -> vehicle.getPosition().orElse(new Position(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY)).distance(position) <= distance)
                .toList();
    }

    List<T> around(Position position, double distance) {
        return closeTo(position, distance);
    }


    Optional<Trackable> getNearestTrackable(Position position) {
        return trackables.stream().map(Trackable.class::cast).min(
                Comparator.comparingDouble(vehicle ->
                        vehicle.getPosition()
                                .orElse(new Position(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY))
                                .distance(position)
                )
        );

    }

}
