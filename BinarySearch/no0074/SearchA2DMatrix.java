package BinarySearch.no0074;

public class SearchA2DMatrix {
    public static void main(String[] args) {
        SearchA2DMatrix leetcode = new SearchA2DMatrix();
        System.out.println(leetcode.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 30));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int up = matrix.length - 1;
        int down = 0;
        int left;
        int right;
        int mid;
        int bet;
        while (down <= up) {
            bet = down + (up - down) / 2;
            if (matrix[bet][0] > target) {
                up = bet - 1;
            } else if (matrix[bet][0] < target) {
                left = 0;
                right = matrix[0].length - 1;
                while (left <= right) {
                    mid = left + (right - left) / 2;
                    if (matrix[bet][mid] > target) {
                        right = mid - 1;
                    } else if (matrix[bet][mid] < target) {
                        left = mid + 1;
                    } else {
                        return true;
                    }
                }
                down = bet + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
