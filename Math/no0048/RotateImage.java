package Math.no0048;

public class RotateImage {
    public static void main(String[] args) {
        RotateImage leetcode = new RotateImage();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        leetcode.rotate(matrix);
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public void rotate(int[][] matrix) {
        reverse(matrix);
        transpose(matrix);
    }

    /// reverse each column
    private void reverse(int[][] matrix) {
        for (int j = 0; j < matrix.length; j++) {
            int start = 0, end = matrix.length - 1;
            while (start < end) {
                int temp = matrix[start][j];
                matrix[start][j] = matrix[end][j];
                matrix[end][j] = temp;
                start++;
                end--;
            }
        }
    }

    /// Why this works:
    /// For each i, you only swap with j > i
    /// This means:
    /// You only touch the upper triangle of the matrix (excluding the diagonal)
    /// Each pair (i, j) and (j, i) is swapped exactly once
    /// Importantly: you never revisit the same pair in reverse (j < i), so nothing gets undone
    /// Intuition: in a matrix, all the numbers with i = j are those that lie on the diagonal. Those with j > i are the numbers above the diagonal line
    private void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

            }
        }
    }


}
