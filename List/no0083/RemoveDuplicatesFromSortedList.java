package List.no0083;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        /// if the head is null then return it directly
        if (head == null) {
            return head;
        }
        /// instantiate a left pointer, which is always before the right pointer.
        /// Its next is always gonna be the right pointer, if the node at which the right pointer point to should be taken
        ListNode left = new ListNode();
        /// let it point to the right pointer
        left.next = head;
        ListNode right = head;
        /// we also alter right so we should make sure its not null
        while (right.next != null) {
            /// it means the current node is not part of a streak, we can take it
            if (right.val != right.next.val) {
                left.next = right;
                right = right.next;
                left = left.next;
            } else {
                /// if the current node is part of a streak,
                /// we will skip through it using the right pointer
                while (right.next != null && right.val == right.next.val) {
                    /// in case the head is also part of the streak, then we should update it as well
                    if (right == head) {
                        head = head.next;
                    }
                    right = right.next;
                }
                /// possible next of left
                left.next = right;
            }
        }
        return head;
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
