## 63. Unique Paths II

You are given an `m x n` integer array `grid` (called `obstacleGrid`) representing a grid. Each cell is either `0` (an
empty space) or `1` (an obstacle).

A robot is located at the top-left corner of the grid (position `[0][0]`). The robot can only move either down or right
at any point in time.

Return the number of possible unique paths that the robot can take to reach the bottom-right corner of the grid (
position `[m-1][n-1]`).

A path that encounters an obstacle is not a valid path.

---

### Example 1:

**Input:**  
`obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]`

**Output:**  
`2`

**Explanation:**  
There is one obstacle in the middle of the grid.  
There are two possible paths to reach the bottom-right corner:

- Right → Right → Down → Down
- Down → Down → Right → Right

---

### Example 2:

**Input:**  
`obstacleGrid = [[0,1],[0,0]]`

**Output:**  
`1`

---

### Constraints:

- `m == obstacleGrid.length`
- `n == obstacleGrid[i].length`
- `1 <= m, n <= 100`
- `obstacleGrid[i][j]` is `0` or `1`
