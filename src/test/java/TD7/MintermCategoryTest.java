package TD7;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MintermCategoryTest {
    @Test
    void test1() {
        //Merge Categories of only one elements
        MintermCategory m0Class = new MintermCategory();
        Minterm m0 = new Minterm(0, 4);
        m0Class.add(m0);
        MintermCategory m1Class = new MintermCategory();
        Minterm m1 = new Minterm(1, 4);
        m1Class.add(m1);
        List<Minterm> res = m1Class.merge(m0Class);
        assertTrue(res.contains(new Minterm(0, 0, 0, -1)));
        assertTrue(m0.isMarked());
        assertTrue(m1.isMarked());
        Collection<Integer> combinations = res.get(0).getCombinations();
        assertTrue(combinations.contains(0));
        assertTrue(combinations.contains(1));
    }

    @Test
    void test2() {
        //merge not possible
        MintermCategory mclass = new MintermCategory();
        Minterm m1 = new Minterm(-1, 1, 0);
        mclass.add(m1);
        Minterm m2 = new Minterm(1, -1, 0);
        mclass.add(m2);

        MintermCategory m2class = new MintermCategory();
        m2class.add(new Minterm(0, 0, -1));

        List<Minterm> res = mclass.merge(m2class);
        assertEquals(2, res.size());
        assertTrue(res.contains(m1));
        assertTrue(res.contains(m2));


        m2class = new MintermCategory();
        m1 = new Minterm(0, 0, -1);
        m2class.add(m1);
        mclass = new MintermCategory();
        mclass.add(new Minterm(-1, 1, 0));
        mclass.add(new Minterm(1, -1, 0));
        res = m2class.merge(mclass);
        assertEquals(1, res.size());
        assertTrue(res.contains(m1));
        assertFalse(res.contains(m2));
    }

}