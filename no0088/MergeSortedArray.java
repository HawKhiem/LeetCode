package no0088;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length == 0) {
            return;
        }
        int one = 0;
        int two = 0;
        while (one < nums1.length) {
            if (nums1[one] == 0) {
                nums1[one] = nums2[two];
                one++;
                two++;
            } else if (nums1[one] < nums2[two]) {
                one++;
            } else if (nums1[one] >= nums2[two]) {
                int temp = nums1[one];
                nums1[one] = nums2[two];
                nums2[two] = temp;
                one++;
                two++;
            }
        }
    }
}
