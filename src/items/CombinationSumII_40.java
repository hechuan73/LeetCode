package items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // to avoid duplicate number
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backTracing(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void backTracing(List<List<Integer>> res, List<Integer> comb, int[] candidates, int target, int begin) {
        if (target == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            // to avoid duplicate number
            if (i > begin && candidates[i] == candidates[i-1]) {continue;}
            if (candidates[i] <= target) {
                comb.add(candidates[i]);
                backTracing(res, comb, candidates, target-candidates[i], i+1);
                comb.remove(comb.size()-1);
            }
        }
    }
}
