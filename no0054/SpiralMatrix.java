package no54;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        SpiralMatrix leetcode = new SpiralMatrix();
        System.out.println(leetcode.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int rowEnd = matrix.length - 1;
        int colEnd = matrix[0].length - 1;
        int rowStart = 0;
        int colStart = 0;

        /// 0 - go right, 1 - go down, 2 - go left, 3 - go up. They cycle
        int direction = 0;
        List<Integer> result = new ArrayList<>();

        while (result.size() < matrix.length * matrix[0].length) {
            switch (direction) {
                /// go right
                case 0:
                    for (int i = colStart; i <= colEnd; i++) {
                        result.add(matrix[rowStart][i]);
                    }
                    rowStart++;
                    direction = 1;
                    break;
                /// then go down
                case 1:
                    for (int i = rowStart; i <= rowEnd; i++) {
                        result.add(matrix[i][colEnd]);
                    }
                    direction = 2;
                    colEnd--;
                    break;
                /// then go left
                case 2:
                    for (int i = colEnd; i >= colStart; i--) {
                        result.add(matrix[rowEnd][i]);
                    }
                    direction = 3;
                    rowEnd--;
                    break;
                /// then go up
                case 3:
                    for (int i = rowEnd; i >= rowStart; i--) {
                        result.add(matrix[i][colStart]);
                    }
                    direction = 0;
                    colStart++;
                    break;
            }
        }
        return result;
    }
}
