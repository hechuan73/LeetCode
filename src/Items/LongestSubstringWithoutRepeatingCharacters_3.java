package Items;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters_3 {
    public static int lengthOfLongestSubstring(String s) {

        int length = s.length(), result = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0, left = 0; right < length; right++) {
            if (map.containsKey(s.charAt(right)))
                left = Math.max(left, map.get(s.charAt(right)) + 1);

            map.put(s.charAt(right), right);
            result = Math.max(result, right - left +1);
        }

        return result;
    }

    /*
        if (s.length() == 0) return 0;
        StringBuilder builder = new StringBuilder();
        int largestLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (builder.toString().contains(s.charAt(i) + "")) {
                largestLength = Math.max(builder.length(), largestLength);
                builder.delete(0, builder.indexOf(s.charAt(i) + "") + 1);
                builder.append(s.charAt(i));
            }
            else builder.append(s.charAt(i));
        }

        return Math.max(builder.length(), largestLength);
 */
}
