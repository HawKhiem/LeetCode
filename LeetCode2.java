/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class LeetCode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode temp = l3;
        boolean carry;
        while (l1 != null || l2 != null) {
            int tempL1 = l1 != null ? l1.val : 0;
            int tempL2 = l2 != null ? l2.val : 0;
            int tempSum = temp.val;
            tempSum += tempL1 + tempL2;
            carry = tempSum > 9;
            temp.val = tempSum % 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            if (l1 != null || l2 != null || carry) {
                temp.next = new ListNode();
                temp.next.val = carry ? 1 : 0;
            }
            temp = temp.next;
        }
        return l3;
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
