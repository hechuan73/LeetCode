package items;

/**
 * @author hechuan
 */
public class LongestRepeatingCharacterReplacement_424 {

    /**
     * 这里我们使用滑动窗口的思路：
     * 1. 使用窗口来记录最大的重复字符数量；
     * 2. 使用counter表，来记录在窗口中出现的字符的次数；
     * 3. 每次新加入字符到窗口时，判断一下该字符是不是窗口中出现次数最多的字符，保存在maxLen中；
     * 4. 当窗口长度-最多字符串数 >= k时，表示需要替换的次数多于k次，所以窗口需要缩小，即左边的指针右移一位；
     * 5. 使用当前窗口长度，更新最长重复字符数量，然后右边的指针右移。
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @param s input string
     * @param k replacement times
     * @return the length of the longest repeating characters.
     */
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0, res = 0;
        // 128 to save all characters, here can be optimize to 26.
        int[] counter = new int[128];
        int maxLen = 0;
        while (right < s.length()) {
            counter[s.charAt(right)]++;
            maxLen = Math.max(maxLen, counter[s.charAt(right)]);
            // the while can be replaced by if statement as every time we go one step.
            while (right-left+1-maxLen > k) {
                --counter[s.charAt(left++)];
            }

            res = Math.max(res, right-left+1);
            right++;
        }

        return res;
    }
}
