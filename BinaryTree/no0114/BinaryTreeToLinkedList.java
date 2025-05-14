package BinaryTree.no0114;

public class BinaryTreeToLinkedList {
    // TODO - preorder traversal: root - left - right
    //  Follow up: Can you flatten the tree in-place (with O(1) extra space)?
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        /// Save the original right subtree
        TreeNode originalRight = root.right;

        /// Flatten the left subtree
        flatten(root.left);

        /// Attach the flattened left subtree to root.right
        root.right = root.left;
        root.left = null;

        /// Move to the end of the new right subtree
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }

        /// Flatten the saved right subtree and attach it
        flatten(originalRight);
        current.right = originalRight;
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
