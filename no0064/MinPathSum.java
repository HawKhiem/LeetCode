package no0064;

import java.util.List;

public class MinPathSum {
    public static void main(String[] args) {
        MinPathSum leetcode = new MinPathSum();
        System.out.println(leetcode.minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}}));
    }

    // TODO - Intuition:
    //  At any cell, the decision to choose the cell above or the cell to the left is based on which of those two cells provides a lesser sum.
    //  Since those sums represent the minimum sum to get to those cells, we ensure the minimum sum to get to the current cell by adding the current cell's value to the lesser of those two sums.
    //  This builds up to the final solution by ensuring at each step, we have the optimal (minimal) path chosen.
    //  https://algo.monster/liteproblems/64
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        /// initializing the first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        /// initializing the first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                /// The cell dp[i][j] is the minimum of the cell above or to the left of it,
                /// plus the value in the current cell of the grid.
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        /// Return the bottom-right cell which contains the min path sum from top-left to bottom-right.
        return dp[m - 1][n - 1];
    }

    // TODO - naive approach: Backtracking - memory limit exceeded
    public int minPathSumNaive(int[][] grid) {
        List<Integer> sums = new java.util.ArrayList<>();
        if (minPathSumRec(grid, 0, 0, 0, sums)) {
            return sums.stream().min(Integer::compareTo).get();
        }
        return 0;
    }

    public boolean minPathSumRec(int[][] grid, int row, int col, int sum, List<Integer> sums) {
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            sum += grid[row][col];
            sums.add(sum);
            return true;
        }

        if (row >= grid.length || col >= grid[0].length) {
            return false;
        }

        /// try going down
        if (row < grid.length - 1) {
            minPathSumRec(grid, row + 1, col, sum + grid[row][col], sums);
        }

        /// try going right
        if (col < grid[0].length - 1) {
            minPathSumRec(grid, row, col + 1, sum + grid[row][col], sums);
        }
        return true;
    }
}
