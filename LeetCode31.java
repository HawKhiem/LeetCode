public class LeetCode31 {
    public void nextPermutation(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int pivot = -1;
        // TODO: find the right most number that is smaller than the next one, that is gonna be the pivot
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] < nums[i + 1]) {
                pivot = i;
            }
        }

        // TODO: if there is no such number, reverse the whole array
        if (pivot == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int swap = nums.length - 1;
        // TODO: find the right most number that is larger than the pivot
        for (int i = nums.length - 1; i > pivot; i--) {
            if (nums[i] > nums[pivot]) {
                swap = i;
                break;
            }
        }

        // TODO: swap the pivot and the swap
        swap(nums, pivot, swap);

        reverse(nums, pivot + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// TODO: https://www.geeksforgeeks.org/next-permutation/
// TODO: Explanation: The next permutation is gonna be slightly larger than the current one. That means we have to alter the tail or the right most part first.
//  Hence first we have to find the right most number that is smaller than the next one, which is gonna be our pivot.
//  This is gonna be swaped with the smallest number on the right that is still larger than the pivot.
//  How can we be sure that the the right most number is the smallest one that is still larger than the pivot?
//  We can figure from the last step of the algorithm. The array starting from the pivot + 1 is gonna be descending, since the pivot is the last number that is
//  still smaller that its successor.
//  That means the right most number is the smallest one that is still larger than the pivot.
//  Then we reverse the whole array from the pivot + 1 to the end.


