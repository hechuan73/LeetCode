package items;

import java.util.Arrays;

/**
 * @author hechuan
 */
public class FindWordsThatCanBeFormedByCharacters_1160 {

    public int countCharacters(String[] words, String chars) {
        int[] counter = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            counter[chars.charAt(i)-'a']++;
        }

        int res = 0, length, index;
        for (String word : words) {
            int[] tmp = Arrays.copyOf(counter, counter.length);
            length = 0;
            for (int i = 0; i < word.length(); i++) {
                index = word.charAt(i) - 'a';
                if (tmp[index] > 0) {
                    tmp[index]--;
                    length++;
                }
                else { break; }
            }
            if (length == word.length()) { res += length; }
        }

        return res;
    }
}
