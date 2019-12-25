package items;

/**
 * @author hechuan
 */
public class NumberComplement_476 {

    /**
     * Mathematical method:
     * for example:
     * 100110, its complement is 011001, the sum is 111111. So we only need get the min number large or equal to num,
     * then do subtraction.
     *
     * @param num input number
     * @return the complement number of num.
     */
    public int findComplement1(int num) {
        int n = 0, m =0;
        while (n < num) {
            n += Math.pow(2, m++);
        }

        return n-num;
    }

    /**
     * Same idea with last method but using the bit operation instead of power calculation.
     *
     * @param num input number
     * @return the complement number of num.
     */
    public int findComplement2(int num) {
        int n = 0;
        while (n < num) {
            n = (n << 1) | 1;
        }

        return n - num;
    }

    /**
     * Bit operation.
     *
     * @param num input number
     * @return the complement number of num.
     */
    public int findComplement3(int num) {
        return ~num & ((Integer.highestOneBit(num) << 1) - 1);
    }
}
