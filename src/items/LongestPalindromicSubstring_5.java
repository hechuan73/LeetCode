package items;

/**
 * @author hechuan
 */
public class LongestPalindromicSubstring_5 {

    /**
     * Approach: Expand Around Center
     *
     * We observe that a palindrome mirrors around its center. Therefore, a palindrome can be expanded from its center,
     * and there are only 2n - 1 such centers.
     *
     * why there are 2n - 1 but not nn centers? The reason is the center of a palindrome can be in between two letters.
     * Such palindromes have even number of letters (such as "abba") and its center are between the two 'b's.
     *
     * Time Complexity: O(n2)
     * Space Complexity: O(1)
     *
     * @param s input string
     * @return the longest palindrome
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) { return s; }

        int left = 0, right = 0;
        int lenOdd, lenEven, len;
        for (int i = 0; i < s.length(); i++) {
            lenOdd = expandAround(s, i, i);
            lenEven = expandAround(s, i, i+1);
            len = Math.max(lenOdd, lenEven);
            if (len > right - left) {
                left = i - (len-1)/2;
                right = i + len/2;
            }
        }

        return s.substring(left, right+1);
    }

    private int expandAround(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }

        return right-left-1;
    }
}
