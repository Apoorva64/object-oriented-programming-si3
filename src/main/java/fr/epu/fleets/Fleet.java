package fr.epu.fleets;

import fr.epu.vehicles.BorrowableTrackableItem;
import fr.epu.vehicles.Position;

import java.util.List;

public class Fleet<T extends BorrowableTrackableItem> extends FleetOfTrackable<T> {

    @Override
    List<T> around(Position position, double distance) {
        return closeTo(position, distance).stream().filter(BorrowableTrackableItem::isBorrowable).toList();
    }
}
