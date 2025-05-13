package no0098;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // TODO - naive approach would be to use DFS to check for every single node if its subtrees are valid - O(n^2)
    //  Better approach:
    //  https://www.youtube.com/watch?v=Z4qMNdwr_Bw
    //  https://www.youtube.com/watch?v=s6ATEkipzow
    private boolean isValid(TreeNode root, long left, long right) {
        if (root == null) {
            return true;
        }
        // root.val <= left || root.val >= right
        if (!(root.val < right && root.val > left)) {
            return false;
        }
        return isValid(root.left, left, root.val) && isValid(root.right, root.val, right);
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
