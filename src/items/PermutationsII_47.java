package items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII_47 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int[] visited = new int[nums.length];
        backTrace(nums, result, new ArrayList<>(), visited);
        return result;
    }

    private void backTrace(int[] nums, List<List<Integer>> result, List<Integer> tmp, int[] visited) {
        if (tmp.size() == nums.length) {
            result.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length ; i++) {
            if ((visited[i] == 1) || (i > 0 && visited[i-1] == 0 && nums[i] == nums[i-1])) continue;
            tmp.add(nums[i]);
            visited[i] = 1;
            backTrace(nums, result, tmp, visited);
            visited[i] = 0;
            tmp.remove(tmp.size()-1);
        }
    }
}
