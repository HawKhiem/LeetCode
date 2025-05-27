package DynamicProgramming.no0123;

public class BestTimeToBuyAndSellStockIII {
    private int[][][] mem;

    // TODO: Using dynamic programming. On each day, we could either skip, sell or buy stock. With the given constraints in the exercise, we can only buy when we are in No-State
    //  We can only sell when we are in Bought-State, and we can always skip
    //  pos->current position in the prices array - the ith day
    //  transLeft->transactions left - we could make at most 2 transactions
    //  boughtState->1 for Bought-State and 0 for No-State
    //  Time: O(2^n), Space: O(n) - Time Limit Exceeded
    private int dp(int[] prices, int pos, int transLeft, int boughtState) {
        /// Out of bound, which means we either are done with the transactions or there is nothing left to do (no more stock to sell or buy)
        if (pos >= prices.length || transLeft == 0) {
            return 0;
        }
        /// Return profit if already calculated
        if (mem[boughtState][transLeft - 1][pos] != -1) {
            return mem[boughtState][transLeft][pos];
        }
        /// 3 choices each day -> Buy/Sell/Skip
        /// We can always skip no matter the state
        int profit = dp(prices, pos + 1, transLeft, boughtState);
        /// if we are in boughtState, we can sell, after that we go back to No-State
        if (boughtState == 1) {
            profit = Math.max(profit, dp(prices, pos + 1, transLeft - 1, 0) + prices[pos]);
        }
        /// otherwise we could buy, after that we go to Bought-State. Notice that the transLeft is unchanged, a transaction is completed only when we sell the bought stock
        else {
            profit = Math.max(profit, dp(prices, pos + 1, transLeft, 1) - prices[pos]);
        }
        return profit;
    }

    public int maxProfit(int[] prices) {
        mem = new int[2][2][prices.length];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < prices.length; k++) {
                    mem[i][j][k] = -1;
                }
            }
        }
        return dp(prices, 0, 2, 0);
    }

}
