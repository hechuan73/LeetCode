package items;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hechuan
 */
public class TwoSum_1 {

    public int[] twoSum1(int[] nums, int target) {
        int[] results = new int[2];
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i +1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    results[0] = i;
                    results[1] = j;
                    return results;
                }
            }
        }
        return results;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        int tmp;
        for (int i = 0; i < nums.length; i++) {
            tmp = target-nums[i];
            if (map.containsKey(tmp)) {
                res[0] = i;
                res[1] = map.get(tmp);
                return res;
            }
            map.put(nums[i], i);
        }

        return res;
    }

}
