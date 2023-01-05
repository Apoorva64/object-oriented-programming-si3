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
        ArrayList<Minterm> merge = new ArrayList<>();
        for (int i = 0; i < this.size(); i++) {
            Minterm minterm = this.get(i);
            for (int j = 0; j < otherCategory.size(); j++) {
                Minterm otherMinterm = otherCategory.get(j);
                Minterm tempMerge = minterm.merge(otherMinterm);
                if (tempMerge != null && !merge.contains(tempMerge)) {
                    merge.add(tempMerge);
                    this.set(i, minterm);
                    otherCategory.set(j, otherMinterm);
                }
            }
        }

        this.stream().filter(minterm -> !minterm.isMarked() && !merge.contains(minterm)).forEach(merge::add);

        return merge;
    }

}