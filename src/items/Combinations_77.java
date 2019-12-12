package items;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hechuan
 */
public class Combinations_77 {

    /**
     * Simple backtracking method.
     *
     * @param n input n
     * @param k k numbers
     * @return the combination list
     */
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        backtracking(n, k, 1, comb, res);
        return res;
    }

    private static void backtracking(int n, int k, int start, List<Integer> comb, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }

        // if i > n-k+1, there is not k numbers remain.
        for (int i = start; i <= n-k+1; i++) {
            comb.add(i);
            backtracking(n, k-1, i+1, comb, res);
            comb.remove(comb.get(comb.size()-1));
        }
    }
}
