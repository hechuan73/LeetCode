package Items;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses_20 {
    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        HashMap<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
        Stack<Character> leftChas = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) leftChas.push(s.charAt(i));
            else {
                if (!leftChas.empty() && map.get(leftChas.pop()).equals(s.charAt(i)));
                else return false;
            }
        }

        return leftChas.empty();
    }
}
