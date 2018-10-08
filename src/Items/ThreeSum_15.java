package Items;

import java.util.*;

public class ThreeSum_15 {
    /**
     * PS: straightly solve.
     *     1. O(n2) -> ok; O(n3) -> failed
     *     2. result list need to sort by ASC.
     *     3. line 36, the "while" loop is to reduce the process times, so it is less than O(n3).
     *
     * @param nums input array
     * @return the result list
     */
    public static Set<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> results = new HashSet<>();
        List<Integer> result;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int target = nums[i] + nums[start] + nums[end];
                if (target == 0) {
                    result = new ArrayList<>();
                    result.add(nums[i]);
                    result.add(nums[start]);
                    result.add(nums[end]);
                    results.add(result);
                    while (start < end && nums[start] == nums[start+1]) {
                        start++;
                    }
                    while (start < end && nums[end] == nums[end-1]) {
                        end--;
                    }
                    start++;
                }
                else if (target < 0) {
                    start++;
                }
                else {
                    end--;
                }
            }
        }

        System.out.println(results);
        return results;
    }
}
