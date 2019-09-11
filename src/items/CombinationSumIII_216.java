package items;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backTracing(res, new ArrayList<Integer>(), k, n, 1);
        return res;
    }

    private void backTracing(List<List<Integer>> res, List<Integer> comb, int k, int n, int start) {
        if (comb.size() == k && n == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }

        for (int i = start; i <= 9; i++) {
            comb.add(i);
            backTracing(res, comb, k, n-i, i+1);
            comb.remove(comb.size()-1);
        }
    }
}
