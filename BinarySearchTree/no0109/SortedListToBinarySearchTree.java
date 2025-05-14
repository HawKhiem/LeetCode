package BinarySearchTree.no0109;

import java.util.Arrays;

public class SortedListToBinarySearchTree {
    // TODO - naive approach: convert the list to an array and then convert to the BST
    public TreeNode sortedListToBSTNaive(ListNode head) {
        if (head == null) {
            return null;
        }
        /// convert ListNode to an array
        int length = 1;
        ListNode current = head;
        while (current.next != null) {
            length++;
            current = current.next;
        }
        int[] nums = new int[length];
        int i = 0;
        current = head;
        while (current != null) {
            nums[i] = current.val;
            i++;
            current = current.next;
        }
        return sortedArrayToBST(nums);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int mid = nums.length / 2;
        int rootValue = nums[mid];
        TreeNode root = new TreeNode(rootValue);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));
        return root;
    }

    // TODO - convert directly from List to BST
//         public TreeNode sortedListToBST(ListNode head) {
//            if(head==null)
//                return null;
//            if(head.next==null)
//                return new TreeNode(head.val);
//            ListNode slow=head;
//            ListNode fast=head.next.next;
//            // find the middle element, since the fast pointer is moving twice as fast as the slow one.
//            // In the end, the slow pointer is gonna point at the middle of the list
//            while(fast!=null && fast.next!=null){
//                slow=slow.next;
//                fast=fast.next.next;
//            }
//            // root is the next element after slow
//            TreeNode root = new TreeNode(slow.next.val);
//            ListNode righthalf=slow.next.next;
//            // without this line, there would be stack overflow
//            slow.next=null;
//            root.left=sortedListToBST(head);
//            root.right=sortedListToBST(righthalf);
//            return root;
//        }
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode mid = slow;
        /// find the middle element, since the fast pointer is moving twice as fast as the slow one.
        /// In the end, the slow pointer will point at the middle of the list
        while (fast != null && fast.next != null) {
            mid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        /// slow now points to the middle of the list
        TreeNode root = new TreeNode(slow.val);
        /// without this line, there would be stack overflow. This will essentially separate the list into two parts. One being the left sub tree,
        /// spanning from head to mid and one is the right subtree. Spanning from slow.next to the end
        mid.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
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

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
