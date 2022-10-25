package fr.epu.vehicles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BatteryTest {
    private Battery battery;

    @BeforeEach
    void setUp() {
        battery = new Battery(50);
    }

    @Test
    void getCharge() {
        assertEquals(0, battery.getCharge());
    }

    @Test
    void charge() {
        battery.charge(10);
        assertEquals(10, battery.getCharge());
    }

    @Test
    void chargeMax() {
        battery.charge(60);
        assertEquals(50, battery.getCharge());
    }

    @Test
    void toStringTest() {
        System.out.println(battery.toString());
        assertTrue(true);
    }
}