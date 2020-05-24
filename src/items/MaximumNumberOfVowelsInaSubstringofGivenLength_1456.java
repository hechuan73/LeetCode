package items;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hechuan
 */
public class MaximumNumberOfVowelsInaSubstringofGivenLength_1456 {

    public int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int res = 0, count = 0;
        int start = 0, end = 0;
        while (start <= end && end < s.length()) {
            if (vowels.contains(s.charAt(end))) {
                count++;
            }

            if (end-start+1 == k) {
                res = Math.max(res, count);
                if (vowels.contains(s.charAt(start))) { count--; }
                start++;
            }
            end++;
        }

        return res;
    }
}
