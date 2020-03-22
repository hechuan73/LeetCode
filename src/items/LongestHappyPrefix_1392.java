package items;

/**
 * @author hechuan
 */
public class LongestHappyPrefix_1392 {


    /**
     * Simple solution with Brute-Force algorithm.
     * Time limit exceeded!!! ==> transform the string to char array and it will be a little fast and can AC.
     *
     * Time Complexity: O(n2)
     *
     * @param s input string
     * @return the longest happy prefix
     */
    public String longestPrefix1(String s) {
        int len = s.length();
        String res = "";
        int index;

        for (int i = len-2; i >= 0; i--) {
            index = len-1;
            int j = i;
            for (; j >= 0; j--) {
                if (s.charAt(j) != s.charAt(index--)) { break; }
            }
            if (j == -1) {
                return s.substring(0, i+1);
            }
        }

        return res;
    }


    /**
     * Optimised solution with Rabin-Karp algorithm.
     * Note that the variable may overflow, so use long type and mod.
     *
     * Time Complexity: O(n)
     *
     * @param s input string
     * @return the longest happy prefix
     */
    public String longestPrefix2(String s) {
        long prefixHash = 0, suffixHash = 0;
        long power = 1, mod = 1000000007;
        int len = s.length();
        long res = 0;
        for (int i = 0; i < len-1; i++) {
            prefixHash = (prefixHash*26 + s.charAt(i) - 'a') % mod;
            suffixHash = (suffixHash + power * (s.charAt(len-i-1) - 'a')) % mod;
            if (prefixHash == suffixHash) {
                res = i + 1;
            }
            power = power*26 % mod;
        }

        return s.substring(0, (int) res);
    }

}
