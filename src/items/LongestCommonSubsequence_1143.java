package items;

/**
 * @author hechuan
 */
public class LongestCommonSubsequence_1143 {

    /**
     * Simple dp with 2-D.
     *
     * @param text1 input string1
     * @param text2 input string2
     * @return the length of longest common subsequence of the two strings
     */
    public int longestCommonSubsequence1(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        // dp[i][j]表示text1中第0~i个字符与text2中第0~j个字符中最长的公共子串长度
        int[][] dp = new int[m][n];
        dp[0][0] = text1.charAt(0) == text2.charAt(0) ? 1 : 0;
        for (int i = 1; i < m; i++) {
            if (text1.charAt(i) == text2.charAt(0)) { dp[i][0] = 1; }
            else { dp[i][0] = dp[i-1][0]; }
        }

        for (int i = 1; i < n; i++) {
            if (text2.charAt(i) == text1.charAt(0)) { dp[0][i] = 1; }
            else { dp[0][i] = dp[0][i-1]; }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[m-1][n-1];
    }

    /**
     * Optimised dp with 1-D.
     * prev: 表示是当前dp[j](dp[i][j])左上角的数，相当于dp[i-1][j-1], 初始化的时候为0
     * tmp: 表示是当前dp[j](dp[i][j])正上方的数，相当于dp[i- 1][j]
     * dp[j-1]: 表示是当前dp[j](dp[i][j])左边的数，相当于dp[i][j-1]
     * 每一轮结束后，prev的值都向前滚动一个，变成正上方的数，也就是tmp
     *
     * @param text1 input string1
     * @param text2 input string2
     * @return the length of longest common subsequence of the two strings
     */
    public int longestCommonSubsequence2(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[] dp = new int[n+1];

        int prev, tmp;
        for (int i = 1; i <= m; i++) {
            prev = 0;
            for (int j = 1; j <= n; j++) {
                tmp = dp[j];
                if (text1.charAt(i-1) == text1.charAt(j-1)) {
                    dp[j] = prev+1;
                }
                else {
                    dp[j] = Math.max(dp[j], dp[j-1]);
                }

                prev = tmp;
            }
        }

        return dp[n];
    }
}
