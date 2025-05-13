package Stack.no0085;

import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle {
    public static void main(String[] args) {
        MaximalRectangle leetcode = new MaximalRectangle();
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        System.out.println(leetcode.maximalRectangle(matrix));
    }

    // TODO - Intuition: Convert the problem to largest rectangle histogram row wise.
    //  https://www.youtube.com/watch?v=dAVF2NpC3j4
    public int maximalRectangle(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        /// initializes dp to convert the matrix into an array of histograms
        for (int j = 0; j < matrix[0].length; j++) {
            dp[0][j] = matrix[0][j] == '1' ? 1 : 0;
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1 + dp[i - 1][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        int maximalRectangle = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            maximalRectangle = Math.max(maximalRectangle, largestRectangleArea(dp[i]));
        }
        return maximalRectangle;
    }

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        Stack<Tuple<Integer, Integer>> stack = new Stack<>();
        int largestArea = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            if (stack.isEmpty() || heights[i] >= stack.peek().getHeight()) {
                stack.push(new Tuple<>(i, heights[i]));
            } else {
                int startIndex = -1;
                while (!stack.isEmpty() && heights[i] < stack.peek().getHeight()) {
                    Tuple<Integer, Integer> toBePopped = stack.pop();
                    startIndex = toBePopped.getIndex();
                    int width = i - startIndex;
                    int height = toBePopped.getHeight();
                    largestArea = Math.max(width * height, largestArea);
                }
                if (stack.isEmpty()) {
                    stack.push(new Tuple<>(startIndex, heights[i]));
                } else if (heights[i] > stack.peek().getHeight()) {
                    stack.push(new Tuple<>(startIndex, heights[i]));
                }
            }
        }
        while (!stack.isEmpty()) {
            Tuple<Integer, Integer> toBePopped = stack.pop();
            int startIndex = toBePopped.getIndex();
            int width = heights.length - startIndex;
            int height = toBePopped.getHeight();
            largestArea = Math.max(width * height, largestArea);
        }
        return largestArea;
    }

    public static class Tuple<X, Y> {
        private X index;
        private Y height;

        public Tuple(X index, Y height) {
            this.index = index;
            this.height = height;
        }

        public Y getHeight() {
            return height;
        }

        public void setHeight(Y height) {
            this.height = height;
        }

        public X getIndex() {
            return index;
        }

        public void setIndex(X index) {
            this.index = index;
        }
    }
}
