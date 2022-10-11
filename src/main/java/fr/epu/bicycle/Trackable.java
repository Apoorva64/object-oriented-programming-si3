package fr.epu.bicycle;

import java.util.Optional;

public interface Trackable {
    /**
     * Returns the position of the vehicle.
     *
     * @return the position
     */
    Optional<Position> getPosition();
}
