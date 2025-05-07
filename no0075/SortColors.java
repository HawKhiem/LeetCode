package no0075;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        SortColors sc = new SortColors();
        int[] nums = {2, 0, 2, 1, 1, 0};
        sc.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    // TODO: The idea is similar to quick sort, we try to partition the array and put all the 0s to the left and the 2s to the right, we can
    //  skip the 1s for now
    //  https://www.youtube.com/watch?v=4xbWSRZHqac
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int curr = 0;
        while (curr <= right) {
            /// skip 1s
            if (nums[curr] == 1) {
                curr++;
            }
            /// swap the current index with left, basically bring all the 0s to the left, then increment left as well as current
            /// how can we be certain and increment current? We know for a fact that everything up to left should be sorted and all
            /// numbers up to then will be 0. How do we know that at left there isn't a 2, well because if it was, we would it have shifted
            /// to right long ago, since left is always to the left of curr
            else if (nums[curr] == 0) {
                swap(nums, left, curr);
                left++;
                curr++;
            }
            /// swap the current index with right, basically bring all the 2s to the right, decrement right. Why don't we increment current?
            /// Since swapping 2 to the right would also mean swapping something to the left (to current). We have to deal with the situation
            /// when the number that is being swapped to current is a 0, then it is not yet in the correct position, we have to swap it
            /// with left to make it correct.
            else if (nums[curr] == 2) {
                swap(nums, right, curr);
                right--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // TODO: we could use bucket sort, since we know the array only has 3 types of numbers, 0, 1, 2. We could iterate through the array once
    //  and count the numbers of each type of number then we can iterate another time and build the array
}
