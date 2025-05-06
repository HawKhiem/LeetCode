package BackTracking.no47;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII {
    public static void main(String[] args) {
        PermutationsII leetcode = new PermutationsII();
        System.out.println(leetcode.permuteUnique(new int[]{1, 1, 2}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<Integer> used = new java.util.HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        permuteUniqueRec(nums, result, used, 0);
        return result;
    }

    public void permuteUniqueRec(int[] nums, List<List<Integer>> result, Set<Integer> used, int fixedIndex) {
        if (fixedIndex == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num);
            }
            result.add(temp);
            return;
        }

        for (int i = fixedIndex; i < nums.length; i++) {
            /// carry on if the number has already been used (since we will swap the number to front, basically we would be generating the same permutation again)
            if (!used.contains(nums[i])) {
                used.add(nums[i]);
                swap(nums, i, fixedIndex);
                /// on a deeper level, we will have to use a new set, since this will now generate the unique permutation of the deeper level, not the current one
                permuteUniqueRec(nums, result, new HashSet<>(), fixedIndex + 1);
                swap(nums, i, fixedIndex);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
