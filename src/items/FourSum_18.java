package items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) return result;
        Arrays.sort(nums);
        if (4 * nums[0] > target || 4 * nums[nums.length-1] < target) return result;

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] + 3 * nums[nums.length - 1] < target) continue;
            if (4 * nums[i] > target) break;

            for (int j = i+1; j < nums.length - 2; j++) {
                if (j > i+1 && nums[j] == nums[j - 1]) continue;
                if (nums[i] + nums[j] + 2 * nums[nums.length-1] < target) continue;
                if (nums[i] + 3 * nums[j] >target) break;
                int start = j + 1, end = nums.length - 1;
                while (start < end) {
                    if (start > j+1  && nums[start] == nums[start-1]) {
                        start++;
                        continue;
                    }
                    if (end < nums.length - 1 && nums[end] == nums[end+1]) {
                        end--;
                        continue;
                    }
                    int tmp = nums[i] + nums[j] + nums[start] + nums[end];
                    if (tmp == target) result.add(Arrays.asList(nums[i], nums[j], nums[start++], nums[end--]));
                    else if (tmp < target) start++;
                    else end--;
                }
            }
        }

        return result;
    }
}
