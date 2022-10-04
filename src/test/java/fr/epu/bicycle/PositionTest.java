package fr.epu.bicycle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    private Position position1;
    private Position position2;

    @Test
    void testEquals() {
        assertEquals(position1, position2);
    }

    @Test
    void testHashCode() {
        assertEquals(position1.hashCode(), position2.hashCode());
    }

    @Test
    void getX() {
        assertEquals(0, position1.getX());
    }

    @Test
    void getY() {
        assertEquals(0, position1.getY());
    }

    @Test
    void setX() {
        position1.setX(10);
        assertEquals(10, position1.getX());
    }

    @Test
    void setY() {
        position1.setY(10);
        assertEquals(10, position1.getY());
    }

    @BeforeEach
    void setUp() {
        position1 = new Position(0, 0);
        position2 = new Position(0, 0);
    }

    @Test
    void toStringTest() {
        System.out.println(position1.toString());
        assertTrue(true);

    }
}