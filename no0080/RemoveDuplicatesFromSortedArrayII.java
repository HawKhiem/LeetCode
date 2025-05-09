package no0080;

public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            int count = 1;
            /// push the right pointer to the end of a streak (a streak contains only numbers with the same value)
            while (right + 1 < nums.length && nums[right] == nums[right + 1]) {
                count++;
                right++;
            }
            /// we can have at most 2 numbers with the same value in streak
            int upper = Math.min(2, count);
            /// push the left pointer forward and at the same time replace any extra number in the streak with numbers of the next streak
            /// basically shifting the numbers to the left, to where there were extra numbers
            for (int i = 0; i < upper; i++) {
                nums[left] = nums[right];
                left++;
            }
            /// move to the next streak
            right++;
        }
        return left;
    }

    // TODO - an elegant solution:
    //      public int removeDuplicates(int[] nums) {
    //        int k = 0;
    //        boolean duplicate = false;
    //        for (int i = 1; i < nums.length; i++) {
    //            if (nums[k] == nums[i]) {
    //                if(!duplicate) {
    //                    k++;
    //                    nums[k] = nums[i];
    //                    duplicate = true;
    //                }
    //            } else {
    //                duplicate = false;
    //                k++;
    //                nums[k] = nums[i];
    //            }
    //        }
    //        return k + 1;
    //    }
}
