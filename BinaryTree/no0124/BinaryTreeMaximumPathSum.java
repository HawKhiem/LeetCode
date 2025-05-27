package BinaryTree.no0124;

public class BinaryTreeMaximumPathSum {
    // TODO: use DFS. At each node, we compute the path sum where we are able to take both sub trees, this is possible since we can always traverse from left->root->right at each node.
    //  we keep track of the maximum of those sums in the max array with only one element. We use an array to utilize the pass-by-reference feature in Java. Then we return the sum
    //  of the root.val and maximum sum of left and right sub tree (in case the root still has parents, we obviously have to choose between the right and left sub tree to form a path)
    //  https://www.youtube.com/watch?v=Hr5cWUld4vU
    public int maxPathSum(TreeNode root) {
        int[] max = new int[]{root.val};
        dfs(root, max);
        return max[0];
    }

    private int dfs(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int leftMax = dfs(root.left, max);
        int rightMax = dfs(root.right, max);
        leftMax = Math.max(leftMax, 0);
        rightMax = Math.max(rightMax, 0);
        max[0] = Math.max(max[0], root.val + leftMax + rightMax);
        return root.val + Math.max(leftMax, rightMax);
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
