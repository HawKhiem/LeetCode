public class LeetCode35 {

    public static void main(String[] args) {
        int[] nums = {1};
        int target = 0;
        LeetCode35 solution = new LeetCode35();
        System.out.println(solution.searchInsert(nums, target));
    }

    // TODO: use Binary Search, which would normally terminate when low is greater than high, so instead of -1 return low when done
    //  It makes sense since in the last iteration when target is not found, low is currently equal to high. If out target is greater than
    //  mid (which is also low in this case) then low would be incremented, which would correspond to the position we want to put target into
    //  In case target is smaller than mid, then high would be decremented but low stay the same, and that is also where we want to put target into
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
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
        return low;
    }
}
