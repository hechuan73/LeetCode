package items;

/**
 * @author hechuan
 */
public class MinCostClimbingStairs_746 {


    /**
     * Dynamic programming with iteration method.
     *
     * 从地面可以直接跃向第0级或第1级，花费分别为dp[0]=cost[0]、dp[1]=cost[1]，对于跨到2阶，可以从第0阶跨两步，耗费dp[0]+cost[2]；或者
     * 可以从第1阶跨一步，耗费dp[1]+cost[2]，所以，对于跨到第n层，可以从第dp[n-2]跨两步，或者从dp[n-1]跨一步，耗费cost[n]，求出dp[n-1]
     * 和dp[n-2]的最小值就可以得到爬到第n阶的最小耗费。（此处根据题意假设终点是第n阶的后一阶）
     *
     * 状态转移方程为：dp[n] = Math.min(dp[n-1],dp[n-2]) + cost[n];
     *
     * @param cost input array
     * @return the minimum cost
     */
    public int minCostClimbingStairs(int[] cost) {
        int sum, first = cost[0], second = cost[1];
        for (int i = 2; i < cost.length; i++) {
            sum = cost[i] + Math.min(first, second);
            first = second;
            second = sum;
        }

        return Math.min(first, second);
    }


    /**
     * Dynamic programming with recursive method (Time Limit Exceeded, should optimize with cache)
     *
     * @param cost input array
     * @return the minimum cost
     */
    public static int minCostClimbingStairs1(int[] cost) {
        return dp(cost, 0, cost.length-1, 0);
    }

    private static int dp(int[] cost, int start, int end, int res) {
        if (start >= end) { return res; }
        return Math.min(cost[end] + dp(cost, start, end-1, res), cost[end-1]+dp(cost, start, end-2, res));
    }


}
