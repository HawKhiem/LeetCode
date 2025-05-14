package BackTracking.no0113;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        backtracking(result, root, targetSum - root.val, temp);
        return result;
    }

    private void backtracking(List<List<Integer>> result, TreeNode root, int targetSum, List<Integer> temp) {
        if (targetSum == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(temp));
        }
        if (root == null) {
            return;
        }
        if (root.left != null) {
            temp.add(root.left.val);
            backtracking(result, root.left, targetSum - root.left.val, temp);
            temp.remove(temp.size() - 1);
        }
        if (root.right != null) {
            temp.add(root.right.val);
            backtracking(result, root.right, targetSum - root.right.val, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
