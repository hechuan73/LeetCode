package items;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hechuan
 */
public class GenerateParentheses_22 {

    /**
     * Simple backtracking.
     *
     * @param n input n
     * @return the parenthesis list
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtracking(n, 0, 0, res, new StringBuilder());
        return res;
    }

    private void backtracking(int n, int open, int close, List<String> res, StringBuilder sb) {
        if (sb.length() == n * 2) {
            res.add(sb.toString());
            return;
        }

        if (open < n) {
            backtracking(n, open+1, close, res, sb.append("("));
            sb.deleteCharAt(sb.length()-1);
        }

        if (close < open) {
            backtracking(n, open, close+1, res, sb.append(")"));
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
