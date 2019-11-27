package items;

import java.util.Arrays;

/**
 * @author hechuan
 */
public class HouseRobber_198 {

    /**
     * Simple recursive dp: f(n) = Math.max(nums[n] + f(n - 2), f(n - 1)).
     * Time consuming with many duplicate calculation.
     *
     * @param nums input array
     * @return the maximum rob value
     */
    public int rob1(int[] nums) {
        return dp1(nums, nums.length-1);
    }

    private int dp1(int[] nums, int end) {
        if (end < 0) { return 0; }
        return Math.max(nums[end] + dp1(nums, end - 2), dp1(nums, end - 1));
    }

    /**
     * Improved recursive dp with cache: f(n) = Math.max(nums[n] + f(n - 2), f(n - 1)).
     *
     * @param nums input array
     * @return the maximum rob value
     */
    public int rob2(int[] nums) {
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
        return dp2(nums, nums.length-1, cache);
    }

    private int dp2(int[] nums, int end, int[] cache) {
        if (end < 0) { return 0; }
        if (cache[end] >= 0) { return cache[end]; }

        cache[end] = Math.max(nums[end] + dp2(nums, end - 2, cache), dp2(nums, end - 1, cache));
        return cache[end];
    }

    /**
     * Simple iterative dp with an array cache: f(n) = Math.max(nums[n] + f(n - 2), f(n - 1)).
     *
     * @param nums input array
     * @return the maximum rob value
     */
    public int rob3(int[] nums) {
        if (nums.length == 0) { return 0; }
        int[] cache = new int[nums.length+1];
        cache[0] = 0;
        cache[1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            cache[i+1] = Math.max(cache[i], nums[i]+cache[i-1]);
        }

        return cache[nums.length];
    }

    /**
     * Improved iterative dp with two variables cache: f(n) = Math.max(nums[n] + f(n - 2), f(n - 1)).
     *
     * @param nums input array
     * @return the maximum rob value
     */
    public int rob4(int[] nums) {
        if (nums.length == 0) { return 0; }

        int prev1 = 0;
        int prev2 = 0;

        for (int num : nums) {
            int tmp = prev1;
            prev1 = Math.max(prev1, num+prev2);
            prev2 = tmp;
        }

        return prev1;
    }
}
