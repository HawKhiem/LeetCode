package no0094;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        BinaryTreeInorderTraversal leetcode = new BinaryTreeInorderTraversal();
        System.out.println(leetcode.inorderTraversal(leetcode.new TreeNode(1, null, leetcode.new TreeNode(2, leetcode.new TreeNode(3), null))));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        inorderTraversalRec(root, result, stack);
        return result;
    }

    private void inorderTraversalRec(TreeNode root, List<Integer> result, Stack<TreeNode> stack) {
        if (root == null) {
            return;
        }
        /// go left
        while (root.left != null) {
            stack.push(root);
            root = root.left;
        }
        result.add(root.val);
        if (root.right != null) {
            inorderTraversalRec(root.right, result, new Stack<>());
        }
        while (!stack.isEmpty()) {
            root = stack.pop();
            result.add(root.val);
            if (root.right != null) {
                inorderTraversalRec(root.right, result, new Stack<>());
            }
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
