public class LeetCode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double[] nums3 = new double[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                nums3[i + j] = nums1[i++];
            } else {
                nums3[i + j] = nums2[j++];
            }
        }

        while (i < nums1.length) {
            nums3[i + j] = nums1[i++];
        }

        while (j < nums2.length) {
            nums3[i + j] = nums2[j++];
        }

        return nums3.length % 2 == 1 ? nums3[nums3.length / 2] : (nums3[nums3.length / 2] + nums3[nums3.length / 2 - 1]) / 2;
    }
}
