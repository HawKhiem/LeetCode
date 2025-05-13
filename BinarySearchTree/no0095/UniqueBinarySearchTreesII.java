package BinarySearchTree.no0095;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    public static void main(String[] args) {
        UniqueBinarySearchTreesII leetcode = new UniqueBinarySearchTreesII();
        System.out.println(leetcode.generateTrees(3));
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[][] dp = new List[n + 1][n + 1];
        return generate(1, n, dp);
    }

    // TODO - add dynamic programming to speed it up
    private List<TreeNode> generate(int left, int right, List<TreeNode>[][] dp) {
        /// redundant, it is already handled in the for loop, since we are looping till <= right (so the case where left == right is tackled)
//        if (left == right) {
//            List<TreeNode> result = new ArrayList<>();
//            result.add(new TreeNode(left));
//            return result;
//        }
        /// we still have to add in a null subtree so that in case the root does not have any left subtrees, and only right subtrees, the
        /// for loop could still be executed
        if (left > right) {
            List<TreeNode> result = new ArrayList<>();
            result.add(null);
            return result;
        }
        if (dp[left][right] != null) {
            return dp[left][right];
        }
        List<TreeNode> result = new ArrayList<>();
        for (int value = left; value <= right; value++) {
            /// if we didn't add the the null subtree up above, then in case value - 1 < left (for loop still valid in case value = left), then
            /// the leftTrees list would contain no element, and the nested for loop would not be executed, even though the root has right subtrees
            List<TreeNode> leftTrees = generate(left, value - 1, dp);
            List<TreeNode> rightTrees = generate(value + 1, right, dp);
            for (TreeNode lt : leftTrees) {
                for (TreeNode rt : rightTrees) {
                    TreeNode root = new TreeNode(value, lt, rt);
                    result.add(root);
                }
            }
        }
        /// cool code construct, assign then return
        return dp[left][right] = result;
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
