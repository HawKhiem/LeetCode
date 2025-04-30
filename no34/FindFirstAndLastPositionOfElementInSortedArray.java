package no34;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        FindFirstAndLastPositionOfElementInSortedArray solution = new FindFirstAndLastPositionOfElementInSortedArray();
        System.out.println(Arrays.toString(solution.searchRange(nums, target)));
    }

    // TODO: find first index of target using Binary Search. If not -1 then perform another binary search for left part, then right part. Do that until both are -1. Return the value before being -1
    public int[] searchRange(int[] nums, int target) {
        int index = binarySearch(nums, target, 0, nums.length - 1);
        int left = index;
        int right = index;
        int temp_left = left;
        int temp_right = right;
        while (temp_left != -1) {
            temp_left = binarySearch(nums, target, 0, left - 1);
            if (temp_left != -1) {
                left = temp_left;
            }
        }
        while (temp_right != -1) {
            temp_right = binarySearch(nums, target, right + 1, nums.length - 1);
            if (temp_right != -1) {
                right = temp_right;
            }
        }
        return new int[]{left, right};
    }

    private int binarySearch(int[] nums, int target, int start, int end) {
        int low = start;
        int high = end;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
