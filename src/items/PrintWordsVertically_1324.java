package items;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hechuan
 */
public class PrintWordsVertically_1324 {

    /**
     * Simple solution.
     *
     * @param s input string
     * @return the vertical string list
     */
    public List<String> printVertically(String s) {
        String[] words = s.split(" ");
        int maxLen = 0;
        for (String word : words) {
            maxLen = Math.max(maxLen, word.length());
        }

        List<String> res = new ArrayList<>();
        StringBuilder sb;
        int len;
        for (int i = 0; i < maxLen; i++) {
            sb = new StringBuilder();
            for (String word : words) {
                sb.append(i < word.length() ? word.charAt(i) : ' ');
            }

            // remove the extra spaces at the last of the string.
            len = sb.length();
            int j = len-1;
            for (; j > 0; j--) { if (sb.charAt(j) != ' ') { break; } }
            sb.delete(j+1, len);

            res.add(sb.toString());
        }

        return res;
    }
}
