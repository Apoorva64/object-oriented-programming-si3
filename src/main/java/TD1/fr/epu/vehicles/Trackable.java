package TD1.fr.epu.vehicles;

import java.util.Optional;

public interface Trackable {
    /**
     * Returns the position of the vehicle.
     *
     * @return the position
     */
    Optional<Position> getPosition();
}
