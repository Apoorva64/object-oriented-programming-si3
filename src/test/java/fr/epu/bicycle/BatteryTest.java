package fr.epu.bicycle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BatteryTest {
    private Battery battery;

    @BeforeEach
    void setUp() {
        battery = new Battery(50);
    }

    @Test
    void getCharge() {
        assertEquals(50, battery.getCharge());
    }

    @Test
    void charge() {
        battery.charge(10);
        assertEquals(60, battery.getCharge());
    }

    @Test
    void chargeMax() {
        battery.charge(60);
        assertEquals(100, battery.getCharge());
    }

    @Test
    void discharge() {
        battery.discharge(10);
        assertEquals(40, battery.getCharge());
    }

    @Test
    void dischargeMin() {
        battery.discharge(60);
        assertEquals(0, battery.getCharge());
    }


    @Test
    void setMaxCharge() {
        battery.setMaxCharge(200);
        assertEquals(200, battery.getMaxCharge());
    }

    @Test
    void getMaxCharge() {
        assertEquals(100, battery.getMaxCharge());
    }
}