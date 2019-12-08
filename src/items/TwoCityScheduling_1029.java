package items;

import java.util.Arrays;

/**
 * @author hechuan
 */
public class TwoCityScheduling_1029 {

    /**
     * Dynamic programming: dp[i][j] represents the cost when considering first (i + j) people in which i people assigned to city A and j
     * people assigned to city B.
     *
     * @param costs costs array
     * @return minimum cost of two cities scheduled
     */
    public int twoCitySchedCost1(int[][] costs) {
        int len = (costs.length >> 1);
        // dp[i][j] represents the cost when considering first (i + j) people in which i people assigned to city A and j
        // people assigned to city B.
        int[][] dp = new int[len+1][len+1];

        // first two people go to city A.
        for (int i = 1; i <= len; i++) {
            dp[i][0] = dp[i-1][0] + costs[i-1][0];
        }

        // first two people go to city B.
        for (int i = 1; i <= len; i++) {
            dp[0][i] = dp[0][i-1] + costs[i-1][1];
        }

        // calculate other cases by dp array.
        for (int i = 1; i <= len ; i++) {
            for (int j = 1; j <= len; j++) {
                dp[i][j] = Math.min(dp[i-1][j]+costs[i+j-1][0], dp[i][j-1]+costs[i+j-1][1]);
            }
        }

        return dp[len][len];
    }

    /**
     * 贪心法：
     * 分析：我们这样来看这个问题，公司首先将这 2N 个人全都安排飞往 B 市，再选出 N 个人改变它们的行程，让他们飞往 A 市。如果选择改变一个人的行
     * 程，那么公司将会额外付出 price_A - price_B 的费用，这个费用可正可负。因此最优的方案是，选出 price_A - price_B 最小的 N 个人，让他
     * 们飞往 A 市，其余人飞往 B 市。
     *
     * 算法：
     * 1. 按照 price_A - price_B 从小到大排序；
     * 2. 将前 N 个人飞往 A 市，其余人飞往 B 市，并计算出总费用。
     *
     * @param costs costs array
     * @return minimum cost of two cities scheduled
     */
    public int twoCitySchedCost(int[][] costs) {
        // can be simplify to "Arrays.sort(costs, Comparator.comparingInt((int[] a) -> (a[0] - a[1])));"
        Arrays.sort(costs, (int[] a, int[] b) -> {
            return (a[0] - a[1]) - (b[0] - b[1]);
        });

        int len = (costs.length >> 1);
        int res = 0;
        for (int i = 0; i < len; i++) {
            res += costs[i][0] + costs[len+i][1];
        }

        return res;
    }

}
