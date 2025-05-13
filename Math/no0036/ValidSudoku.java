package Math.no0036;

public class ValidSudoku {
    // TODO: Naive approach - check every line, every column and every sub matrix.
    //  To check one can use an array of int to store availability of a number (this array contains 9 int)
    //  Therefore we would need an array of array to check each line, or each column/each submatrix
    //  One can also use bit manipulation and treat each integer as a virtual 'array'
    //  https://www.geeksforgeeks.org/check-if-given-sudoku-board-configuration-is-valid-or-not/
    public boolean isValidSudoku(char[][] board) {
        /// we have 9 rows and each row contains 9 different digits
        int[][] rows = new int[9][9];
        /// we have 9 columns and each column contains 9 different digits
        int[][] cols = new int[9][9];
        /// we have 9 sub matrices and each submatrix contains 9 different digits
        int[][] subs = new int[9][9];
        /// i represents the index of a row, j a column
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                /// only matters when a number has been placed at the position
                if (board[i][j] != '.') {
                    int digit = board[i][j] - '0';
                    int digitIndex = digit - 1;
                    /// digit is already taken on that row
                    if (rows[i][digitIndex] != 0) {
                        return false;
                    }
                    /// occupy the digit on that row
                    else {
                        rows[i][digitIndex] = 1;
                    }
                    /// digit is already taken on that column
                    if (cols[j][digitIndex] != 0) {
                        return false;
                    }
                    /// occupy the digit on that column
                    else {
                        cols[j][digitIndex] = 1;
                    }

                    /// (i/3) * 3 + (j/3) gives the index of the sub matrix
                    /// 0, 1, 2 -> 0; 3, 4, 5 -> 1; 6, 7, 8 -> 2
                    int subIndex = (i / 3) * 3 + j / 3;
                    /// digit is already taken in that submatrix
                    if (subs[subIndex][digitIndex] != 0) {
                        return false;
                    }
                    /// occupy that digit in the given submatrix
                    else {
                        subs[subIndex][digitIndex] = 1;
                    }
                }
            }
        }
        return true;
    }
}
