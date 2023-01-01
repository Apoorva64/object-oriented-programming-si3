package fr.epu.fleets;

import TD1.fr.epu.fleets.Fleet;
import TD1.fr.epu.vehicles.EBike;
import TD1.fr.epu.vehicles.Position;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FleetTest {
    private Fleet<EBike> fleet;

    @BeforeEach
    void setUp() {
        fleet = new Fleet<>();

    }

    @AfterEach
    void tearDown() {
        fleet = null;
    }

    @Test
    void testAddBike() {
        fleet.add(new EBike());
        assertEquals(1, fleet.size());
    }

    @Test
    void testGetVehiclesAroundAPosition() {
        fleet.add(new EBike());
        fleet.add(new EBike());
        fleet.add(new EBike());
        assertEquals(3, fleet.closeTo(new Position(0, 0), 5).size());
    }

    @Test
    void evaluateTime4around() {
        long totalTime = 0;
        for (int i = 0; i < 10; i++) {
            // add random vehicles
            for (int j = 0; j < 10; j++) {
                fleet.add(new EBike());
            }
        }
        Position currentPosition = new Position(7, 7);
        for (int i = 0; i < 1000; i++) {
            long startTime = System.nanoTime();
            fleet.closeTo(currentPosition, 10);
            long endTime = System.nanoTime();
            long durationInNano = (endTime - startTime);  //Total execution time in nano seconds
            totalTime += durationInNano;
        }
        System.out.println("total time in nano : " + totalTime);
        System.out.println("total time in milli : " + TimeUnit.NANOSECONDS.toMillis(totalTime));
    }

}