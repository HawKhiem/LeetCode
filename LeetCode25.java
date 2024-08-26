public class LeetCode25 {
    private boolean found = false;

    public static void main(String[] args) {
        LeetCode25 leetcode = new LeetCode25();
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        l.next.next.next.next.next = new ListNode(6);
        l.next.next.next.next.next.next = new ListNode(7);
        l.next.next.next.next.next.next.next = new ListNode(8);
        l.next.next.next.next.next.next.next.next = new ListNode(9);
        l.next.next.next.next.next.next.next.next.next = new ListNode(10);
        l.next.next.next.next.next.next.next.next.next.next = new ListNode(11);
        System.out.println("Result: " + leetcode.reverseKGroup(l, 4));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode checkpoint = head;
        ListNode end = null;
        ListNode begin = head;
        int counter = 0;
        while (head != null) {
            if (counter == k) {
                checkpoint.next = reverseKGroup(head, k);
                head = null;
                counter = 0;
            } else {
                begin = head;
                head = head.next;
                begin.next = end;
                end = begin;
                counter++;
            }
        }
        if (counter != k && checkpoint != null && found) {
            checkpoint.next = (reverse(checkpoint.next));
            found = false;
        }
        if (counter != k && checkpoint != null && checkpoint.next == null) {
            found = true;
        }

        return begin;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (head != null) {
            cur = head;
            head = head.next;
            cur.next = prev;
            prev = cur;
        }
        return cur;
    }

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

        public String toString() {
            return next != null ? val + "->" + next : val + "";
        }
    }
}
