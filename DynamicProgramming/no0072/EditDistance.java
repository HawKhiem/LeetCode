package DynamicProgramming.no0072;

public class EditDistance {

    // TODO: Bottom up dynamic programming to solve the problem. Create a cache of length m*n as such.
    //  The last row and column serve as out base cases.
    //  The intuition behind this approach is: We have two pointers, i and j pointing to the beginning of word1 and word2 respectively
    //  When we iterate through each character in the 2 words, whenever they are equal
    //  We move forward without incrementing the steps needed. That corresponds to moving in the diagonal direction downwards, i.e, i++ and j++
    //  When we want to insert, we could insert into word1, meaning we have taken care of the character at index j in word 2, this corresponds to
    //  i,j+1. Similarly when we delete a character from word1, we have taken care of the difference at index i in word 1, so we move to i+1,
    //  this corresponds to i+1,j. When we however replace the character at indices i,j - this corresponds to i+1,j+1.
    //  Since we don't know which of these three choices would result in the least amount of steps, we could use dynamic programming to test all
    //  https://www.youtube.com/watch?v=XYi2-LPrwm4
    public int minDistance(String word1, String word2) {
        /// one extra column and row to handle the base cases
        int m = word1.length() + 1;
        int n = word2.length() + 1;
        int[][] dp = new int[m][n];
        /// put everything to be min int
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        /// word1 = "", word2 = abc, we would need 3 steps to turn word1 into word2, in general we need word2.length steps
        /// each time we move right one column, it means we are moving in i,j+1 direction, which basically means we have dealt with
        /// one character in word2, and therefore the number of steps to turn one word into another reduces
        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = word2.length() - i;
        }

        /// word2 = "", word1 = abc, we would need 3 steps to turn word1 into word2, in general we need word1.length steps
        /// each time we move down a row, it means we are moving in i+1,j direction, which basically means we have dealt with
        /// one character in word1, and therefore the number of steps to turn one word into another reduces
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = word1.length() - i;
        }

        /// for the rest of the cells, we calculate from bottom up, at the same time checking if the character at i and j of the 2 words are the same
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    /// when the characters are the same, we don't have to take an extra step
                    dp[i][j] = dp[i + 1][j + 1];
                }
                /// if the characters are not the same, we have to check which action out of insert, delete or replace costs the least steps
                else {
                    /// dp[i][j+1] corresponds to insert
                    /// dp[i+1][j] corresponds to delete
                    /// dp[i+1][j+1] corresponds to edit
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i + 1][j + 1]);
                }
            }
        }
        return dp[0][0];
    }
}
