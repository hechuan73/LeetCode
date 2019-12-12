package items;

/**
 * @author hechuan
 */
public class OnesAndZeroes_474 {

    /**
     * Simple dp solution. dp[i][j] means when use i's 0 and j's i, the maximum amount form.
     * So dp[i][j] = Math.max(dp[i][j], 1+ dp[i-zero][j-one]), zero and one means the amount of 0 and 1 of the
     * current string.
     *
     * @param strs input strings array
     * @param m amount of 0
     * @param n amount of 1
     * @return the max from
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        int zero, one;
        for (String str : strs) {
            // count the amount of '0' and '1'。
            zero = 0; one = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') { zero++; }
                else { one++; }
            }
            for (int i = m; i >= zero; i--) {
                for (int j = n; j >= one; j--) {
                    // dp status transition equation
                    dp[i][j] = Math.max(dp[i][j], 1+ dp[i-zero][j-one]);
                }
            }
        }

        return dp[m][n];
    }
}
