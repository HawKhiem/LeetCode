package no37;

import java.util.Arrays;

public class SudokuSolver {
    public static void main(String[] args) {
        SudokuSolver solution = new SudokuSolver();
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        solution.solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }

//    // TODO: naive use backtracking to solve the sudoku (Time: O(n*9(n*n)))
//    public void solveSudoku(char[][] board) {
//        solveSudokuRec(board, 0, 0);
//    }
//
//    private boolean solveSudokuRec(char[][] board, int row, int col) {
//        /// already reached the end of the board
//        if (row == 8 && col == 9) {
//            return true;
//        }
//
//        /// reach the end of a line then go down to the next line
//        if (col == 9) {
//            row++;
//            col = 0;
//        }
//
//        /// if the current cell is not empty, go to the next cell
//        if (board[row][col] != '.') {
//            return solveSudokuRec(board, row, col + 1);
//        }
//
//        for (int i = 1; i <= 9; i++) {
//            if (isValid(board, row, col, (char) (i + '0'))) {
//                board[row][col] = (char) (i + '0');
//                /// if a solution can be found with the current choice
//                if (solveSudokuRec(board, row, col + 1)) {
//                    return true;
//                }
//                /// if no solution can be found with the current choice, undo the effect
//                board[row][col] = '.';
//            }
//        }
//        return false;
//    }
//
//    private boolean isValid(char[][] board, int row, int col, char num) {
//        /// check if the number is used on the row
//        for (int i = 0; i < 9; i++) {
//            if (board[row][i] == num) {
//                return false;
//            }
//        }
//
//        /// check if the number is used on the column
//        for (int i = 0; i < 9; i++) {
//            if (board[i][col] == num) {
//                return false;
//            }
//        }
//
//        /// check if the number is used on the submatrix
//        int startRow = row - row % 3;
//        int startCol = col - col % 3;
//        for (int i = startRow; i < startRow + 3; i++) {
//            for (int j = startCol; j < startCol + 3; j++) {
//                if (board[i][j] == num) {
//                    return false;
//                }
//            }
//        }
//
//        return true;
//    }

    // TODO: one can also use bit masking to improve the time complexity
    public void solveSudoku(char[][] board) {
        /// we have 9 rows, 9 columns and 9 submatrices and each has 9 numbers. Each bit in an integer can be used to represent if a digit has been used or not
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] subs = new int[9];

        /// initialize the 3 arrays with the current state of the board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                /// skip the cell when its not filled
                if (board[i][j] != '.') {
                    rows[i] |= (1 << board[i][j] - '0');
                    cols[j] |= (1 << board[i][j] - '0');
                    subs[(i / 3) * 3 + j / 3] |= (1 << board[i][j] - '0');
                }
            }
        }
        solveSudokuBitMaskingRec(board, rows, cols, subs, 0, 0);
    }

    private boolean isValidBitMasking(int[] rows, int[] cols, int[] subs, int row, int col, char num) {
        /// if the number has been used on the same row
        if ((rows[row] & (1 << (num - '0'))) != 0) {
            return false;
        }

        /// if the number has been used on the same column
        if ((cols[col] & (1 << (num - '0'))) != 0) {
            return false;
        }

        /// if the number has been used on the same submatrix
        if ((subs[(row / 3) * 3 + col / 3] & (1 << (num - '0'))) != 0) {
            return false;
        }
        return true;
    }

    private boolean solveSudokuBitMaskingRec(char[][] board, int[] rows, int[] cols, int[] subs, int row, int col) {
        /// reach the end of the board
        if (row == 8 && col == 9) {
            return true;
        }

        /// reach the end of a line then go down to the next line
        if (col == 9) {
            row++;
            col = 0;
        }

        /// skip the current cell if its already filled
        if (board[row][col] != '.') {
            return solveSudokuBitMaskingRec(board, rows, cols, subs, row, col + 1);
        }

        /// try out all 9 numbers
        for (int i = 1; i <= 9; i++) {
            /// if it is safe to put the number into the cell
            if (isValidBitMasking(rows, cols, subs, row, col, (char) (i + '0'))) {
                board[row][col] = (char) (i + '0');

                /// update the 3 arrays
                rows[row] |= (1 << i);
                cols[col] |= (1 << i);
                subs[(row / 3) * 3 + col / 3] |= (1 << i);
                /// if a valid solution can be found with the current choice
                if (solveSudokuBitMaskingRec(board, rows, cols, subs, row, col + 1)) {
                    return true;
                }
                /// undo the changes
                board[row][col] = '.';
                rows[row] &= ~(1 << i);
                cols[col] &= ~(1 << i);
                subs[(row / 3) * 3 + col / 3] &= ~(1 << i);
            }
        }
        return false;
    }

    // TODO: we can improve the runtime by precomputing all the bit masks and storing them in an array
    //       this will save us the time of computing the bit masks for each cell
}
