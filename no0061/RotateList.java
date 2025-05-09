package no0061;

public class RotateList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        RotateList leetcode = new RotateList();
        leetcode.rotateRight(head, 1);
        for (ListNode temp = head; temp != null; temp = temp.next) {
            System.out.println(temp.val);
        }
    }

    // TODO: Use a FIFO queue to store the nodes as we iterate through the list.
    public ListNode rotateRight(ListNode head, int k) {
        /// If the linked list is empty or no rotations are
        /// needed, then return the original linked list
        if (k == 0 || head == null) {
            return head;
        }

        ListNode curr = head;
        int len = 1;

        /// Find the length of linked list
        while (curr.next != null) {
            curr = curr.next;
            len += 1;
        }

        /// Modulo k with length of linked list to handle
        /// large values of k
        k = len - (k % len);

        if (k == 0) {
            return head;
        }

        /// Make the linked list circular
        curr.next = head;

        /// Traverse the linked list to find the kth node
        curr = head;
        for (int i = 1; i < k; i++) {
            curr = curr.next;
        }

        /// Update the (k + 1)th node as the new head
        head = curr.next;

        /// Break the loop by updating next pointer of kth node
        curr.next = null;
        return head;
    }


    /// Definition for singly-linked list.
    public static class ListNode {
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
