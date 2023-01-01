package fr.epu.vehicles;

import TD1.fr.epu.vehicles.GPS;
import TD1.fr.epu.vehicles.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GPSTest {
    private GPS gps;

    @Test
    void move() {
        gps.move(10, 10);
        assertEquals(new Position(10, 10), gps.getPosition());
    }

    @Test
    void getPosition() {
        assertEquals(new Position(0, 0), gps.getPosition());

    }

    @BeforeEach
    void setUp() {
        gps = new GPS();

    }

    @Test
    void toStringTest() {
        System.out.println(gps.toString());
        assertTrue(true);

    }
}