package items;

/**
 * @author hechuan
 */
public class PartitionEqualSubsetSum_416 {

    /**
     * 01 knapsack problem with 2D-dp.
     *
     * @param nums input nums
     * @return whether it can be partition
     */
    public boolean canPartition1(int[] nums) {
        if (nums.length == 0) { return false; }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) { return false; }
        sum /= 2;
        // 01背包问题，使用n个物品，填满容量为sum的背包
        boolean[][] dp = new boolean[nums.length+1][sum+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                // 如果当前的物品重量大于背包空间，则可以跳过
                dp[i][j] = dp[i-1][j];
                if (j >= nums[i-1]) {
                    dp[i][j] = dp[i][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }

        return dp[nums.length][sum];
    }

    /**
     * 01 knapsack problem with 1D-dp.
     *
     * @param nums input nums
     * @return whether it can be partition
     */
    public boolean canPartition2(int[] nums) {
        if (nums.length == 0) { return false; }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) { return false; }
        sum /= 2;
        // 01背包问题，使用n个物品，填满容量为sum的背包
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;

        for (int num : nums) {
            for (int i = dp.length-1; i >= 0; i--) {
                // 如果当前的物品重量大于背包空间，则可以跳过
                if (i >= num) {
                    dp[i] = dp[i] || dp[i-num];
                }
            }
        }

        return dp[sum];
    }
}
