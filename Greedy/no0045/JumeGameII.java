package Greedy.no0045;

public class JumeGameII {
    public static void main(String[] args) {
        JumeGameII leetcode = new JumeGameII();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(leetcode.jumpNaive(nums));
    }

    // TODO - Naive solution: Back tracking - takes too much time
    public int jumpNaive(int[] nums) {
        return jumpRec(nums, -1, 0, 0);
    }

    private int jumpRec(int[] nums, int minSteps, int totalSteps, int currentIndex) {
        /// stoping condition, when the end of the array is reached
        if (currentIndex == nums.length - 1) {
            /// update the minSteps if it is smaller than the current
            if (minSteps == -1) {
                minSteps = totalSteps;
            } else {
                minSteps = Math.min(minSteps, totalSteps);
            }
            return minSteps;
        }

        if (currentIndex >= nums.length || (currentIndex != nums.length - 1 && nums[currentIndex] == 0)) {
            return -1;
        }
        /// test out all the possible cases
        for (int i = 1; i <= nums[currentIndex]; i++) {
            int newMinSteps = jumpRec(nums, minSteps, totalSteps + 1, currentIndex + i);
            /// a solution can be found with this choice
            if (newMinSteps != -1) {
                if (minSteps == -1) {
                    minSteps = newMinSteps;
                } else {
                    minSteps = Math.min(minSteps, newMinSteps);
                }
            }
        }
        return minSteps;
    }

    // TODO - Greedy approach: Time complexity: O(n), Only one traversal of the array is needed.
    //  Auxiliary Space: O(1), There is no extra space required.
    public int jump(int[] nums) {
        int n = nums.length;
        /// Initialize the variables maxReach = 0, currReach = 0, and jump = 0 to keep track of the maximum reachable index,
        /// the current reachable index at the ith position, and the number of jumps taken to reach the current reachable index, respectively.
        int maxReach = 0;
        int currReach = 0;
        int jump = 0;
        /// if the array only has 1 element, it means we are already at the last index
        if (n == 1) {
            return jump;
        }

        for (int i = 0; i < n - 1; i++) {
            /// How do we know for sure that the max reach offers us the best possible solution? As we are iterating the array, we are assuming that we can reach every index.
            /// Therefore we would never miss any better path. With the combination of currReach, we only jump when we must, therefore minimizing the jumps
            maxReach = Math.max(maxReach, i + nums[i]);

            /// If we can reach last index by jumping from current position return jump + 1
            if (maxReach >= n - 1) {
                return jump + 1;
            }

            /// if we are at the index that we can maximum reach and haven't arrived at the end of the array yet, then we are screwed
            if (i == maxReach) {
                return -1;
            }

            /// If the current index is equal to the current reachable index, then a jump is required. Why? We assume that the current reach can be reached within one jump from
            /// all the indices before it (since it used to be the max reach). After one more incrementation of i, the current index would be out of reach for any indices before
            /// the current reachable index, that's why we need to jump
            if (i == currReach) {
                currReach = maxReach;
                jump++;
            }
        }
        return -1;
    }
}
