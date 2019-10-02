package items;

/**
 * @author hechuan
 */
public class LongestPalindrome_409 {

    /**
     * There are two case of the longest palindrome:
     * 1. all the letters appear even times, such as "abccba".
     * 2. all the letters appear even times except one letter appears odd time, such as "abcdcba".
     *
     * so we can record the numbers of the letters, and the number of the letters which appear odd times.
     * if no letters appear odd times, the result is times of all the letters which appear even times.
     * if there are letters appear odd times, the result is 1 plus the times of all the letters which appear even times.
     * @param s input string
     * @return the length of longest palindrome
     */
    public int longestPalindrome(String s) {
        int[] counter = new int[128];

        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i)]++;
        }

        int res = 0, oddCount = 0;
        for (int i : counter) {
            if (i != 0) {
                // letters appear even times.
                if (i % 2 == 0) { res += i; }
                else { // letters appear even times.
                    res += (i-1);
                    ++oddCount;
                }
            }
        }

        return oddCount == 0 ? res : res+1;
    }
}
