## 123. Best Time to Buy and Sell Stock III

You are given an array `prices` where `prices[i]` is the price of a given stock on the iᵗʰ day.

Find the **maximum profit** you can achieve. You may complete **at most two transactions**.

**Note:** You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy
again).

---

### Example 1:

**Input:**  
prices = [3,3,5,0,0,3,1,4]  
**Output:**  
6  
**Explanation:**

- Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3.
- Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 3.  
  Total profit = 3 + 3 = 6.

---

### Example 2:

**Input:**  
prices = [1,2,3,4,5]  
**Output:**  
4  
**Explanation:**

- Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 4.  
  Only one transaction is done.

---

### Example 3:

**Input:**  
prices = [7,6,4,3,1]  
**Output:**  
0  
**Explanation:**  
No transaction is done, so profit is 0.

---

### Constraints:

- `1 <= prices.length <= 10^5`
- `0 <= prices[i] <= 10^5`
