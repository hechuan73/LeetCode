package items;

/**
 * @author hechuan
 */
public class TwoKeysKeyboard_650 {

    /**
     * Simple dp: for integer n, we can find its factor, then copy the factor one time and paste some times to get n "A".
     * For example:
     * n = 2: to get AA from A we need 2 additional steps (copy-all and then paste)
     * n = 3: to get AAA from A we need 3 additional steps (copy-all, then paste, then again paste)
     * n = 4: to get AAAA we need 2 additional steps from AA.
     * ...
     *
     * so if the factor is (n/k) for n, we need to copy from (n/k) "A", and paste (k - 1) time, so total steps are k.
     *
     * @param n input n
     * @return the minimum step to get n "A".
     */
    public int minSteps1(int n) {
        int[] dp = new int[n+1];

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    dp[i] = dp[i/j] + j;
                    break;
                }
            }
        }

        return dp[n];
    }

    /**
     * Optimised dp:
     * 1. We look for a divisor d so that we can make d copies of (n / d) to get n
     * 2. The process of making d copies takes d steps (1 step of Copy All and d - 1 steps of Paste)
     * 3. We keep reducing the problem to a smaller one in a loop.
     * 4. The best cases occur when n is decreasing fast, and method is almost O(log(n))
     *
     * For example, when n = 1024 then n will be divided by 2 for only 10 iterations, which is much faster than O(n) DP
     * method.
     *
     * The worst cases occur when n is some multiple of large prime, e.g. n = 997 but such cases are rare.
     *
     * @param n input n
     * @return the minimum step to get n "A".
     */
    public int minSteps2(int n) {
        int res = 0;

        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                res += i;
                n /= i;
            }
        }

        return res;
    }

    /**
     * Super dp based on the second method. Optimised the case if original n is prime or n changing to prime in the
     * calculation process.
     *
     * @param n input n
     * @return the minimum step to get n "A".
     */
    public int minSteps3(int n) {
        int res = 0;

        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                res += i;
                n /= i;
            }
        }

        return n == 1 ? res : res + n;
    }
}
