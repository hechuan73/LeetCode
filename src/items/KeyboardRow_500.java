package items;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author hechuan
 */
public class KeyboardRow_500 {

    /**
     * Using JDK 8 Stream API, while it is two slow.
     *
     * @param words input array
     * @return target strings array
     */
    public String[] findWords1(String[] words) {
        return Stream
                .of(words)
                .filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*"))
                .toArray(String[]::new);
    }

    /**
     * Using array instead of map to decrease the execution time.
     *
     * @param words input array
     * @return target strings array
     */
    public static String[] findWords2(String[] words) {
        int[] lettersRow = new int[26];
        // the first row;
        lettersRow['q'-'a'] = 1; lettersRow['w'-'a'] = 1; lettersRow['e'-'a'] = 1; lettersRow['r'-'a'] = 1; lettersRow['t'-'a'] = 1;
        lettersRow['y'-'a'] = 1; lettersRow['u'-'a'] = 1; lettersRow['i'-'a'] = 1; lettersRow['o'-'a'] = 1; lettersRow['p'-'a'] = 1;
        // the second row;
        lettersRow['a'-'a'] = 2; lettersRow['s'-'a'] = 2; lettersRow['d'-'a'] = 2; lettersRow['f'-'a'] = 2; lettersRow['g'-'a'] = 2;
        lettersRow['h'-'a'] = 2; lettersRow['j'-'a'] = 2; lettersRow['k'-'a'] = 2; lettersRow['l'-'a'] = 2;
        // the third row;
        lettersRow['z'-'a'] = 3; lettersRow['x'-'a'] = 3; lettersRow['c'-'a'] = 3; lettersRow['v'-'a'] = 3;
        lettersRow['b'-'a'] = 3; lettersRow['n'-'a'] = 3; lettersRow['m'-'a'] = 3;

        List<String> res = new ArrayList<>(words.length);
        for (String word : words) {
            boolean flag = true;
            int row = lettersRow[word.toLowerCase().charAt(0)-'a'];
            for (char c : word.toLowerCase().toCharArray()) {
                if (lettersRow[c-'a'] != row) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.add(word); }
        }

        return res.toArray(new String[0]);
    }
}
