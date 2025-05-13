package DFS.no0104;

import java.util.Stack;

public class MaximumDepthOfBinaryTree {
    // TODO - Recursive DFS
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    // TODO - Iterative DFS (Memory limit exceeded)
    public int maxDepthIter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        /// X is the tree node, Y is the level of that node
        Stack<Tuple<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Tuple<>(root, 1));
        int result = 1;
        while (!stack.isEmpty()) {
            Tuple<TreeNode, Integer> tuple = stack.pop();
            if (tuple.getNode() != null) {
                /// update result to the max level as we go
                result = Math.max(result, tuple.getLevel());
                stack.push(new Tuple<>(root.left, tuple.getLevel() + 1));
                stack.push(new Tuple<>(root.right, tuple.getLevel() + 1));
            }
        }
        return result;
    }

    public static class Tuple<X, Y> {
        private X node;
        private Y level;

        public Tuple(X node, Y level) {
            this.node = node;
            this.level = level;
        }

        public X getNode() {
            return node;
        }

        public void setNode(X node) {
            this.node = node;
        }

        public Y getLevel() {
            return level;
        }

        public void setLevel(Y level) {
            this.level = level;
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
