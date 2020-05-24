package items;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hechuan
 */
public class RearrangeWordsInaSentence_1451 {

    public String arrangeWords(String text) {
        List<String>[] counter = new List[100001];

        String[] words = text.split(" ");
        int len = words[0].length();
        counter[len] = new ArrayList<>();
        counter[len].add(words[0].toLowerCase());


        for (int i = 1; i < words.length; i++) {
            len = words[i].length();
            if (counter[len] == null) { counter[len] = new ArrayList<>(); }
            counter[len].add(words[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (List<String> strs : counter) {
            if (strs != null && !strs.isEmpty()) {
                for (String str : strs) {
                    sb.append(str).append(" ");
                }
            }
        }

        sb.deleteCharAt(sb.length()-1);
        sb.replace(0, 1, String.valueOf(Character.toUpperCase(sb.charAt(0))));
        return sb.toString();
    }
}
