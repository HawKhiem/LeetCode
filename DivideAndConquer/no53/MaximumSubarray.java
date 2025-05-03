package DivideAndConquer.no53;

public class MaximumSubarray {
    public static void main(String[] args) {
        MaximumSubarray leetcode = new MaximumSubarray();
        int[] nums = {1, -2, 0};
        System.out.println(leetcode.maxSubArray(nums));
    }

    // TODO - naive approach: Time limit exceeded
    public int maxSubArrayNaive(int[] nums) {
        int start = 0;
        int sum = nums[start];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                if (sumFromTo(nums, start, i) > nums[i]) {
                    sum = Math.max(sum, sumFromTo(nums, start, i));
                } else {
                    sum = Math.max(sum, nums[i]);
                    start = i;
                }
            } else if (nums[i] > sum) {
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

    // TODO - better approach: calculate sumFromTo in place
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
}
