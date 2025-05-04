package no55;

public class JumpGame {
    // TODO - Greedy approach
    public boolean canJump(int[] nums) {
        int currReach = 0;
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (i == currReach) {
                currReach = maxReach;
            }
            if (maxReach >= nums.length - 1) {
                return true;
            }
            if (nums[i] == 0 && i == maxReach && maxReach < nums.length - 1) {
                return false;
            }
        }
        return false;
    }
}
