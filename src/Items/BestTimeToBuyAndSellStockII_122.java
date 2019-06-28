package Items;


/**
 * I think the approach 1 can reduce the calculation times.
 */
public class BestTimeToBuyAndSellStockII_122 {
    public static int maxProfit1(int[] prices) {
        int length = prices.length;
        if (length == 0 || length == 1) return 0;
        int result = 0, minPrice = prices[0];
        for (int i = 1; i < length; i++) {
            if (prices[i] < prices[i-1]) {
                result += prices[i-1] - minPrice;
                minPrice = prices[i];
            }
        }

        if (prices[length-1] >= prices[length-2]) result += prices[length-1] - minPrice;
        return result;
    }

    public static int maxProfit2(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) result += prices[i]-prices[i-1];
        }

        return result;
    }
}
