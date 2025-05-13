package BinarySearchTree.no103;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        return zigzagLevelOrderBfs(root, false);
    }

    // TODO - the same idea as the level order traversal, only difference is we keep track whether we add new elements from left to right or vice versa
    private List<List<Integer>> zigzagLevelOrderBfs(TreeNode root, boolean reverse) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return result;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int qLength = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < qLength; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    level.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if (!level.isEmpty() && !reverse) {
                result.add(level);
                reverse = true;
            } else if (!level.isEmpty() && reverse) {
                Collections.reverse(level);
                result.add(level);
                reverse = false;
            }
        }
        return result;
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
