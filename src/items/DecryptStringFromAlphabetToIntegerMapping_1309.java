package items;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hechuan
 */
public class DecryptStringFromAlphabetToIntegerMapping_1309 {

    /**
     * Simple solution with String.split("#").
     *
     * @param s input string
     * @return the mapped alphabets
     */
    public String freqAlphabets1(String s) {
        char[] chars = new char[27];
        // in ASCLL table, 'a' is 97.
        for (int i = 1; i < chars.length; i++) {
            chars[i] = (char) (96+i);
        }

        StringBuilder res = new StringBuilder();
        String[] strings = s.split("#");
        String tmp;
        for (int i = 0; i < strings.length - 1; i++) {
            tmp = strings[i];
            for (int j = 0; j < tmp.length()-2; j++) {
                // in ASCLL table, '0' is 48.
                res.append(chars[tmp.charAt(j)-48]);
            }
            res.append(chars[Integer.parseInt(tmp.substring(tmp.length()-2))]);
        }

        // special handling for the last one.
        boolean flag = s.charAt(s.length()-1) == '#';
        tmp = strings[strings.length-1];
        if (flag) {
            for (int j = 0; j < tmp.length()-2; j++) { res.append(chars[tmp.charAt(j)-48]); }
            res.append(chars[Integer.parseInt(tmp.substring(tmp.length()-2))]);
        }
        else {
            for (int j = 0; j < tmp.length(); j++) { res.append(chars[tmp.charAt(j)-48]); }
        }

        return res.toString();
    }

    /**
     * Optimised solution with String.split("#").
     *
     * @param s input string
     * @return the mapped alphabets
     */
    public String freqAlphabets2(String s) {
        Map<String, Character> map = new HashMap<>();

        for (int i = 1; i < 27; i++) {
            if (i < 10) { map.put(i+"", (char) (96+i)); }
            else { map.put(i+"#", (char) (96+i)); }
        }

        StringBuilder res = new StringBuilder();
        int len = s.length();
        String key;
        for (int i = 0; i < len; i++) {
            if (i+3 <= len && map.containsKey(key = s.substring(i, i+3))) {
                res.append(map.get(key));
                i += 2;
            }
            else { res.append(map.get(s.charAt(i)+"")); }
        }

        return res.toString();
    }
}
