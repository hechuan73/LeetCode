package items;

/**
 * This problem can be broken into subproblems. There are two ways to reach the i^th step:
 *     1. Taking a single step from (i-1)^th step.
 *     2. Taking a step of 2 from (i-2)^th step.
 *
 * So, the total number of ways to reach i^th is equal to sum of ways of reaching (i-1)^th step and ways of reaching
 * (i-2)^th step. Let dp[i] denotes the number of ways to reach on i^th step:
 *     dp[i] = dp[i-1] + dp[i-2]
 *
 * We can see it's a Fibonacci problem. So the solution is clear.
 */
public class ClimbStairs_70 {


    /**
     * Solution 1 : iteration to get the result.
     * Time complexity: O(n).
     * Space complexity：O(1).
     *
     * @param n the total step of the stair.
     * @return the options to climb the stair.
     */
    public static int climbStairs1(int n) {

        int first = 1, second =2;
        for (int i = 3; i < n - 2; i++) {
            int third = first + second;
            first = second;
            second = third;
        }

        return second;
    }

    /**
     * Use the Fibonacci formula:
     *
     *     Fn = 1/Math.sqrt(5) * [((1 + Math.sqrt(5)) / 2)^(n+1)) - ((1 - Math.sqrt(5)) / 2)^(n+1))].
     *
     * Time complexity: O(log(n)).
     * Space complexity：O(1).
     *
     * @param n the total step of the stair.
     * @return the options to climb the stair.
     */
    public static int climbStairs2(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5)/2, n+1) - Math.pow((1 - sqrt5)/2, n+1);
        return (int) (fibn/sqrt5);
    }

}
