package Items;

public class BestTimeToBuyAndSellStockIII_123 {
    /**
     * 1. oneBuy是在第i天第一次买入时的最大收益
     *    oneBuyOneSell是在第i天第一次卖出时的最大收益
     *    twoBuy是在第i天第二次买入时的最大收益
     *    twoBuyTwoSell是在第i天第二次卖出时的最大收益
     *
     * 2. 四个利益值是一个累积的过程，但是每一个值都是独立的，例如：
     *    对于第一次买入，其总收益就是-prices[i]；
     *    对于第一次卖出，其总收益就是就是第一次买入的收益oneBuy，加上本次卖出变现的收益price[i]；
     *    对于第二次买入，其总收益就是本次卖出的收益-prices[i]，加上第一次卖出的收益oneBuyOneSell；
     *    对于第二次卖出，其总收益就是就是第二次买入的收益twoBuy，加上本次卖出变现的收益price[i]；
     *
     * 3. 最后的结果，可以直接返回twoBuyTwoSell，因为其本身就是累积的总收益，但为了更容易理解，因为最大的买卖次数为2，所以我们比较
     *    一次买卖和两次买卖的收益最大值。
     *
     * @param prices input arrays
     * @return max profits
     */
    public static int maxProfit(int[] prices) {
        int oneBuy = Integer.MIN_VALUE;
        int oneBuyOneSell = 0;
        int twoBuy = Integer.MIN_VALUE;
        int twoBuyTwoSell = 0;

        for (int price : prices){
            oneBuy = Math.max(oneBuy, -price);
            oneBuyOneSell = Math.max(oneBuyOneSell, price + oneBuy);
            twoBuy = Math.max(twoBuy, -price + oneBuyOneSell);
            twoBuyTwoSell = Math.max(twoBuyTwoSell, price + twoBuy);
        }

        return Math.max(oneBuyOneSell, twoBuyTwoSell);
    }
}
