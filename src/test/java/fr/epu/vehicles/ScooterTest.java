package fr.epu.vehicles;

import TD1.fr.epu.vehicles.Battery;
import TD1.fr.epu.vehicles.GPS;
import TD1.fr.epu.vehicles.Scooter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ScooterTest {

    @Test
    void test() {
        Scooter scooter = new Scooter(new Battery(50), 50, new GPS());
        assertEquals(50, scooter.getMaxSpeed());
    }


}