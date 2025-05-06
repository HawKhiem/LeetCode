package BackTracking.no52;

public class NQueensII {

    public static void main(String[] args) {
        NQueensII leetcode = new NQueensII();
        System.out.println(leetcode.totalNQueens(4));
    }

    public int totalNQueens(int n) {
        return totalNQueensRec(new int[n][n], 0);
    }

    private int totalNQueensRec(int[][] board, int row) {
        /// All queens placed
        if (row == board.length) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            if (isSafeToPlace(board, row, i)) {
                /// try placing the queen at the column
                board[row][i] = 1;

                /// increment count if the choice generates a solution
                count += totalNQueensRec(board, row + 1);

                /// undo the placement
                board[row][i] = 0;
            }

        }
        return count;
    }

    private boolean isSafeToPlace(int[][] board, int row, int col) {
        if (board[row][col] == 1) {
            return false;
        }

        /// check row
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        /// check col
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        /// check upper left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        /// check upper right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        /// check lower left diagonal
        for (int i = row + 1, j = col - 1; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        /// check lower right diagonal
        for (int i = row + 1, j = col + 1; i < board.length && j < board[0].length; i++, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}
