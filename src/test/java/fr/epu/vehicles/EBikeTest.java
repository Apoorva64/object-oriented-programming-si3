package fr.epu.vehicles;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EBikeTest {
    private EBike bike;


    @Test
    void testCreateEBike() {
        assertEquals(EBike.INITIAL_DISTANCE, bike.getKm());
    }

    @Test
    void testAddKm() {
        int value = 5;
        bike.addKm(value);
        assertEquals(value + EBike.INITIAL_DISTANCE, bike.getKm());
    }

    @Test
    void testAddNegativeKm() {
        int value = -5;
        assertThrows(IllegalArgumentException.class, () -> bike.addKm(value));
    }

    @Test
    void testGetCharge() {
        assertEquals(EBike.INITIAL_CHARGE, bike.getCharge());
    }

    @Test
    void testGetPosition() {

        assertEquals(new Position(0, 0), bike.getPosition().orElseThrow());
    }


    @BeforeEach
    void setUp() {
        bike = new EBike();
    }

    @AfterEach
    void tearDown() {
        bike = null;
    }

    @Test
    void toStringTest() {
        System.out.println(bike.toString());
        assertTrue(true);

    }

}