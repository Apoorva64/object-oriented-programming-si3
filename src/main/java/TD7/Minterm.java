package TD7;

import java.util.*;
import java.util.stream.Collectors;

public class Minterm {
    private ArrayList<Integer> minterms;
    private boolean isMark;
    private int numberOfBits;
    /**
     *
     * @param decimal   the decimal number for which we want to calculate the number of bits necessary to represent it
     * @return          the minimum number of bits needed to encode this decimal in binary.
     */
    public static int numberOfBitsNeeded(int decimal) {
        return Integer.toBinaryString(decimal).length();
    }

    /*********************************************************
     * Management of the minterms structure
     ******************************************************** */


    /**
     * returns all the numbers that were used to build this minterm.
     * For example, [0*00] may have been created from 0 and 2 (* = -1)
     * @return all the numbers that were used to build this minterm.
     */
    public Collection<Integer> getCombinations() {
        HashSet<Integer> res = new HashSet<>();

        if(!minterms.contains(-1)){
            res.add(toIntValue());
        }

        for(int i=0;i<minterms.size();i++){
            if(minterms.get(i) == -1){
                ArrayList<Integer> copy = new ArrayList<>(minterms);
                int []bits = new int[copy.size()];
                int []bits2 = new int[copy.size()];
                for(int j=0;j<bits.length;j++) {
                    if (i == j) {
                        bits[j] = 0;
                        bits2[j] = 1;
                    } else {
                        bits[j] = minterms.get(j);
                        bits2[j] = minterms.get(j);
                    }
                }

                Minterm iter = new Minterm(bits);
                res.addAll(iter.getCombinations());
                Minterm iter2 = new Minterm(bits2);
                res.addAll(iter2.getCombinations());
            }
        }
        return res;
    }



    /**
     * marks the minterm as used to build another minTerm
     */
    public void mark(){
        isMark=true;
    }

    /**
     *
     * @return true if the minterm has been used to build another minterm, false otherwise.
     */
    public boolean isMarked(){
        return isMark;
    }

    /*********************************************************
     * Management of the minterms contents
     ******************************************************** */
    /**
     *
     * @return return the number of 0 in the minterm
     */
    public int numberOfZero() {
        return (int) minterms.stream().filter(e -> e==0).count();
    }

    /**
     *
     * @return return the number of 1 in the minterm
     */
    public int numberOfOne() {
        return (int) minterms.stream().filter(e -> e==1).count();
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
        return Objects.equals(minterm.minterms,minterms);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(new int[]{isMark ? 0 : 1, minterms.hashCode()});
    }



/* -------------------------------------------------------------------------
        Constructors
 ------------------------------------------------------------------------- */
    /**
     * Construct a minterm corresponding to the decimal passed in parameter
     * and encode it on the given number of bits.
     * The associated combination then contains decimal.
     * @param decimal       the decimal value representing the minterm
     * @param numberOfBits  the number of bits of encoding of the decimal
     */
    public Minterm(int decimal, int numberOfBits) {
        minterms = new ArrayList<>();
        String temp=Integer.toBinaryString(decimal);
        for(char c : temp.toCharArray()){
            if(c=='0'){
                minterms.add(0);
            }else{
                minterms.add(1);
            }
        }

        if(numberOfBits!=minterms.size()){
            int decalage=Math.abs(minterms.size()-numberOfBits);
            for(int i=0;i<decalage;i++){
                minterms.add(0, 0);
            }
        }

        this.numberOfBits = numberOfBits;
        isMark=false;
    }


    /**
     * Builds a minterm from its representation in binary which can contain -1.
     * This constructor does not update the associated combinations.
     * The size of the binary representation corresponds to the number of parameters (binary.length).
     * @param binary
     */
    protected Minterm(int... binary) {
        minterms = new ArrayList<>();
        for(int e : binary){
            minterms.add(e);
        }
        isMark=false;
        numberOfBits=binary.length;
    }



    /**
     * Compute the string showing the binary form of the minterm.
     * For example, "101" represents the minterm corresponding to 5,
     * while "1-1" represents a minterm resulting, for example from the merge of 5 and 7 (1 -1 1)
     * @return the string
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i : minterms){
            if(i==-1){
                stringBuilder.append("-");
            }else{
                stringBuilder.append(i);
            }
        }

        return stringBuilder.toString();
    }



/* -------------------------------------------------------------------------
        Binary <-> Decimal
 ------------------------------------------------------------------------- */

    /**
     * Calculates the integer value of the binary representation.
     * But in case one of the binary elements is -1, it returns -1.
     * This method is private because it should not be used outside this class.
     * @returns the value of the minterm calculated from its binary representation.
     */
    public int toIntValue(){
        if(minterms.contains(-1)) return -1;
        String value=minterms.stream().map(Object::toString)
                .collect(Collectors.joining(""));
        return Integer.parseInt(value,2);
    }


   /* -------------------------------------------------------------------------
        Merge
 ------------------------------------------------------------------------- */


    /**
     * create a Minterm from the merge of two Minterms when it is posssible otherwise return null
     * Attention two minterms can only be merged if
     *  - they differ by one value at most.
     *  - they are of the same size.
     *  If a merge is possible, the returned minterm
     *  - has the same binary representation as the original minterm, but where at most one slot has been replaced by -1,
     *  - and it has, for the combinations, the merge of the combinations of both minterms this and other)
     *  - and the both mindterms  this and other are marked
     * @param other is another Minterm which we try to unify
     * @return a new Minterm when it is possible to unify, else null * @param other is another Minterm which we try to merge
     * @return a new Minterm when it is possible to merge, else null
     */
    public Minterm merge(Minterm other) {
        int diff=Math.abs(numberOfZero()-other.numberOfZero());
        if(diff!=1) return null;
        if(numberOfBits!= other.numberOfBits) return null;
        int []bits = new int[numberOfBits];
        int change=0;

        for(int i=0;i<minterms.size();i++){
            if(!Objects.equals(minterms.get(i), other.minterms.get(i))){
                if(minterms.get(i)==-1 || other.minterms.get(i) == -1){
                    return null;
                }
                bits[i] = -1;
                change++;
            }else{
                bits[i] = minterms.get(i);
            }
        }

        if(change>1) return null;
        mark();
        other.mark();
        return new Minterm(bits);
    }

}
