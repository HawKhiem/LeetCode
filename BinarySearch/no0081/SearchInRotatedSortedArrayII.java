package BinarySearch.no0081;

public class SearchInRotatedSortedArrayII {
    public static void main(String[] args) {
        SearchInRotatedSortedArrayII searchInRotatedSortedArrayII = new SearchInRotatedSortedArrayII();
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int target = 0;
        System.out.println(searchInRotatedSortedArrayII.search(nums, target));
    }

    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return true;
            }

            /// it means the array is sorted in [left, mid]
            if (nums[left] < nums[mid]) {
                /// if the target is in the left portion
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                }
                /// otherwise it is in the right portion
                else {
                    left = mid + 1;
                }
            }
            /// it means the array is sorted in [mid, right]
            else if (nums[left] > nums[mid]) {
                /// if the target is in the right portion
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                }
                /// otherwise it is in the left portion
                else {
                    right = mid - 1;
                }
            }
            /// left is equal to mid. Since we know nums[mid] is not equal to target, it means we can ignore nums[left]
            else {
                left++;
            }
        }
        return false;
    }
}
