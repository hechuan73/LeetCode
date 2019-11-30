package algorithms.string.match;

/**
 * @author hechuan
 */
public class BruteForce {

    /**
     * Brute force to match.
     *
     * Time Complexity: O(m*n)
     * Space Complexity: O(1)
     *
     * @param root root string
     * @param pattern pattern string to be matched
     * @return the beginning index of in the root string if matched and first matched, otherwise return -1.
     */
    public static int match(String root, String pattern) {
        char[] rootChars = root.toCharArray();
        char[] patternChars = pattern.toCharArray();

        int j;
        // just need to check the length of the string in the root which is large than the pattern string.
        for (int i = 0; i <= rootChars.length-patternChars.length; i++) {
            for (j = 0; j < patternChars.length; j++) {
                if (rootChars[i+j] != patternChars[j]) { break; }
            }

            if (j == patternChars.length) { return i; }
        }

        return -1;
    }
}
