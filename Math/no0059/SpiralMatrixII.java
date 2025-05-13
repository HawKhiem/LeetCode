package Math.no0059;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrixII {
    public static void main(String[] args) {
        SpiralMatrixII leetcode = new SpiralMatrixII();
        System.out.println(Arrays.deepToString(leetcode.generateMatrix(3)));
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int rowEnd = matrix.length - 1;
        int colEnd = matrix[0].length - 1;
        int rowStart = 0;
        int colStart = 0;
        int filler = 1;
        /// 0 - go right, 1 - go down, 2 - go left, 3 - go up. They cycle
        int direction = 0;
        List<Integer> result = new ArrayList<>();

        while (filler <= n * n) {
            switch (direction) {
                /// go right
                case 0:
                    for (int i = colStart; i <= colEnd; i++) {
                        matrix[rowStart][i] = filler++;
                    }
                    rowStart++;
                    direction = 1;
                    break;
                /// then go down
                case 1:
                    for (int i = rowStart; i <= rowEnd; i++) {
                        matrix[i][colEnd] = filler++;
                    }
                    direction = 2;
                    colEnd--;
                    break;
                /// then go left
                case 2:
                    for (int i = colEnd; i >= colStart; i--) {
                        matrix[rowEnd][i] = filler++;
                    }
                    direction = 3;
                    rowEnd--;
                    break;
                /// then go up
                case 3:
                    for (int i = rowEnd; i >= rowStart; i--) {
                        matrix[i][colStart] = filler++;
                    }
                    direction = 0;
                    colStart++;
                    break;
            }
        }
        return matrix;
    }
}
