package DivideAndConquer.no0123;

public class BestTimeToBuyAndSellStockIII {

    // TODO: Use Divide and Conquer. Divide on each day into two sides, left and right.
    //  Try to maximize the profit on the left as well on the right, keep track on the max profits in two separate arrays
    //  The total max profit is simply the sum of the profit at index i-1 in the left array and the profit at index i in the right array
    //  How to maximize the profit on each side. The problem shrinks to BestTimeToBuyAndSellStock. For the left side it is almost exactly the same
    //  For the right side, we iterate from the end of the array, and have to keep track of a global maximum.
    //  https://www.youtube.com/watch?v=37s1_xBiqH0
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int[] left = new int[n];
        int[] right = new int[n];
        /// Fill 1st transaction (LEFT)
        int leftMin = prices[0];
        /// On the first day, we could not sell, therefore left[0] is 0
        for (int i = 1; i < n; i++) {
            /// update maximum profit of the 1st transaction if possible
            left[i] = Math.max(left[i - 1], prices[i] - leftMin);
            /// update leftMin - which is our global minimum
            leftMin = Math.min(leftMin, prices[i]);
        }
        /// Fill 2nd transaction (RIGHT)
        int rightMax = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            /// update maximum profit of the 2nd transaction if possible
            right[i] = Math.max(right[i + 1], rightMax - prices[i]);
            /// update rightMax - which is our global maximum
            rightMax = Math.max(rightMax, prices[i]);
        }
        int profit = right[0];
        for (int i = 1; i < n; i++) {
            profit = Math.max(profit, left[i - 1] + right[i]);
        }
        return profit;
    }

}
