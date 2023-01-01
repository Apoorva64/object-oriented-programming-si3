package TD7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MintermTest {
    @Test
    void testCreateMinterm() {
        //Test la construction d'un Minterm à partir d'un tableau via le toString
        Minterm minterm = new Minterm(1, 1, 0, 0, 1);
        assertEquals("11001", minterm.toString());
    }

    @Test
    void testCreateMinterm2() {
        //Test la construction d'un minterm
        //à partir d'un décimal et la taille de la représentation en base 2
        Minterm minterm = new Minterm(25, 5);
        assertEquals("11001", minterm.toString());

        minterm = new Minterm(8, 4);
        assertEquals("1000", minterm.toString());

        minterm = new Minterm(11, 4);
        assertEquals("1011", minterm.toString());
    }

    @Test
    void test3() {
        //Test a simple merge
        Minterm minterm1 = new Minterm(1, 1, 0, 0, 1);
        Minterm minterm2 = new Minterm(1, 1, 0, 0, 0);
        Minterm res = minterm1.merge(minterm2);
        assertTrue(minterm1.isMarked());
        assertTrue(minterm2.isMarked());
        assertFalse(res.isMarked());
        assertEquals("1100-", res.toString());
    }

    @Test
    void test4() {
        Minterm m = new Minterm(15, 4);
        assertEquals(0, m.numberOfZero());
        assertEquals(4, m.numberOfOne());
    }

    @Test
    void test5() {
        //Test Equals

        Minterm minterm1 = new Minterm(5, 3);
        Minterm minterm2 = new Minterm(5, 3);
        assertEquals(minterm1, minterm2);
        minterm1.mark();
        assertEquals(minterm1, minterm2);
    }

    @Test
    void test6(){
        assertEquals(1, Minterm.numberOfBitsNeeded(0));
        assertEquals(1, Minterm.numberOfBitsNeeded(1));
        assertEquals(2, Minterm.numberOfBitsNeeded(3));
        assertEquals(3, Minterm.numberOfBitsNeeded(6));
        assertEquals(4, Minterm.numberOfBitsNeeded(15));
    }
}