package List.no0086;

public class PartitionList {
    public static void main(String[] args) {
        PartitionList leetcode = new PartitionList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        System.out.println(leetcode.partition(head, 3));
//        head = new ListNode(2);
//        head.next = new ListNode(1);
//        System.out.println(leetcode.partition(head, 2));

    }

    public ListNode partition(ListNode head, int x) {
        ListNode left = null;
        ListNode right = null;
        ListNode cur = head;
        ListNode leftHead = null;
        ListNode rightHead = null;
        while (cur != null) {
            if (cur.val < x) {
                if (left == null) {
                    leftHead = cur;
                    left = cur;
                } else {
                    left.next = cur;
                    left = left.next;
                }
            } else {
                if (right == null) {
                    rightHead = cur;
                    right = cur;
                } else {
                    right.next = cur;
                    right = right.next;
                }
            }
            cur = cur.next;
        }
        if (left != null) {
            left.next = rightHead;
        } else {
            leftHead = rightHead;
        }
        if (right != null) {
            right.next = null;
        }
        return leftHead;
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
    }
}
