package items;

public class ArrangingCoins_441 {

    /**
     * Approach: it is a arithmetic progression formed by every row coins:
     *     1, 2, 3, ... n.
     * S(x) = (x * (x + 1)) / 2, and we need S(x) <= n  ==>  x = 0.5 * (Math.sqrt(8.0 * n + 1) - 1). The negative root
     * is ignored.
     *
     * @param n input number
     * @return the total number of full staircase rows that can be formed.
     */
    public int arrangeCoins(int n) {
        return (int) (0.5 * (Math.sqrt(8.0 * n + 1) - 1));
    }
}
