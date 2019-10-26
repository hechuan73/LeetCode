package algorithms.string;

/**
 * @author hechuan
 */
public class SubSequence {

    /**
     * Validate whether the string is a subsequence of the root string.
     *
     * @param str string to check
     * @param root root string
     * @return whether the string is a subsequence of the root string.
     */
    public boolean isSubsequence(String str, String root) {
        int j = 0;
        for (int i = 0; i < root.length() && j < str.length(); i++) {
            if (str.charAt(j) == root.charAt(i)) { j++; }
        }

        return j == str.length();
    }
}
