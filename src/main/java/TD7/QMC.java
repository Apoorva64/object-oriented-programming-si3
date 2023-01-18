package TD7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QMC {
    private CategoryManager categoryManager;
    private final int bits;
    private final int[] values;

    /**
     * Initialize the algorithm
     *
     * @param values decimals
     */
    public QMC(int... values) {
        this.values = values;
        bits = Minterm.numberOfBitsNeeded(Arrays.stream(values).max().orElseThrow());
        ArrayList<Minterm> minterms = Arrays.stream(values).mapToObj(value -> new Minterm(value, bits)).collect(Collectors.toCollection(ArrayList::new));
        categoryManager = new CategoryManager(minterms, bits);
    }

    /**
     * Calculates and returns the necessary and sufficient minterms.
     */
    public List<Minterm> computePrimeImplicants() {
        List<Minterm> minterms = new ArrayList<>();
        while (true) {
            List<Minterm> merged = categoryManager.mergeCategories();
            if (categoryManager.isLastTurn()) break;

            minterms = merged;
            categoryManager = new CategoryManager(minterms, bits);
        }
        PrimeImplicantChart primeImplicantChart = new PrimeImplicantChart(values, minterms);
        List<Minterm> out = primeImplicantChart.extractEssentialPrimeImplicants();
        out.addAll(primeImplicantChart.extractRemainingImplicants());
        return out;
    }


}
