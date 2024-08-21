public class LeetCode11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            int area = minHeight * (right - left);
            max = Math.max(max, area);

            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
// two pointer technique
}
