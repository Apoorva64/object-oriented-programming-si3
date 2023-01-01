package TD7;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class Minterm {
    private HashSet<Integer> combinations;
    private Boolean isMarked;
    private int[] minterm;


    /**
     * @param decimal the decimal number for which we want to calculate the number of bits necessary to represent it
     * @return the minimum number of bits needed to encode this decimal in binary.
     */
    public static int numberOfBitsNeeded(int decimal) {
        if (decimal == 0) {
            return 1;
        }
        int numberOfBits = 0;
        while (decimal > 0) {
            decimal = decimal >> 1;
            numberOfBits++;
        }
        return numberOfBits;

    }

    /*********************************************************
     * Management of the minterms structure
     ******************************************************** */


    /**
     * returns all the numbers that were used to build this minterm.
     * For example, [0*00] may have been created from 0 and 2 (* = -1)
     *
     * @return all the numbers that were used to build this minterm.
     */
    public HashSet<Integer> getCombinations() {
        return combinations;
    }


    /**
     * marks the minterm as used to build another minTerm
     */
    public void mark() {
        isMarked = true;
    }

    /**
     * @return true if the minterm has been used to build another minterm, false otherwise.
     */
    public boolean isMarked() {
        return isMarked;
    }

    /*********************************************************
     * Management of the minterms contents
     ******************************************************** */
    /**
     * @return return the number of 0 in the minterm
     */
    public int numberOfZero() {
        return (int) Arrays.stream(minterm).filter(i -> i == 0).count();
    }

    /**
     * @return return the number of 1 in the minterm
     */
    public int numberOfOne() {
        return (int) Arrays.stream(minterm).filter(i -> i == 1).count();
    }


    /*********************************************************
     * Equality
     ******************************************************** */

    /**
     * @param o
     * @return true if the representation in base 2 is the same. Ignore the other elements.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Minterm minterm = (Minterm) o;
        return Arrays.equals(this.minterm, minterm.minterm);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(minterm);
    }



/* -------------------------------------------------------------------------
        Constructors
 ------------------------------------------------------------------------- */

    /**
     * Construct a minterm corresponding to the decimal passed in parameter
     * and encode it on the given number of bits.
     * The associated combination then contains decimal.
     *
     * @param decimal      the decimal value representing the minterm
     * @param numberOfBits the number of bits of encoding of the decimal
     */
    public Minterm(int decimal, int numberOfBits) {
        this.minterm = new int[numberOfBits];
        this.combinations = new HashSet<>();
        this.combinations.add(decimal);
        this.isMarked = false;
        for (int i = numberOfBits - 1; i >= 0; i--) {
            if (decimal % 2 == 0) {
                this.minterm[i] = 0;
            } else {
                this.minterm[i] = 1;
            }
            decimal = decimal >> 1;
        }
    }


    /**
     * Builds a minterm from its representation in binary which can contain -1.
     * This constructor does not update the associated combinations.
     * The size of the binary representation corresponds to the number of parameters (binary.length).
     *
     * @param binary
     */
    protected Minterm(int... binary) {
        this.minterm = binary;
        this.combinations = new HashSet<>();
        this.isMarked = false;
    }


    /**
     * Compute the string showing the binary form of the minterm.
     * For example, "101" represents the minterm corresponding to 5,
     * while "1-1" represents a minterm resulting, for example from the merge of 5 and 7 (1 -1 1)
     *
     * @return the string
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i : minterm) {
            if (i == -1) {
                sb.append("-");
            } else {
                sb.append(i);
            }
        }
        return sb.toString();
    }



/* -------------------------------------------------------------------------
        Binary <-> Decimal
 ------------------------------------------------------------------------- */

    /**
     * Calculates the integer value of the binary representation.
     * But in case one of the binary elements is -1, it returns -1.
     * This method is private because it should not be used outside this class.
     *
     * @returns the value of the minterm calculated from its binary representation.
     */
    public int toIntValue() {
        int result = 0;
        for (int i = 0; i < minterm.length; i++) {
            if (minterm[i] == -1) {
                return -1;
            }
            result = result * 2 + minterm[i];
        }
        return result;
    }


   /* -------------------------------------------------------------------------
        Merge
 ------------------------------------------------------------------------- */


    /**
     * create a Minterm from the merge of two Minterms when it is posssible otherwise return null
     * Attention two minterms can only be merged if
     * - they differ by one value at most.
     * - they are of the same size.
     * If a merge is possible, the returned minterm
     * - has the same binary representation as the original minterm, but where at most one slot has been replaced by -1,
     * - and it has, for the combinations, the merge of the combinations of both minterms this and other)
     * - and the both mindterms  this and other are marked
     *
     * @param other is another Minterm which we try to unify
     * @return a new Minterm when it is possible to unify, else null * @param other is another Minterm which we try to merge
     * @return a new Minterm when it is possible to merge, else null
     */
    public Minterm merge(Minterm other) {
        if (this.minterm.length != other.minterm.length) {
            return null;
        }
        int[] newMinterm = new int[this.minterm.length];
        int numberOfDifferences = 0;
        for (int i = 0; i < this.minterm.length; i++) {
            if (this.minterm[i] == other.minterm[i]) {
                newMinterm[i] = this.minterm[i];
            } else {
                newMinterm[i] = -1;
                numberOfDifferences++;
            }
        }
        if (numberOfDifferences > 1) {
            return null;
        }
        Minterm result = new Minterm(newMinterm);
        result.combinations.addAll(this.combinations);
        result.combinations.addAll(other.combinations);
        this.mark();
        other.mark();
        return result;
    }

}