package items;

/**
 * @author hechuan
 */
public class CountNumbersWithUniqueDigits_357 {

    /**
     * Simple dp solution with mathematical combination in digits range [0, 9]. For example:
     * n = 1, res = C(1, 10) = 10,
     * n = 2, res = C(1, 10) + C(1, 9) * C(1, 9) = 91. If number has one digit, there is ten solutions. If number has
     * two digits, the first digit can not be 0, so it is C(1, 9), the other digit can be the one of nine numbers, so it
     * is also C(1, 9).
     * n = 3, res = C(1, 10) + C(1, 9) * C(1, 9) + C(1, 9) * C(1, 9) * C(1, 8)
     * ...
     * dp[i] = dp[i-1] + C(1, 9) * C(1, 9) * C(1, 9) * C(1, 8) ... C(1, 10-n+1) (n >= 2)
     *
     * @param n input n
     * @return the amount of numbers with unique digits
     */
    public int countNumbersWithUniqueDigits1(int n) {
        if (n == 0) { return 1; }
        int res = 10, mul = 9;
        for (int i = 1; i < n; i++) {
            // (10 - i) is available digits.
            mul *= 10-i;
            res += mul;
        }

        return res;
    }

    /**
     * Backtracking solution.
     *
     * @param n input n
     * @return the amount of numbers with unique digits
     */
    public static int countNumbersWithUniqueDigits(int n) {
        int res = 0;
        if (n == 0) { return 1; }
        boolean[] visited = new boolean[10];
        // result of n is make up by the result of (n-1)/(n-2)/.../1 which represent the numbers with n/n-1/...2/1 digits.
        res += countNumbersWithUniqueDigits(n-1);
        // the first digit can not be 0, so we calculate it separately.
        for (int i = 1; i < 10; i++) {
            visited[i] = true;
            res += backtracking(n-1, visited);
            visited[i] = false;
        }

        return res;
    }

    private static int backtracking(int n,  boolean[] visited) {
        if (n == 0) { return 1; }

        int res = 0;
        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                visited[i] = true;
                res += backtracking(n-1, visited);
                visited[i] = false;
            }
        }

        return res;
    }
}
