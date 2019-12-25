package items;

/**
 * @author hechuan
 */
public class HammingDistance_461 {

    /**
     * Get the last bit of the two numbers and compare them.
     * (x & 1) can get the last bit of x.
     *
     * @param x input value
     * @param y input value
     * @return the hamming distance of the two values
     */
    public int hammingDistance1(int x, int y) {
        int res = 0;
        while (x != 0 || y != 0) {
            if ((x & 1) != (y & 1)) { res++; }
            x = (x >> 1);
            y = (y >> 1);
        }

        return res;
    }

    /**
     * Integer.bitCount(x) is used to count the number of one's in the binary representation of x.
     * @param x input value
     * @param y input value
     * @return the hamming distance of the two values
     */
    public int hammingDistance2(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
