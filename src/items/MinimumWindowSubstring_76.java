package items;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hechuan
 */
public class MinimumWindowSubstring_76 {

    /**
     * 采用双指针加HashMap，没有采用数组计数是因为当元素值为0时，无法怕断t中是否包含某个字符。
     * 从左到右依次便利，当[left, right]间的字符串包含t时，移动left，判断是否仍然包含，如果是，则更新最小窗口。
     * 注意：由于每次移动right，如果t中包含该字符，会-1，所以有可能出现map中该字符对应的值为负数。表示[left, right]间包含多个该字符。所以在
     * 移动left时，需要判断当[left, right]间不包含该字符时，才更新tLen。
     *
     * @param s input string s
     * @param t input string t
     * @return the minimum window
     */
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() < t.length() || s.length() == 0) { return "";}

        Map<Character, Integer> counter = new HashMap<>();
        for (char c : t.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        char[] sChars = s.toCharArray();
        int tLen = t.length(), sLen = s.length();
        int left = 0, right = 0, minWin = Integer.MAX_VALUE, minLeft = left;
        while (right < sLen) {
            if (counter.containsKey(sChars[right])) {
                counter.put(sChars[right], counter.get(sChars[right])-1);
                if (counter.get(sChars[right]) >= 0) {
                    tLen--;
                }

                while (tLen == 0 && left < right) {
                    if (right-left+1 < minWin) {
                        minWin = right-left+1;
                        minLeft = left;
                    }

                    if (counter.containsKey(sChars[left])) {
                        counter.put(sChars[left], counter.get(sChars[left])+1);
                        if (counter.get(sChars[left]) > 0) {
                            tLen++;
                        }
                    }

                    left++;
                }
            }
            right++;
        }

        return minWin > sLen ? "" : s.substring(minLeft, minLeft+minWin);
    }
}
