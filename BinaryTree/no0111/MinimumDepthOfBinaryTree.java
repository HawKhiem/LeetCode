package BinaryTree.no0111;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {
    // TODO - naive approach: solve using DFS -> slow
    public int minDepthNaive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return 1 + minDepthNaive(root.right);
        }
        if (root.right == null) {
            return 1 + minDepthNaive(root.left);
        }
        return 1 + Math.min(minDepthNaive(root.left), minDepthNaive(root.right));
    }

    // TODO - use BFS: faster, since we will terminate as soon as we found a node without children
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int queueLength = queue.size();
            for (int i = 0; i < queueLength; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    if (node.left == null && node.right == null) {
                        return depth;
                    }
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            depth++;
        }
        return depth;
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
