package items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hechuan
 */
public class FindCommonCharacters_1002 {

    public List<String> commonChars(String[] A) {
        int[] counter = new int[26];
        Arrays.fill(counter, Integer.MAX_VALUE);

        for (String s : A) {
            int[] chars = new int[26];
            for (char c : s.toCharArray()) {
                chars[c-'a']++;
            }

            for (int i = 0; i < counter.length; i++) {
                counter[i] = Math.min(counter[i], chars[i]);
            }
        }

        List<String> res = new ArrayList<>();
        for (char i = 'a'; i <= 'z' ; i++) {
            while (counter[i-'a']-- > 0) {
                res.add(i + "");
            }
        }

        return res;
    }
}
