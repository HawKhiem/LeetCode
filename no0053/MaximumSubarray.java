package no53;

public class MaximumSubarray {
    public static void main(String[] args) {
        MaximumSubarray leetcode = new MaximumSubarray();
        int[] nums = {1, -2, 0};
        System.out.println(leetcode.maxSubArray(nums));
    }

    // TODO - naive approach: Time limit exceeded (This happens to be similar Kadane's algorithm.
    //  Mine is slow because I calculated the sum with the subroutine, and also hard to read code)
    public int maxSubArrayNaive(int[] nums) {
        int start = 0;
        int sum = nums[start];
        for (int i = 0; i < nums.length; i++) {
            /// we might want to focus on the positive numbers. start gives us the start index of the sub array
            if (nums[i] >= 0) {
                /// compare to see if the sum of till the current index is larger than the number at the index itself. If it is the case we let the current index join the gang
                if (sumFromTo(nums, start, i) > nums[i]) {
                    sum = Math.max(sum, sumFromTo(nums, start, i));
                }
                /// otherwise we can ditch the gang and continue on with the current index
                else {
                    sum = Math.max(sum, nums[i]);
                    start = i;
                }
            }
            /// for some edge cases, since we will always take sum to be the first number in the beginning
            else if (nums[i] > sum) {
                sum = nums[i];
                start = i;
            }
        }
        return sum;
    }

    private int sumFromTo(int[] nums, int from, int to) {
        int sum = 0;
        for (int i = from; i <= to; i++) {
            sum += nums[i];
        }
        return sum;
    }

    // TODO - better approach: calculate sumFromTo in place, same logic as the above. Time: O(n) Space: O(1)
    public int maxSubArray(int[] nums) {
        int start = 0;
        int sum = nums[start];
        int sumFromTo = 0;
        for (int num : nums) {
            sumFromTo += num;
            if (num >= 0) {
                if (sumFromTo > num) {
                    sum = Math.max(sum, sumFromTo);
                } else {
                    sum = Math.max(sum, num);
                    sumFromTo = num;
                }
            } else if (num > sum) {
                sum = num;
                sumFromTo = num;
            }
        }
        return sum;
    }

    // TODO - Actual Kadane's algorithm
    //  https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/#expected-approach-using-kadanes-algorithm-on-time-and-o1-space
    public int maxSubArrayKadane(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
