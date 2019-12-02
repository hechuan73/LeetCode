package items;

/**
 * @author hechuan
 */
public class CountingBits_338 {

    /**
     * 思路：
     * 对于奇数，它总是比它小1的偶数的二进制表示多一个1，比如3：11，2：10。
     * 对于偶数，它二进制表示中1的个数总是等于它左移一位的数的二进制表示中1的个数，因为偶数的二进制表示中最后一位为0。
     *
     * 同时0的二进制表示1的个数为0，所以可以进行动态规划。
     * Tip：判断一个数为奇偶数，可以将它与1相与，为0则为偶数，为1则为奇数。
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n) to store result
     *
     * @param num input number
     * @return the counting bits of 1's in the binary representation of numbers which are less than or equal to the num.
     */
    public int[] countBits1(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & 1) == 0) { res[i] = res[i>>1]; }
            else { res[i] = res[i-1] + 1; }
        }

        return res;
    }

    /**
     * 思路：
     * 通过判断最低有效位来判断。思路和上面的奇偶判断法类似。
     * 对于x   = (1001011101)[2进制] = (605)[10进制]
     *    x/2 = (100101110)[2进制] = (302)[10进制]
     * ​可以发现只有最后一位不同，x/2可以看作是x移除最低有效位的结果。
     *
     * 所以状态转移函数：P(x) = P(x/2) + (x mod 2)。 (x & 1) 可以用于判断奇偶数。
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n) to store result
     *
     * @param num input number
     * @return the counting bits of 1's in the binary representation of numbers which are less than or equal to the num.
     */
    public int[] countBits2(int num) {
        int[] res = new int[num+1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i>>1] + (i & 1);
        }

        return res;
    }


    /**
     * Function popCount() is used to calculate the the number of nonzero bit of a number. So traverse the range[0, num]
     *
     * Time Complexity: O(nk), k is the bits of the number in the range.
     * Space Complexity: O(n) to store result
     *
     * @param num input number
     * @return the counting bits of 1's in the binary representation of numbers which are less than or equal to the num.
     */
    public int[] countBits3(int num) {
        int[] res = new int[num+1];
        for (int i = 0; i <= num; i++) {
            res[0] = popCount(i);
        }

        return res;
    }

    /**
     * Calculate the number of nonzero bit in the binary of representation of input number.
     *
     * @param x input x
     * @return the number of 1 in the binary representation of x.
     */
    private int popCount(int x) {
        int res = 0;
        while (x != 0) {
            //zeroing out the least significant nonzero bit
            x &= x - 1;
            res++;
        }

        return res;
    }
}
