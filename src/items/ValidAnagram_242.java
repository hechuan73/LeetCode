package items;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram_242 {

    /**
     * Time complexity: O(nlogn)
     * space complexity: O(1) : the two char array is already used to save the two strings, so do not calculate them.
     *     And if use heap-sort to sort the arrays, the space complexity is O(1).
     *
     * Note: adapt to unicode characters.
     * @param s input array
     * @param t input array
     * @return result
     */
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) { return false;}

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return Arrays.equals(sArr, tArr);
    }

    /**
     * Time complexity: O(n)
     * space complexity: O(1)
     *
     * Note: do not adapt to unicode characters.
     *
     * @param s input array
     * @param t input array
     * @return result
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) { return false;}

        int[] counter = new int[26];

        for (int i = 0; i < s.length(); i++) { counter[s.charAt(i)-'a']++; }

        for (int i = 0; i < t.length(); i++) {
            counter[t.charAt(i)-'a']--;
            /* 检查counter元素值是否小于0。因为两个数组长度相同，如果每个字符的数量不同，则会出现一个字符数量多，而另一个字符数量小，如s有3个
             * 字符a，两个字符b；t有两个字符a，三个字符b。则在检查到字符b时，counter的元素值会小于0，即数量不相同。所以可以直接返回。
             */
            if (counter[t.charAt(i)-'a'] < 0) {return false;}
        }

        return true;
    }

    /**
     * Time complexity: O(n)
     * space complexity: O(1)
     *
     * Note: adapt to unicode characters.
     *
     * @param s input array
     * @param t input array
     * @return result
     */
    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) { return false; }

        Map<Character, Integer> counter = new HashMap<>();

        for (int i = 0; i < s.length(); i++) { counter.put(s.charAt(i), counter.getOrDefault(s.charAt(i), 0)+1); }

        for (int i = 0; i < t.length(); i++) {
            counter.put(t.charAt(i), counter.getOrDefault(t.charAt(i), 0)-1);
            if (counter.get(t.charAt(i)) < 0) { return false;}
        }

        return true;
    }
}
