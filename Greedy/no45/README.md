## 45. Jump Game II

You are given a 0-indexed array of integers `nums` of length `n`. You are initially positioned at `nums[0]`.

Each element `nums[i]` represents the maximum length of a forward jump from index `i`.  
In other words, if you are at `nums[i]`, you can jump to any `nums[i + j]` where:

- `0 <= j <= nums[i]`, and
- `i + j < n`

Return the **minimum number of jumps** to reach `nums[n - 1]`.  
The test cases are generated such that you **can reach** `nums[n - 1]`.

---

### Example 1:

**Input:**  
`nums = [2,3,1,1,4]`

**Output:**  
`2`

**Explanation:**  
Jump 1 step from index 0 to 1, then 3 steps to the last index.

---

### Example 2:

**Input:**  
`nums = [2,3,0,1,4]`

**Output:**  
`2`

---

### Constraints:

- `1 <= nums.length <= 10000`
- `0 <= nums[i] <= 1000`
- It's guaranteed that you can reach `nums[n - 1]`.

### Greedy Algorithms:

- Greedy algorithms are a class of algorithms that make locally optimal choices at each step with the hope of finding a
  global optimum solution.
- At every step of the algorithm, we make a choice that looks the best at the moment. To make the choice, we sometimes
  sort the array so that we can always get the next optimal choice quickly. We sometimes also use a priority queue to
  get the next optimal item.
- After making a choice, we check for constraints (if there are any) and keep picking until we find the solution.
  Greedy algorithms do not always give the best solution. For example, in coin change and 0/1 knapsack problems, we get
  the best solution using Dynamic Programming.
- Examples of popular algorithms where Greedy gives the best solution are Fractional Knapsack, Dijkstra's algorithm,
  Kruskal's algorithm, Huffman coding and Prim's Algorithm

### Problem structure:

Most of the problems where greedy algorithms work follow these two properties:

1). Greedy Choice Property:- This property states that choosing the best possible option at each step will lead to the
best overall solution. If this is not true, a greedy approach may not work.

2). Optimal Substructure:- This means that you can break the problem down into smaller parts, and solving these smaller
parts by making greedy choices helps solve the overall problem.

### How to Identify Greedy Problems:

There are two major ways to detect greedy problems –

1). Can we break the problem into smaller parts? If so, and solving those parts helps us solve the main problem, it
probably would be solved using greedy approach. For example – In activity selection problem, once we have selected a
activity then remaining subproblem is to choose those activities that start after the selected activity.

2). Will choosing the best option at each step lead to the best overall solution? If yes, then a greedy algorithm could
be a good choice. For example – In Dijkstra’s shortest path algorithm, choosing the minimum-cost edge at each step
guarantees the shortest path.