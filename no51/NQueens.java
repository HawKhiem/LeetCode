package no51;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        NQueens leetcode = new NQueens();
        System.out.println(leetcode.solveNQueens(3));
    }

    public List<List<String>> solveNQueens(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<List<String>> result = new java.util.ArrayList<>();
        int[][] board = new int[n][n];
        solveNQueensRec(board, result, new ArrayList<>(), 0);
        return result;
    }


    public void solveNQueensRec(int[][] board, List<List<String>> result, List<String> possibleSolution, int rowIndex) {
        /// Stopping condition, when all the queens are placed
        if (rowIndex == board.length) {
            result.add(new ArrayList<>(possibleSolution));
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (isSafeToPlace(board, rowIndex, i)) {
                /// try putting the solution
                possibleSolution.add(buildString(i, board.length));
                board[rowIndex][i] = 1;
                solveNQueensRec(board, result, possibleSolution, rowIndex + 1);

                /// back track
                board[rowIndex][i] = 0;
                /// this basically reset the possible solution and start fresh. My mistake was to put the back tracking in the stopping condition
                possibleSolution.remove(possibleSolution.size() - 1);
            }
        }
    }

    private String buildString(int index, int boardLength) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < boardLength; j++) {
            if (j == index) {
                sb.append("Q");
            } else {
                sb.append(".");
            }
        }
        return sb.toString();
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
