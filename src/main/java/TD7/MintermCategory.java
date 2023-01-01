package TD7;

import java.util.ArrayList;
import java.util.List;

public class MintermCategory extends ArrayList<Minterm> {


    /**
     * It computes the list of minterms m, such that :
     * - either m results from  merging a minterm from the category "this" with a minterm from the other category ;
     * - either m belongs to the current category (this) and could not be unified with a minterm of the other category
     *
     * @param otherCategory
     * @return the list of merged minterms
     */
    public List<Minterm> merge(MintermCategory otherCategory) {
        List<Minterm> res = new ArrayList<>();
        for (Minterm m1 : this) {
            for (Minterm m2 : otherCategory) {
                Minterm m = m1.merge(m2);
                if (m != null) {
                    res.add(m);
                }
            }
        }
        return res;
    }

}