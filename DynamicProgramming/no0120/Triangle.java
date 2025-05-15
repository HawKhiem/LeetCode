package DynamicProgramming.no0120;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty()) {
            return 0;
        }
        Integer[][] dp = new Integer[triangle.size()][triangle.size()];
        return minimumTotalHelper(triangle, dp, 0, 0);
    }

    private int minimumTotalHelper(List<List<Integer>> triangle, Integer[][] dp, int depth, int index) {
        if (depth == triangle.size() - 1) {
            return triangle.get(depth).get(index);
        }
        if (dp[depth][index] != null) {
            return dp[depth][index];
        }
        int result = triangle.get(depth).get(index) + Math.min(minimumTotalHelper(triangle, dp, depth + 1, index), minimumTotalHelper(triangle, dp, depth + 1, index + 1));
        dp[depth][index] = result;
        return result;
    }

    public int minimumTotalNaive(List<List<Integer>> triangle) {
        if (triangle.isEmpty()) {
            return 0;
        }
        List<Integer> sums = new ArrayList<>();
        backtracking(0, sums, 0, 0, triangle);
        return sums.get(0);
    }

    // TODO - naive approach: use backtracking - Time Limit Exceeded
    private void backtracking(int index, List<Integer> sums, int sum, int depth, List<List<Integer>> triangle) {
        if (depth == triangle.size()) {
            if (sums.isEmpty()) {
                sums.add(sum);
            } else {
                sums.add(0, Math.min(sums.get(0), sum));
            }
            return;
        }
        for (int i = 0; i <= 1; i++) {
            sum += triangle.get(depth).get(index);
            backtracking(index + i, sums, sum, depth + 1, triangle);
            sum -= triangle.get(depth).get(index);
        }
    }
}
