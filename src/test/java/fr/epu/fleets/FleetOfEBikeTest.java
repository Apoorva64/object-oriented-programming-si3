package fr.epu.fleets;

import fr.epu.vehicles.EBike;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FleetOfEBikeTest {

    @Test
    void EBikesWithMileageOver() {
        FleetOfEBike fleetOfEBike = new FleetOfEBike();
        for (int i = 0; i < 100; i += 10) {
            EBike eBike = new EBike();
            eBike.addKm(i);
            fleetOfEBike.add(eBike);
        }
        assertEquals(9, fleetOfEBike.EBikesWithMileageOver(1).size());
    }
}