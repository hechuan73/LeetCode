package items;

/**
 * @author hechuan
 */
public class PowerOfFour_342 {

    /**
     * It's easy to find that power of 4 numbers have those 3 common features:
     * 1. greater than 0.
     * 2. only have one '1' bit in its binary notation, so we use x&(x-1) to delete the lowest '1', and if then it
     *    becomes 0, it proves that there is only one '1' bit.
     *
     * Note that: feature 1 and 2 can be used to check whether the number is the power of two.
     *
     * 3. The only '1' bit should be locate at the odd location. For example, 16. Its binary is 00010000. So we can use
     *    '0x55555555' -> (01010101010101010101010101010101) or '0xaaaaaaaa' -> (10101010101010101010101010101010)
     *    to check if the '1' bit is in the right place.
     *
     * @param num input number
     * @return whether the number is power of four.
     */
    public boolean isPowerOfFour(int num) {
        // return num > 0 && (num & (num-1)) == 0 && (num & 0xaaaaaaaa) == 0;
        return num > 0 && (num & (num-1)) == 0 && (num & 0x55555555) != 0;
    }
}
