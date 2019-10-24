package items;

import java.util.List;

/**
 * @author hechuan
 */
public class LongestWordInDictionaryThroughDeleting_524 {

    public String findLongestWord(String s, List<String> d) {
        String res = "";

        for (String str : d) {
            if (isSubSequence(str, s)) {
                if ((str.length() > res.length()) || (str.length() == res.length() && str.compareTo(res) < 0)) {
                    res = str;
                }
            }
        }

        return res;
    }

    /**
     * Method to validate whether the string is a subsequence of the root string.
     *
     * @param str string to check
     * @param root root string
     * @return whether the string is a subsequence of the root string.
     */
    private boolean isSubSequence(String str, String root) {
        int j = 0;
        for (int i = 0; i < root.length() && j < str.length(); i++) {
            if (str.charAt(j) == root.charAt(i)) { j++; }
        }
        return j == str.length();
    }
}
