package NOTYETCATEGORIZED.no0121;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 0;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            /// improve profit
            if (prices[i] < prices[buy]) {
                buy = i;
                if (buy < sell) {
                    profit = Math.max(prices[sell] - prices[buy], profit);
                }
            }
            /// at least have profit
            if (prices[i] > prices[buy] && i > buy) {
                sell = i;
                profit = Math.max(prices[sell] - prices[buy], profit);
            }
            /// improve profit
            if (prices[i] > prices[sell] && i > buy) {
                sell = i;
                profit = Math.max(prices[sell] - prices[buy], profit);
            }
        }
        return profit;
    }

    // TODO - a beautiful solution:
    //     public int maxProfit(int[] a) {
    //        int least = Integer.MAX_VALUE;
    //        int max = 0 ;
    //        for(int i = 0 ; i<a.length; i++)
    //        {
    //            int profit = a[i]-least;
    //            /// rising trend, potential sell point
    //            if(profit>=0)
    //            {
    //                max = (profit > max)? profit : max;
    //            }
    //            /// otherwise, it means we have a value smaller than least
    //            else
    //            {
    //                least = a[i];
    //            }
    //        }
    //        return max;
    //    }
}
