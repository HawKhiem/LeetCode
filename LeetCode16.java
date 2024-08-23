import java.util.Arrays;

public class LeetCode16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target) {
                    return target; // Found the exact match
                }

                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum; // Update result if closer to target
                }

                if (sum < target) {
                    left++; // Move left pointer to increase sum
                } else {
                    right--; // Move right pointer to decrease sum
                }
            }
        }

        return result;
    }
}
