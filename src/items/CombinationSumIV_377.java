package items;

import java.util.Arrays;

/**
 * Follow up question: If the given array contains negative numbers, What limitation we need to add to the question to
 * allow negative numbers?
 *
 * The problem with negative numbers is that now the combinations could be potentially of infinite length. Think about
 * nums = [-1, 1] and target = 1. We can have all sequences of arbitrary length that follow the patterns -1, 1, -1, 1,
 * ..., -1, 1, 1 and 1, -1, 1, -1, ..., 1, -1, 1 (there are also others, of course, just to give an example). So we
 * should limit the length of the combination sequence, so as to give a bound to the problem.
 *
 * @author hechuan
 */
public class CombinationSumIV_377 {

    /**
     * Basic recursive solutions. [Time Limit Exceeded]
     *
     * @param nums input arrays
     * @param target target value
     * @return the available combination ways to add up to the target value.
     */
    public int combinationSum4_1(int[] nums, int target) {
        if (target == 0) { return 1; }

        int res = 0;
        for (int num : nums) {
            if (target >= num) {
                res += combinationSum4_1(nums, target - num);
            }
        }

        return res;
    }

    /**
     * Optimised dp recursive solutions with cache and top-down.
     *
     * @param nums input arrays
     * @param target target value
     * @return the available combination ways to add up to the target value.
     */
    public int combinationSum4_2(int[] nums, int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return dfs(nums, target, dp);
    }

    private int dfs(int[] nums, int target, int[] dp) {
        if (dp[target] != -1) { return dp[target]; }

        int res = 0;
        for (int num : nums) {
            if (target >= num) {
                res += dfs(nums, target - num, dp);
            }
        }
        return dp[target] = res;
    }

    /**
     * Optimised dp recursive solutions with cache and down-top.
     *
     * @param nums input arrays
     * @param target target value
     * @return the available combination ways to add up to the target value.
     */
    public int combinationSum4_3(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        int index;
        for (int i = 1; i < dp.length; i++) {
            for (int num : nums) {
                index = i - num;
                if (index >= 0) {
                    dp[i] += dp[index];
                }
            }
        }

        return dp[target];
    }
}
