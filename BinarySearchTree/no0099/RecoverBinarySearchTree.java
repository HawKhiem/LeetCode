package BinarySearchTree.no0099;

import java.util.ArrayList;
import java.util.List;

public class RecoverBinarySearchTree {
    TreeNode firstNode;
    TreeNode secondNode;
    TreeNode prevNode;

    // TODO - Follow up: A solution using O(n) space is pretty straight-forward. Could you devise a constant O(1) space solution?
    //  Insight: Pretty similar to the naive approach - Create 3 nodes, firstNode, secondNode and prevNode
    //  Since we are traversing the tree inorder, prevNode.val should always be smaller than root.val, otherwise we know that those two values
    //  must be swapped

    // TODO - naive approach: find the inorder list of values in the tree.
    //  Those two values that should be swapped would appear unsorted in the list
    //  https://www.youtube.com/watch?v=2ahCLZ3x1iI
    public void recoverTreeNaive(TreeNode root) {
        if (root == null) {
            return;
        }
        List<Integer> values = new ArrayList<>();
        inorderTraversalNaive(root, values);

        Integer first = null;
        Integer second = null;

        int prev = values.get(0);
        for (int i = 1; i < values.size(); i++) {
            if (prev > values.get(i) && first == null) {
                first = prev;
            }
            if (prev > values.get(i) && first != null) {
                second = values.get(i);
            }
            prev = values.get(i);
        }
        searchAndUpdate(root, first, second);

    }

    private void searchAndUpdate(TreeNode root, Integer first, Integer second) {
        if (root == null) {
            return;
        }
        searchAndUpdate(root.left, first, second);

        if (root.val == first) {
            root.val = second;
        } else if (root.val == second) {
            root.val = first;
        }

        searchAndUpdate(root.right, first, second);
    }

    private void inorderTraversalNaive(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }
        inorderTraversalNaive(root.left, values);
        values.add(root.val);
        inorderTraversalNaive(root.right, values);
    }

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root);
        /// swap the values
        if (firstNode != null && secondNode != null) {
            int temp = secondNode.val;
            secondNode.val = firstNode.val;
            firstNode.val = temp;
        }
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);

        if (prevNode != null && prevNode.val > root.val && firstNode == null) {
            firstNode = prevNode;
        }
        if (prevNode != null && prevNode.val > root.val && firstNode != null) {
            secondNode = root;
        }

        prevNode = root;

        inorderTraversal(root.right);
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
