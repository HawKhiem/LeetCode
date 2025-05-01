package no42;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {4, 3, 3, 9, 3, 0, 9, 2, 8, 3};
        TrappingRainWater solution = new TrappingRainWater();
        System.out.println(solution.trap(height));
    }

    // TODO - naive approach
//    public int trap(int[] height) {
//        int origin = Arrays.stream(height).sum();
//        ///
//        for (int i = 0; i < height.length; i++) {
//            /// skip the first cell if height is zero there
//            if (i == 0 && height[i] == 0) {
//                continue;
//            }
//            /// find the closest index where height is at least as high as the current height
//            if (height[i] > 0) {
//                /// if the height of next cell is larger than the current one, move to it
//                if (i < height.length - 1 && height[i + 1] > height[i]) {
//                    continue;
//                }
//                /// otherwise, try to find the closest height which is the highest and higher than the height of the next cell (which is low)
//                else if (i < height.length - 1) {
//                    int next = i + 1;
//                    int heightOfNext = height[next];
//                    int highestIndex = next;
//                    while (next < height.length) {
//                        if (height[next] > heightOfNext && height[next] >= height[highestIndex]) {
//                            highestIndex = next;
//                        }
//                        if (height[highestIndex] >= height[i] && highestIndex != i) {
//                            break;
//                        }
//                        next++;
//                    }
//                    /// if such height could be found, fill all the slots in between with the lower height of the two
//                    if (highestIndex != i) {
//                        int newHeight = Math.min(height[highestIndex], height[i]);
//                        for (int j = i + 1; j < highestIndex; j++) {
//                            height[j] = newHeight;
//                        }
//                        i = highestIndex - 1;
//                    }
//                }
//            }
//        }
//        return Arrays.stream(height).sum() - origin;
//    }

    // TODO: two pointer approach - O(n) Time and O(1) Space
    //  The approach is mainly based on the following facts:
    //  - If we consider a subarray arr[left…right], we can decide the amount of water either for arr[left] or arr[right] if we know the left max (max element in arr[0…left-1]) and right max (max element in arr[right+1…n-1].
    //  - If left max is less than the right max, then we can decide for arr[left]. Else we can decide for arr[right]
    //  - If we decide for arr[left], then the amount of water would be left max – arr[left] and if we decide for arr[right], then the amount of water would be right max – arr[right].
    public int trap(int[] height) {
        int left = 1;
        int right = height.length - 2;
        /// lMax : Maximum in subarray arr[0..left-1]
        /// rMax : Maximum in subarray arr[right+1..n-1]
        int lMax = height[left - 1];
        int rMax = height[right + 1];
        int res = 0;
        while (left <= right) {
            if (lMax < rMax) {
                if (height[left] < lMax) {
                    res += (lMax - height[left]);
                }
                lMax = Math.max(lMax, height[left]);
                left++;
            } else {
                if (height[right] < rMax) {
                    res += (rMax - height[right]);
                }
                rMax = Math.max(rMax, height[right]);
                right--;
            }
        }
        return res;
    }
}
