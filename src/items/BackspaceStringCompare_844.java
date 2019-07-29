package items;

import java.util.Stack;

/**
 * There are two approaches for this problem.
 *
 * Approach 1: Use two stack, store the bits of the string, when we meet '#', do popping, else do pushing.
 * Time complexity: O(m+n)
 * Space complexity: O(n)
 *
 * Approach 2: Traverse the string in reverse order. When we meet '#', we need to back or skip the next character. We
 * count the times of '#' in variables 'sBackSpace' and 'tBackSpace', and skip these next characters. Then we need to
 * compare whether the characters in specific position is same for the two string. In addition,if the count of '#' is
 * larger than integers, the two variables 'sBackSpace' and 'tBackSpace' will be negative, but they need to be negative
 * at the same time, if not, the two strings are different.
 *
 * Time complexity: O(m+n)
 * Space complexity: O(1)
 *
 * Note: In most situation, the operations of Stack is time consuming, so the 2nd approach will be faster!
 *
 */
public class BackspaceStringCompare_844 {

    public static boolean backspaceCompare1(String S, String T) {
        Stack<Character> sChars = new Stack<>();
        Stack<Character> tChars = new Stack<>();

        for (char ch : S.toCharArray()) {
            if (ch == '#') {
                if (!sChars.isEmpty()) sChars.pop();
            }
            else sChars.push(ch);
        }

        for (char ch : T.toCharArray()) {
            if (ch == '#') {
                if (!tChars.isEmpty()) tChars.pop();
            }
            else tChars.push(ch);
        }

        return sChars.toString().equals(tChars.toString());
    }

    public static boolean backspaceCompare2(String S, String T) {
        int i = S.length()-1, j = T.length()-1;
        int sBackSpace = 0, tBackSpace = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    sBackSpace++;
                    i--;
                }
                else if (sBackSpace > 0) {
                    sBackSpace--;
                    i--;
                }
                else break;
            }

            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    tBackSpace++;
                    j--;
                }
                else if (tBackSpace > 0) {
                    tBackSpace--;
                    j--;
                }
                else break;
            }

            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) return false;
            if ((i >= 0) != (j >=0)) return false;
            i--;j--;
        }

        return true;
    }
}
