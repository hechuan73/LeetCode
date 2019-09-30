package items;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInaString_387 {

    public int firstUniqChar1(String s) {
        int[] counter = new int[26];

        for (char c : s.toCharArray()) { counter[c-'a']++; }

        for (int i = 0; i < s.length(); i++) {
            if (counter[s.charAt(i)-'a'] == 1) {return i; }
        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        Map<Character, Integer> characterIndex = new HashMap<>(s.length());

        for (char c : s.toCharArray()) {
            characterIndex.put(c, characterIndex.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (characterIndex.get(s.charAt(i)) == 1) {return i; }
        }
        return -1;
    }
}
