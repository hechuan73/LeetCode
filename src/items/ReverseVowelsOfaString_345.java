package items;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author hechuan
 */
public class ReverseVowelsOfaString_345 {

    /**
     * Using array to reduce the looking up time to O(1).
     *
     * @param s input string
     * @return reversed string
     */
    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = s.length()-1;
        boolean[] vowels = new boolean[256];
        vowels['a'] = true;
        vowels['e'] = true;
        vowels['i'] = true;
        vowels['o'] = true;
        vowels['u'] = true;
        vowels['A'] = true;
        vowels['E'] = true;
        vowels['I'] = true;
        vowels['O'] = true;
        vowels['U'] = true;

        while (left < right) {
            while (left < right && !vowels[chars[left]]) {++left; }
            while (left < right && !vowels[chars[right]]) {--right; }
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            ++left;
            --right;

        }

        return new String(chars);
    }

    /**
     * Using hash set to reduce the looking up time to O(1).
     *
     * @param s the input string
     * @return the reversed string
     */
    public static String reverseVowels2(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = s.length()-1;
        HashSet<Character> vowels = new HashSet<>(
                Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        while (left < right) {
            while (left < right && !vowels.contains(chars[left])) {++left; }
            while (left < right && !vowels.contains(chars[right])) {--right; }
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            ++left;
            --right;

        }

        return new String(chars);
    }
}
