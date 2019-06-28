package Items;

public class BestTimeToBuyAndSellStock_121 {
    public static int maxProfit(int[] prices) {
        int result = 0, minPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < minPrice) minPrice = price;
            else {
                int bal;
                if ((bal = price - minPrice) > result) result = bal;
            }
        }

        return result;
    }
}
