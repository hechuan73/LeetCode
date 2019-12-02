package items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hechuan
 */
public class CombinationSum_39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backTracing(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void backTracing(List<List<Integer>> res, List<Integer> comb, int[] candidates, int target, int begin) {
        if (target == 0) { res.add(new ArrayList<>(comb)); }

        for (int i = begin; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                comb.add(candidates[i]);
                backTracing(res, comb, candidates, target-candidates[i], i);
                comb.remove(comb.size()-1);
            }
            else { break; }
        }
    }
}
