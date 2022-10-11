package fr.epu.bicycle;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FleetTest {
    private Fleet fleet;

    @BeforeEach
    void setUp() {
        fleet = new Fleet();
        fleet.addElectricVehicle(new EBike());

    }

    @AfterEach
    void tearDown() {
        fleet = null;
    }

    @Test
    void addElectricVehicle() {
        fleet.addElectricVehicle(new EBike());
        assertEquals(2, fleet.getNbElectricVehicles());
    }

    @Test
    void removeElectricVehicle() {
        fleet.removeElectricVehicle(fleet.getElectricVehicle(0));
        assertEquals(0, fleet.getNbElectricVehicles());
    }

    @Test
    void getNbElectricVehicles() {
        assertEquals(1, fleet.getNbElectricVehicles());
    }

    @Test
    void getElectricVehicle() {
        assertEquals(EBike.class, fleet.getElectricVehicle(0).getClass());
    }

    @Test
    void getElectricVehiclesAround() {
        assertEquals(1, fleet.getElectricVehiclesAround(new Position(0, 0), 10).size());
    }
}