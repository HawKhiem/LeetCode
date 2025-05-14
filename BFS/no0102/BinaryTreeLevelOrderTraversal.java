package BFS.no0102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    // TODO - Breadth First Search
    //  https://www.youtube.com/watch?v=6ZnyEApgFYg
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
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
            if (!level.isEmpty()) {
                result.add(level);
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

    // TODO - a beautiful solution:
    //     public List<List<Integer>> levelOrder(TreeNode root) {
    //        List<List<Integer>> levelOrderRes = new LinkedList<>();
    //        if(root==null){
    //            return levelOrderRes;
    //        }
    //        helper(root, 0, levelOrderRes);
    //        return levelOrderRes;
    //    }
    //    public void helper(TreeNode p, int level, List<List<Integer>> levelOrderRes){
    //        if(p== null){
    //            return;
    //        }
    //        if(levelOrderRes.size()== level) {
    //            levelOrderRes.add(new LinkedList<>());
    //        }
    //        levelOrderRes.get(level).add(p.val);
    //        helper(p.left, level+1, levelOrderRes);
    //        helper(p.right, level+1, levelOrderRes);
    //    }
}
