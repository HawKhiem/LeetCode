package BinarySearch.no0033;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] a = new int[]{1, 3};
        int target = 3;
        SearchInRotatedSortedArray leetcode = new SearchInRotatedSortedArray();
        System.out.println(leetcode.findMin(a));
        System.out.println(leetcode.binarySearch(a, target, 0, a.length - 1));
        System.out.println(leetcode.search(a, target));

    }

    // TODO: Think of Binary Search due to the requirement of O(logn). Algo:
    //  - First, find the index of the smallest number
    //  - Check if the smallest number is equal to the target, if not we can perform Binary Search on the two halves
    public int search(int[] nums, int target) {
        /// Find the index of the smallest number
        int smallestIndex = findMin(nums);

        /// early termination
        if (nums[smallestIndex] > target) {
            return -1;
        }
        /// Perform a normal Binary Search
        if (smallestIndex == 0) {
            int low = 0;
            int high = nums.length - 1;
            return binarySearch(nums, target, low, high);
        }

        /// Binary Search in the left part if target is larger than or equal to the first element
        else if (target >= nums[0]) {
            int low = 0;
            int high = smallestIndex - 1;
            return binarySearch(nums, target, low, high);
        }
        /// Binary Search in the right part otherwise
        else {
            int low = smallestIndex;
            int high = nums.length - 1;
            return binarySearch(nums, target, low, high);
        }
    }

    private int binarySearch(int[] nums, int target, int l, int h) {
        int low = l;
        int high = h;
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

    // TODO: Minimum in a Sorted and Rotated Array
    private int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        /// How do we terminate the search? One way could be to check if the mid is smaller than both of its adjacent, then we return mid.
        /// This would require a lot of condition checks like if adjacent indexes are valid or not and then comparing mid with both.
        /// We use an interesting fact here: If arr[low] < arr[high], then the current subarray is sorted, So we return arr[low].
        while (low < high) {
            /// the subarray is already sorted and we return the index of the first element as it is guaranteed to be the smallest
            if (nums[low] < nums[high]) {
                return low;
            }
            int mid = (low + high) / 2;
            /// If arr[mid] > arr[high], it means arr[low-mid] is sorted (Reason: A rotation must have happened and so
            /// the larger part of the original array is now shifted to the front - left of mid).
            /// Therefore we have to search for the minimum in the back (right part of mid). So we change low = mid + 1
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            }
            /// If arr[mid] <= arr[high], it means arr[mid-high] is sorted, with arr[mid] being the smallest. So we have
            /// to search in the left part, mid also included to make sure we don't miss anything.
            else if (nums[mid] <= nums[high]) {
                high = mid;
            }
        }
        return low;
    }
}
