package items;

/**
 * @author hechuan
 */
public class RegularExpressionMatching_10 {

    /**
     * Simple solution with backtracking.
     *
     * @param s input string to match
     * @param p pattern string
     * @return whether the pattern string can match the input string
     */
    public boolean isMatch1(String s, String p) {
        return isMatch(s, s.length(), 0, p, p.length(), 0);
    }

    private boolean isMatch(String s, int sLen, int sIdx, String p, int pLen, int pIdx) {
        if (sIdx == sLen && pIdx == pLen) { return true; }
        if (sIdx != sLen && pIdx == pLen) { return false; }

        // we should consider whether the next char in pattern is '*' as two cases:
        if (pIdx + 1 < pLen && p.charAt(pIdx+1) == '*') {
            if (sIdx < sLen) {
                if (p.charAt(pIdx) == '.') {
                    // for str: "abba", pattern = "a.*a" and  str: "aa", pattern = "a.*a".
                    return isMatch(s, sLen, sIdx+1, p, pLen, pIdx)
                            || isMatch(s, sLen, sIdx, p, pLen, pIdx+2);
                }
                else {
                    if (p.charAt(pIdx) == s.charAt(sIdx)) {
                        // for str: "aab", pattern = "a*a" and  str: "aa", pattern = "a*a".
                        return isMatch(s, sLen, sIdx+1, p, pLen, pIdx)
                                || isMatch(s, sLen, sIdx, p, pLen, pIdx+2);
                    }

                    return isMatch(s, sLen, sIdx, p, pLen, pIdx+2);
                }


            }
            // for pattern[patternIndex+1] == '*', such as['.', '*'], but str = [].
            return isMatch(s, sLen, sIdx, p, pLen, pIdx+2);
        }

        if (sIdx < sLen && (p.charAt(pIdx) == s.charAt(sIdx) || p.charAt(pIdx) == '.')) {
            return isMatch(s, sLen, sIdx+1, p, pLen, pIdx+1);
        }

        return false;
    }


    /**
     * Optimised solution with DP.
     * dp[i][j]表示 s的第一个字符到第i个字符 与 p的第一个字符到第j个字符 能否匹配。
     * 1, If p.charAt(j-1) == s.charAt(i-1) : 表示s的第i个字符和p的第j个字符能匹配，则看它们的上一个字符能否匹配。
     *       dp[i][j] = dp[i-1][j-1];
     * 2, If p.charAt(j-1) == '.' : 表示p的第j个字符为'.'，可以匹配任意字符，则看它们的上一个字符能否匹配。
     *       dp[i][j] = dp[i-1][j-1];
     * 3, If p.charAt(j-1) == '*' : 表示p的第j个字符为'*'，需要看它们之前的字符是否匹配，有两种情况:
     *    1) if p.charAt(j-2) != s.charAt(i-1) or p.charAt(i-1) != '.' : 表示p的第j-1个字符和s的第i个字符不相等。
     *       dp[i][j] = dp[i][j-2];  // in this case, "a*" only counts as empty
     *    2) if p.charAt(j-1) == s.charAt(i) or p.charAt(i-1) == '.': 表示p的第j-1个字符和s的第i个字符相等或者p的第j-1个字符为
     *                                                                '.'，可以匹配任意字符，则：
     *       dp[i][j] = dp[i-1][j]   // in this case, a* counts as multiple a -> p.charAt(j-2) == s.charAt(i-1)
     *    or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a -> p.charAt(j-2) != s.charAt(i)
     *                                                                          && p.charAt(j-1) == '.'
     *    or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty -> p.charAt(j-2) != s.charAt(i)
     *                                                                          && p.charAt(j-1) != '.'
     *
     * @param s input string to match
     * @param p pattern string
     * @return whether the pattern string can match the input string
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) { return false; }

        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;

        // init the case of s = "" and the p != "".
        // no need to init the case s != "" and p == "", the default value is false.
        for (int i = 1; i < dp[0].length; i++) {
            if (p.charAt(i-1) == '*') {
                dp[0][i] = dp[0][i - 1] || dp[0][i - 2];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }

                if (p.charAt(j-1) == '*') {
                    if (s.charAt(i-1) != p.charAt(j-2) && p.charAt(j-2) != '.') {
                        dp[i][j] = dp[i][j-2];
                    }
                    else {
                        dp[i][j] = dp[i][j-1] || dp[i-1][j] || dp[i][j-2];
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }

}
