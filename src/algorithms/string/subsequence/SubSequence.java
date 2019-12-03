package algorithms.string.subsequence;

/**
 * @author hechuan
 */
public class SubSequence {

    /**
     * Validate whether the string is a subsequence of the root string.
     * 验证string字符串是否可以由root字符串中的字符以此组成，如：
     * 1. root = "abpcplea", str = "apple" -> true;
     * 2. root = "abpcplea", str = "monkey" -> false;
     *
     * "More details and follow-up question, see the file 'IsSubsequence_392' "
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
