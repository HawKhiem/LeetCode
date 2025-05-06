package DynamicProgramming.no0062;

public class UniquePaths {

    public static void main(String[] args) {
        UniquePaths leetcode = new UniquePaths();
        System.out.println(leetcode.uniquePaths(10, 10));
    }

    // TODO: Count the numbers of downs and rights the robots has to make
    //  r=n-1, d=m-1
    //  Use math to count the number of possible paths
    //  (r+d)! / (r! * d!)
    public int uniquePaths(int m, int n) {
        double nominator = 1;
        double denominator = 1;
        int bound = m + n - 2;
        int min = Math.min(m - 1, n - 1);
        int max = Math.max(m - 1, n - 1);
        for (int i = 1; i <= bound; i++) {
            if (i <= min) {
                denominator *= i;
            } else if (i > max) {
                nominator *= i;
            }
        }
        return (int) (nominator / denominator);
    }

    // TODO: One can also use dynamic programming to solve this problem
    public int uniquePathsDP(int m, int n) {
        int[][] dp = new int[m][n];
        /// mark all the cells in the first column as 1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        /// mark all the cells in the first row as 1
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        /// calculate how many ways there are to reach cell [i,j]. Since we can reach it from [i-1,j] and [i,j-1],
        /// we simply need to add up ways to reach these 2 cells
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        /// return ways to reach the last cell
        return dp[m - 1][n - 1];
    }
}
