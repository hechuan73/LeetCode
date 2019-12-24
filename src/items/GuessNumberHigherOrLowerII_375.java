package items;

/**
 * @author hechuan
 */
public class GuessNumberHigherOrLowerII_375 {

    /**
     * 利用二分法取得的解不一定是最优解，例如：{1,2,3,4,5}, 二分的思路肯定是先猜3，如果大了，就猜2，如果小了，猜4，接下来就一定可以猜中答案。
     * 那么如果答案是5，二分就要付出3+4=7的金额。如果是1，那么就要付出5。如果答案是3，那么就是0……。这里面付的钱有0，有5，有7。那到底最少要准备
     * 多少钱呢？其实只要6块钱。为何呢，先猜4，如果小了，那么就一定是5，那就是4元，如果大了，就猜2，接下来就一定猜到答案，那么就是6元，所以说，
     * 最多只要准备6元。 所以二分的思想其实是有问题的。
     *
     * 这里用动态规划的思想，状态转移方程：dp[i][j] = min(k + max(dp[i][k-1], dp[k+1][j])), dp[i][j]表示[i, j]范围内一定能赢的最少
     * 需要的钱。其中，max()很容易理解，就是看两端哪边画的钱多，取最大的来保证必赢。那如何理解min()函数？
     *
     * 这道题目是求至少需要多少钱才能保证不论对方抽到的数是哪一个，我们在花完钱之前（包括刚好花完钱）都一定能猜出对方抽到的数是哪一个。那么有两点
     * 需要注意：
     * 1. 我们需要考虑最坏情况，也就是前几次每一次猜到的数都是错误的，最后一次猜到的数才是对方抽到的数。这样求得的值才是我们最少需要的钱。
     * 2. 题目有一点没说，就是题目是求只要n确定，那么我一直选择某一个固定的数作为我猜的第一个错数，那么不管对方抽到的是哪个数、不管对方抽几次，
     *    我都能在我花完钱之前猜出对方抽到的数。而这个固定的数是n变化才可能变化，n不变，不管对方抽到的是哪个数，我都不变。这有一种赌场提前用数学
     *    工具计算的味道。我只要知道赌博范围，我就知道我最少花多少钱能赢，但如果我不知道赌博范围，这个最少的钱和我要猜错的第一个数我是无法知道的。
     *
     * Up to down dp method.
     *
     * @param n input range
     * @return the mount amount to guarantee a win
     */
    public int getMoneyAmount1(int n) {
        int[][] dp = new int[n+1][n+1];
        return dfs(dp, 1, n);
    }

    private int dfs(int[][] dp, int start, int end) {
        if (start >= end) { return 0;}
        if (dp[start][end] != 0) { return 0; }

        int res = Integer.MAX_VALUE;
        int tmp;
        for (int i = start; i <= end; i++) {
            tmp = i + Math.max(dfs(dp, start, i-1), dfs(dp, i+1, end));
            res = Math.min(res, tmp);
        }

        return dp[start][end] = res;
    }

    /**
     * Bottom to up dp method.
     *
     * @param n input range
     * @return the mount amount to guarantee a win
     */
    public int getMoneyAmount2(int n) {
        int[][] dp = new int[n+1][n+1];

        int res, tmp;
        for (int i = 2; i <= n; i++) {
            for (int j = i-1; j > 0; j--) {
                res = Integer.MAX_VALUE;
                for (int k = j+1; k < i; k++) {
                    // dp[k][k] = 0
                    tmp = k + Math.max(dp[j][k-1], dp[k+1][i]);
                    res = Math.min(res, tmp);
                }
                // dp[k][k+1] = k.
                dp[j][i] = i == j+1 ? j : res;
            }
        }

        return dp[1][n];
    }
}
