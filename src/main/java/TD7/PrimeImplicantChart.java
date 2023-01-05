package TD7;

import java.util.*;
import java.util.stream.Collectors;

public class PrimeImplicantChart {

    private final Map<Minterm, Map<Integer, Boolean>> mintermMap;
    private final int[] values;

    /**
     * Initializes the grid with the original minterms and values.
     *
     * @param values      Initial decimal values (they are also included in the combinations of minterms).
     * @param mintermList The list of minterms reduced by merging the categories
     */
    public PrimeImplicantChart(int[] values, List<Minterm> mintermList) {
        this.mintermMap = new HashMap<>();
        mintermList.forEach(minterm -> Arrays.stream(values).forEach(value -> insertIntoMap(minterm, value, minterm.getCombinations().contains(value))));
        this.values = values;
    }

    /**
     * extracts only the essential minterms; they correspond to the minterms that are the only ones to represent one of the initial values.
     *
     * @return essential minterm list
     */
    public List<Minterm> extractEssentialPrimeImplicants() {
        return mintermMap.entrySet().stream().filter(e -> Arrays.stream(values).anyMatch(value -> Boolean.TRUE.equals(e.getValue().get(value)) && countValue(value) == 1)).map(Map.Entry::getKey).collect(Collectors.toList());
    }


    /**
     * After removing the initial values covered by the essential minterms,
     * choose a minterm for each remaining value not covered by an essential minterm.
     */
    public List<Minterm> extractRemainingImplicants() {
        List<Minterm> primeImplicants = extractEssentialPrimeImplicants();
        final ArrayList<Integer> checkValues = new ArrayList<>();
        primeImplicants.forEach(primary -> {
            for (int value : values) {
                if (mintermMap.get(primary).get(value)) {
                    checkValues.add(value);
                }
            }
        });
        return mintermMap.entrySet().stream().filter(e -> {
            if (!primeImplicants.contains(e.getKey())) {
                Map<Integer, Boolean> row = e.getValue();
                long r = row.entrySet().stream().filter(v -> {
                    if (!checkValues.contains(v.getKey())) {
                        checkValues.add(v.getKey());
                        return true;
                    }
                    return false;
                }).count();
                return r > 0;
            }
            return false;
        }).map(Map.Entry::getKey).collect(Collectors.toList());

    }

    private void insertIntoMap(Minterm row, Integer column, boolean value) {
        Map<Integer, Boolean> map;
        if (mintermMap.containsKey(row)) {
            map = mintermMap.get(row);
        } else {
            map = new HashMap<>();
            mintermMap.put(row, map);
        }

        map.put(column, value);

        mintermMap.put(row, map);
    }


    private int countValue(int value) {
        return (int) mintermMap.entrySet().stream().filter(e -> e.getValue().get(value)).count();
    }

}
