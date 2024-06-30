package items;

/**
 * @author hechuan
 */
public class CountDifferentPalindromicSubsequences730 {

    public int countPalindromicSubsequences(String S) {
        int n = S.length();
        long[][] dp = new long[n][n];

        long max;
        for (int i = n-1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < n; j++) {
                max = Math.max(dp[i+1][j-1], Math.max(dp[i][j-1], dp[i+1][j]));
                dp[i][j] = S.charAt(i) == S.charAt(j) ? max+1 : max;
            }
        }

        return (int) dp[0][n-1] % 1000000007;
    }
}
