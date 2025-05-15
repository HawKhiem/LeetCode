package NOTYETCATEGORIZED.no0122;

public class BestTimeToBuyAndSellStockII {

    // TODO: always buy low sell high (which means buying on the rising trend)
    //  Intuition: https://www.youtube.com/watch?v=3SJ3pUkPQMc
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += (prices[i] - prices[i - 1]);
            }
        }
        return profit;
    }
}
