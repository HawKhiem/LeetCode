public class LeetCode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode next = head;
        while (next != null) {
            length++;
            next = next.next;
        }
        int index = length - n;
        return removeNthFromEndRec(head, index);

    }

    private ListNode removeNthFromEndRec(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (n == 0) {
            return head.next;
        } else {
            return new ListNode(head.val, removeNthFromEndRec(head.next, n - 1));
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

// Stolen solution:
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode fast = head, slow = head;
//        for (int i = 0; i < n; i++) fast = fast.next;
//        if (fast == null) return head.next;
//        while (fast.next != null) {
//            fast = fast.next;
//            slow = slow.next;
//        }
//        slow.next = slow.next.next;
//        return head;
//    }
