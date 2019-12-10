package items;

/**
 * @author hechuan
 */
public class ArithmeticSlices_413 {

    /**
     * Approach: 找规律。这道题如果需要效率快，那么必然是需要一个O(n)的算法，暴力法不考虑。这道题主要是需要找到其规律，从小的例子出发,仔细观
     * 察，会发现当整个数组为(1, 2, 3, 4, 5, 6)的时候，我们先取出前三个，(1, 2, 3)的等差数列的个数为1，(1, 2, 3, 4)的等差数列的个数为3，
     * (1, 2, 3, 4, 5)的等差数列的个数为6，(1, 2, 3, 4, 5, 6)的等差数列个数为10，以此类推我们可以很容易的发现在一个等差数列中加入一个数
     * 字，如果还保持着等差数列的特性，每次的增量都会加1，如果刚加进来的数字与原先的序列构不成等差数列，就将增量置为0。
     *
     * 1 -> 0
     * 2 -> 0
     * 3 -> 0+1=1
     * 4 -> 1+2=3
     * 5 -> 3+3=6
     * 6 -> 6+4=10
     *
     * @param A input array
     * @return the number of arithmetic slices
     */
    public int numberOfArithmeticSlices(int[] A) {
        int res = 0, add = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i-1] == A[i-1] - A[i-2]) {
                res += ++add;
            }
            else { add = 0; }
        }

        return res;
    }


    /**
     * DP method. 将找规律中的累加过程，映射到dp数组中即可。
     *
     * @param A input array
     * @return the number of arithmetic slices
     */
    public int numberOfArithmeticSlices2(int[] A) {
        int[] dp = new int[A.length];
        int res = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i-1] == A[i-1] - A[i-2]) {
                dp[i] = dp[i-1] + 1;
                res += dp[i];
            }
        }
        return res;
    }
}
