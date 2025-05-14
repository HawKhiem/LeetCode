package BinaryTree.no0106;

import java.util.Arrays;

public class BinaryTreeFromInorderAndPostOrderTraversal {

    // TODO - Reminder:
    //  postorder: left - right - root
    //  inorder: left - root - right
    //  Idea: the last index in postorder is gonna be the root. We then proceed to find its index in inorder array, left to it is the left subtree, right is right subtree
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        int root = postorder[postorder.length - 1];
        TreeNode rootNode = new TreeNode(root);
        int rootIndex = findIndex(inorder, root);
        rootNode.left = buildTree(Arrays.copyOfRange(inorder, 0, rootIndex), Arrays.copyOfRange(postorder, 0, rootIndex));
        rootNode.right = buildTree(Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length), Arrays.copyOfRange(postorder, rootIndex, postorder.length - 1));
        return rootNode;
    }

    private int findIndex(int[] nums, int value) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == value) {
                return i;
            }
        }
        return -1;
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
    //    int in = 0;
    //    int post = 0;
    //    public TreeNode buildTree(int[] inorder, int[] postorder) {
    //        this.in = inorder.length - 1;
    //        this.post = postorder.length - 1;
    //        return buildTree(inorder, postorder, Integer.MAX_VALUE);
    //    }
    //    private TreeNode buildTree(int[] inorder, int[] postorder, int target) {
    //        if (post < 0 || inorder[in] == target) {
    //            return null;
    //        }
    //        TreeNode root = new TreeNode(postorder[post]);
    //        post--;
    //        root.right = buildTree(inorder, postorder, root.val);
    //        in--;
    //        root.left = buildTree(inorder, postorder, target);
    //        return root;
    //    }
}
