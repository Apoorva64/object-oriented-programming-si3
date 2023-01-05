package TD7;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryManager {
    private final int categories;
    private final List<Minterm> minterms;
    private final int bits;
    private boolean isLastTurn;


    /**
     * CategoryManager : compute the categories from a list of minterms according to the number of 11
     */
    public CategoryManager(List<Minterm> minterms, int bits) {
        this.categories = (int) minterms.stream().map(Minterm::numberOfOne).distinct().count();
        this.minterms = minterms;
        this.bits = bits;
        this.isLastTurn = false;
    }


    public int numberOfCategories() {
        return categories;
    }


    /**
     * @param numberOfOne
     * @return the Category Of Minterms containing  numberOfOne
     */
    public MintermCategory getCategory(int numberOfOne) {
        return minterms.stream().filter(e -> e.numberOfOne() == numberOfOne).collect(Collectors.toCollection(MintermCategory::new));
    }


    /**
     * isLastTurn()
     *
     * @return true is it's the last turn.
     */
    public boolean isLastTurn() {
        return isLastTurn;
    }

    /**
     * Merge the categories two by two if they have only one "one" between them.
     * The minterms are the result of the merging of the categories.
     * Be careful for a category of n "one", if the category of "n+1" has no minterms,
     * you must recover the minterms of the category of n "one" which were not marked.
     * This is the last round if no terms could be merged.
     *
     * @return the merged terms
     */
    public List<Minterm> mergeCategories() {
        List<Minterm> mergedMinterms = new ArrayList<>();
        boolean computed = false;
        for (int i = 0; i < bits; i++) {
            MintermCategory mintermCategory = getCategory(i);
            MintermCategory nextMintermCategory = getCategory(i + 1);
            if (mintermCategory.isEmpty() || nextMintermCategory.isEmpty()) {
                if (nextMintermCategory.isEmpty()) {
                    mergedMinterms.addAll(mintermCategory.stream().filter(e -> !e.isMarked()).collect(Collectors.toCollection(ArrayList::new)));
                }
                continue;
            }
            List<Minterm> merge = mintermCategory.merge(nextMintermCategory);
            if (merge != null) {
                computed = true;
                mergedMinterms.addAll(merge);
            }
        }

        if (!computed) {
            isLastTurn = true;
        }
        return mergedMinterms;
    }

}