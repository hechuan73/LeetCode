package items;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hechuan
 */
public class OccurrencesAfterBigram_1078 {

    public String[] findOccurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> res = new ArrayList<>();
        for (int i = 2; i < words.length; i++) {
            if (first.equals(words[i-2]) && second.equals(words[i-1])) { res.add(words[i]); }
        }

        return res.toArray(new String[0]);
    }
}
