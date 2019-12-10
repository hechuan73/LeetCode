package items;

import java.util.Arrays;

/**
 * @author hechuan
 */
public class CoinChange_322 {

    /**
     * Simple dp method: the amount of money corresponds the amount of processes/status, the status transformation :
     * f(i) = 1 + Math.min{ f(i-coins[0]), f(i-coins[1])...f(i-coins[n-1], f(i-coins[n]))) }
     *
     * @param coins coin array
     * @param amount money amount
     * @return the minimum amount of coins
     */
    public int coinChange1(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        // since the denomination of coin is integer, so the maximum amount to make up that amount money is amount*1.
        // so we initial the dp[i] to the maximum value. If the amount can not be changed, dp[amount] will be the
        // maximum value, we can check it whether need to return -1.
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i = 0; i < amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[amount - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * Backtrack and memory cache method.
     *
     * @param coins coin array
     * @param amount money amount
     * @return the minimum amount of coins
     */
    public int coinChange2(int[] coins, int amount) {
        return coinChange(coins, amount, new int[amount+1]);
    }

    private int coinChange(int[] coins, int amount, int[] cache) {
        if (amount < 0) { return -1; }
        if (amount == 0) { return 0; }
        // cache[amount] caches the value of amount
        if (cache[amount] != 0) { return cache[amount]; }

        int tmp, res = Integer.MAX_VALUE;
        for (int coin : coins) {
            tmp = coinChange(coins, amount-coin, cache);
            if (tmp >= 0 && tmp < res) {
                res = tmp + 1;
            }
        }
        cache[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return cache[amount];
    }
}
