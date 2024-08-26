public class LeetCode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        int min = Integer.MAX_VALUE;
        int next = 0;
        int done = 0;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && lists[i].val < min) {
                min = lists[i].val;
                next = i;
            } else if (lists[i] == null) {
                done++;
            }
            if (done == lists.length) {
                return null;
            }
        }
        if (lists[next] != null) {
            lists[next] = lists[next].next;
        }
        return new ListNode(min, mergeKLists(lists));
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

// Stolen solution
//     public ListNode mergeKLists(ListNode[] lists) {
//        ListNode ans = new ListNode();
//        int l = 0;
//        int r = lists.length - 1;
//        ans = mergeSort(lists, l, r);
//        return ans;
//    }
//
//    public ListNode mergeSort(ListNode[] lists, int l, int r) {
//        if (l > r) {
//        return null;
//    }
//        if (l == r) {
//            return lists[l];
//        }
//        int m = l + (r-l)/2;
//
//        ListNode L = mergeSort(lists, l, m);
//        ListNode R = mergeSort(lists, m+1, r);
//        return sort(L, R);
//    }
//
//    public ListNode sort(ListNode list1, ListNode list2) {
//        if(list1 == null) {
//            return list2;
//        }
//        else if(list2 == null){
//            return list1;
//        }
//
//        ListNode ans = new ListNode();
//        ListNode finala = ans;
//
//        while(list1 != null && list2 != null) {
//            if(list2.val >= list1.val) {
//                finala.next = list1;
//                list1 = list1.next;
//            }
//            else {
//                finala.next = list2;
//                list2 = list2.next;
//            }
//            finala = finala.next;
//        }
//        while(list1 != null)
//        {
//            finala.next = list1;
//            list1 = list1.next;
//            finala = finala.next;
//        }
//        while(list2 != null)
//        {
//            finala.next = list2;
//            list2 = list2.next;
//            finala = finala.next;
//        }
//
//        return ans.next;
//    }
