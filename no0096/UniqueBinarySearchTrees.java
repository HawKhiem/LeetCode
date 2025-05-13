package no0096;

public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        UniqueBinarySearchTrees leetcode = new UniqueBinarySearchTrees();
        System.out.println(leetcode.numTrees(3));
    }

    public int numTrees(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return numTreesRec(1, n, dp);
    }

    private int numTreesRec(int left, int right, int[][] dp) {
        if (left > right) {
            return 1;
        }
        if (dp[left][right] != 0) {
            return dp[left][right];
        }
        int result = 0;
        for (int value = left; value <= right; value++) {
            result += numTreesRec(left, value - 1, dp) * numTreesRec(value + 1, right, dp);
        }
        return dp[left][right] = result;
    }
}
