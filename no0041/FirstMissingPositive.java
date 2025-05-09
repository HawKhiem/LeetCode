package no0041;

public class FirstMissingPositive {
    public static void main(String[] args) {
        FirstMissingPositive leetcode = new FirstMissingPositive();
        int[] nums = {3, 4, -1, 1};
        System.out.println(leetcode.firstMissingPositive(nums));
    }

    // TODO - naive approach: create a visited array from 1 to n (length of the array) then mark all the visited ones. The first ones not visited is the missing number
    //  O(n) time, O(n) space
    //     static int missingNumber(int[] arr) {
    //        int n = arr.length;
    //        // To mark the occurrence of elements
    //        boolean[] vis = new boolean[n];
    //        for (int i = 0; i < n; i++) {
    //            // if element is in range from 1 to n
    //            // then mark it as visited
    //            if (arr[i] > 0 && arr[i] <= n)
    //                vis[arr[i] - 1] = true;
    //        }
    //        // Find the first element which is unvisited
    //        // in the original array
    //        for (int i = 1; i <= n; i++) {
    //            if (!vis[i - 1]) {
    //                return i;
    //            }
    //        }
    //        // if all elements from 1 to n are visited
    //        // then n+1 will be first positive missing number
    //        return n + 1;
    //    }

    // TODO: Better idea - similar to Cycle Sort, we will try to move each element to its correct position based on its value. For example: x should be place at the
    //  (x-1)-th index. Then we iterate the array again and look for the first place where the number doesn't match its index, the missing number is index + 1.
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            /// Only move to the next cell if the number at the current cell is out of range (that means its supposed index is outside of the given array)
            /// or its supposed index currently holds a number equal to itself (which would cause infinite swapping)
            while (nums[i] > 0 && nums[i] - 1 != i && nums[i] - 1 < nums.length && nums[nums[i] - 1] != nums[i]) {
                int index = nums[i] - 1;
                swap(nums, i, index);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
