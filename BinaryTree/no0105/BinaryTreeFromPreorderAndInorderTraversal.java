package BinaryTree.no0105;

import java.util.Arrays;

public class BinaryTreeFromPreorderAndInorderTraversal {
    // TODO - The logic behind this is, in preorder the root always comes first then comes the left subtree, then the right one
    //  in inorder, the left sub tree comes first, then the root, then the right one. Therefore we first identify the root, which is
    //  the first element in preorder, then find its index in the inorder array. All the values that come before such index are those
    //  that belong to the left subtree, those coming after that index are those belonging to the right subtree. In the preorder, as
    //  mentioned earlier, after the root comes the left subtree then the right one. The index in inorder basically tells us how many
    //  nodes are in the left subtree, i.e if the index of the root is 1, then there is exactly one node in the left subtree. We can base
    //  on this fact to split the rest of the preorder array.
    //  Summary: inorder: left - root - right | preorder: root - left - right
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        /// by definition the first preorder value is always the root
        TreeNode root = new TreeNode(preorder[0]);
        int rootIndex = findIndex(inorder, root.val);
        /// we start from 1 to skip the root, we take till rootIndex + 1 to make sure the subarray is of length rootIndex (length of left subtree)
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, rootIndex + 1), Arrays.copyOfRange(inorder, 0, rootIndex));
        /// the rest should be of the right subtree
        root.right = buildTree(Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length), Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length));
        return root;
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
    // TODO - a way faster solution:
    //    int preIdx;
    //    int inIdx;
    //    public TreeNode buildTree(int[] preorder, int[] inorder) {
    //        preIdx = 0;
    //        inIdx = 0;
    //        return build(preorder, inorder, Integer.MAX_VALUE);
    //    }
    //    public TreeNode build(int[] preorder, int[] inorder, int limit) {
    //        if (preIdx == preorder.length) {
    //            return null;
    //        } else if (inorder[inIdx] == limit) {
    //            inIdx++;
    //            return null;
    //        }
    //        int rootVal = preorder[preIdx++];
    //        TreeNode node = new TreeNode(rootVal);
    //        node.left = build(preorder, inorder, rootVal);
    //        node.right = build(preorder, inorder, limit);
    //        return node;
    //    }
}
