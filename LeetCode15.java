import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode15 {
    // Use the two pointer method
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // Sort the array

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicate elements
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return res;
    }
}

// Stolen solution:

//private List<List<Integer>> res;
//public List<List<Integer>> threeSum(int[] nums) {
//    return new AbstractList<List<Integer>>() {
//        public List<Integer> get(int index) {
//            init();
//            return res.get(index);
//        }
//        public int size() {
//            init();
//            return res.size();
//        }
//        private void init() {
//            if (res != null) return;
//            Arrays.sort(nums);
//            int l, r, sum;
//            Set<List<Integer>> tempRes = new HashSet<>();
//            for(int i = 0; i < nums.length - 2; ++i) {
//                l = i + 1;
//                r = nums.length - 1;
//                while(l < r) {
//                    sum = nums[i] + nums[l] + nums[r];
//                    if (sum == 0) tempRes.add(Arrays.asList(nums[i], nums[l], nums[r]));
//                    if (sum < 0) ++l; else --r;
//                }
//            }
//            res = new ArrayList<List<Integer>>(tempRes);
//        }
//
//    };
