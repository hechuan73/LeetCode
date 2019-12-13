package items;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hechuan
 */
public class LetterCasePermutation_784 {

    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        backtracking(S, 0, new StringBuilder(), res);
        return res;
    }

    private void backtracking(String s, int start, StringBuilder sb, List<String> res) {
        if (sb.length() == s.length()) {
            res.add(sb.toString());
            return;
        }

        char c;
        if (start < s.length()) {
            c = s.charAt(start);
            sb.append(c);
            backtracking(s, start+1, sb, res);
            sb.deleteCharAt(sb.length()-1);

            if (c >= 'a' && c <= 'z') {
                sb.append((char) (c-32));
                backtracking(s, start+1, sb, res);
                sb.deleteCharAt(sb.length()-1);
            }

            if (c >= 'A' && c <= 'Z') {
                sb.append((char) (c+32));
                backtracking(s, start+1, sb, res);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
