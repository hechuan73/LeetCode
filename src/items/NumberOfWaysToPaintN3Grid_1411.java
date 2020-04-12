package items;

/**
 * @author hechuan
 */
public class NumberOfWaysToPaintN3Grid_1411 {

    /**
     * Classic dynamic programming problem.
     *
     * Explanation:
     * Two patterns for each row 121 and 123:
     * We consider the state of the first row,
     * Two colors pattern 121: 121, 131, 212, 232, 313, 323.
     * Three colors pattern 123: 123, 132, 213, 231, 312, 321.
     * So we initialize a121 = 6, a123 = 6.
     *
     * We consider the next possible for each pattern:
     * Two colors pattern 121 can be followed by: 212, 213, 232, 312, 313
     * Three colors pattern 123 can be followed by: 212, 231, 312, 232
     *
     * 121 => three 121, two 123
     * 123 => two 121, two 123
     *
     * So we can write this dynamic programming transform equations:
     * b121 = a121 * 3 + a123 * 2
     * b123 = a121 * 2 + a123 * 2
     *
     * We calculate the result iteratively
     * and finally return the sum of both pattern a121 + a123
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param n input number
     * @return the number of painting ways
     */
    public int numOfWays(int n) {
        long a121 = 6, a123 = 6, b121, b123,  mod = (long) 1e9+7;
        for (int i = 1; i < n; i++) {
            b121 = 3 * a121 + 2 * a123;
            b123 = 2 * a121 + 2 * a123;
            a121 = b121 % mod;
            a123 = b123 % mod;
        }

        return (int) ((a121 + a123) % mod);
    }
}
