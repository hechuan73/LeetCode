package items;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hechuan
 */
public class IsSubsequence_392 {

    /**
     * Basic solution.
     *
     * Time complexity: O(n) n is the length of the root string.
     * Space complexity: O(1)
     *
     * @param s string to check
     * @param t root string
     * @return whether the string is a subsequence of the root string.
     */
    public boolean isSubsequence1(String s, String t) {
        int len = 0;
        for (int i = 0; i < t.length() && len < s.length(); i++) {
            if (s.charAt(len) == t.charAt(i)) { len++; }
        }
        return len == s.length();
    }

    /**
     * Search based the last character index in the root string, same as the last one (isSubsequence1), but it seems
     * faster, i dont know why.
     *
     * Time complexity: O(n) n is the length of the root string.
     * Space complexity: O(1)
     *
     * @param s string to check
     * @param t root string
     * @return whether the string is a subsequence of the root string.
     */
    public boolean isSubsequence2(String s, String t) {
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            index = t.indexOf(s.charAt(i), index+1);
            if (index == -1) { return false; }
        }

        return true;
    }

    /**
     * For follow-up question.
     *
     * 由于s的数量非常多，如果我们每次都去逐位比较，耗时较长，所以我们考虑使用变成二维表来缓存字符串t中所有字符出现的位置。由于匹配来某个字符后，
     * 下一个字符在t中的位置，必须在当前字符之后，我们不必线性查询，通过缓存的字符出现的所有位置，我们可以在某个字符出现的位置中，使用二分查询，
     * 来快速找到在上一个字符位置后，t中是否有当前字符。举个例子：
     *
     * Now we cached the index of characters in the string T. The prev variable is an index where previous character was
     * picked from the sequence. And for the next character to be picked, you have to select it only after this index is
     * the string 'T'.
     *
     * For instance, if S = "abcd" and T = "abdced".
     * The index list mapping looks like:
     * a -> 0
     * b -> 1
     * c -> 3
     * d -> 2,5
     * e -> 4
     *
     * After you pick a, and b, c will be picked, and index is 3. Now if you have to pick d, you can't pick index 2
     * because c was picked at 3, so you have to binary search for index which comes after 3. So it returns 5.
     *
     * Time complexity:
     *     preprocess: O(n), n is the length of the root string.
     *     each validation: O(mlogk), m is the length of string s, k is the average existing times of each character in
     *                      string t.
     *
     * Space complexity: O(n)
     *
     * @param s string to check
     * @param t root string
     * @return whether the string is a subsequence of the root string.
     */
    public boolean isSubsequence3(String s, String t) {
        List<Integer>[] chaIndexes = new List[256];

        // init the character indexes cache.
        for (int i = 0; i < t.length(); i++) {
            if (chaIndexes[t.charAt(i)] == null) { chaIndexes[t.charAt(i)] = new ArrayList<>(); }
            chaIndexes[t.charAt(i)].add(i);
        }

        int prevIndex = 0, currIndex;
        for (int i = 0; i < s.length(); i++) {
            if (chaIndexes[s.charAt(i)] == null) { return false; }
            currIndex = Collections.binarySearch(chaIndexes[s.charAt(i)], prevIndex);
            // there is no target value which is equal to the index 'prevIndex', so we calculate its insertion index.
            if (currIndex < 0) { currIndex = -currIndex-1; }
            // the value 'prevIndex' will be insert to the last, which means no target indexes which are equal to or
            // behind of the index value 'prevIndex'.
            if (currIndex == chaIndexes[s.charAt(i)].size()) { return false; }
            // set the prevIndex to the next one of the target index we find now.
            prevIndex = chaIndexes[s.charAt(i)].get(currIndex) + 1;
        }

        return true;
    }

}
