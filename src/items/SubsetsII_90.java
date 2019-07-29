package items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII_90 {

    public static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backTrace(nums, result, new ArrayList<>(), 0);
        return result;
    }

    public static void backTrace(int[] nums, List<List<Integer>> result, List<Integer> tmp, int index) {
        result.add(new ArrayList<>(tmp));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i-1]) continue;
            tmp.add(nums[i]);
            backTrace(nums, result, tmp, i+1);
            tmp.remove(tmp.size()-1);
        }
    }
}
