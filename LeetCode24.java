public class LeetCode24 {
    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        LeetCode24 solution = new LeetCode24();
        System.out.println(solution.swapPairs(l));
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp;
        ListNode next;
        next = head.next.next;
        temp = head;
        head = head.next;
        head.next = temp;
        temp.next = next;
        return new ListNode(head.val, new ListNode(head.next.val, swapPairs(head.next.next)));
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
