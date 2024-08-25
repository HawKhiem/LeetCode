import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        if (n < 4)
            return result;
        Arrays.sort(nums);

        for (int a = 0; a < n - 3; a++) {
            // skip duplicates
            if (a > 0 && nums[a] == nums[a - 1])
                continue;
            // Early termination, when the smallest possible sum is larger than target
            if (sum4(nums[a], nums[a + 1], nums[a + 2], nums[a + 3]) > target)
                break;
            // Early termination, when the largest possible sum is smaller than target
            if (sum4(nums[a], nums[n - 1], nums[n - 2], nums[n - 3]) < target)
                continue;

            for (int b = a + 1; b < n - 2; b++) {
                // skip duplicates
                if (b > a + 1 && nums[b] == nums[b - 1])
                    continue;
                // Early termination, when the smallest possible sum is larger than target
                if (sum4(nums[a], nums[b], nums[b + 1], nums[b + 2]) > target)
                    break;
                // Early termination, when the largest possible sum is smaller than target
                if (sum4(nums[a], nums[b], nums[n - 1], nums[n - 2]) < target)
                    continue;

                int left = b + 1;
                int right = n - 1;
                int expected = target - nums[a] - nums[b];

                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum == expected) {
                        result.add(Arrays.asList(nums[a], nums[b], nums[left], nums[right]));
                        left++;
                        right--;
                        // skip duplicates
                        while (left < right && nums[left] == nums[left - 1])
                            left++;
                        while (left < right && nums[right] == nums[right + 1])
                            right--;
                    } else if (sum < expected) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }

    // avoid integers overflow
    private long sum4(int a, int b, int c, int d) {
        return (long) a + b + c + d;
    }
}
