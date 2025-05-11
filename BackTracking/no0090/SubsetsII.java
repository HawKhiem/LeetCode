package BackTracking.no0090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SubsetsII {
    public static void main(String[] args) {
        SubsetsII leetcode = new SubsetsII();
        System.out.println(leetcode.subsetsWithDup(new int[]{1, 2, 2, 2}));
    }

    // TODO - naive approach: use as hash set to prevent duplicate lists
    //  sort the array to prevent adding lists containing the same elements but in different order
    public List<List<Integer>> subsetsWithDupNaive(int[] nums) {
        HashSet<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        subsetsWithDupRec(result, new ArrayList<>(), 0, nums);
        return result.stream().toList();
    }

    private void subsetsWithDupRec(HashSet<List<Integer>> result, List<Integer> temp, int start, int[] nums) {
        result.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            subsetsWithDupRec(result, temp, i + 1, nums);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDupRecBetter(result, new ArrayList<>(), 0, nums);
        return result;
    }

    private void subsetsWithDupRecBetter(List<List<Integer>> result, List<Integer> temp, int start, int[] nums) {
        result.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            /// skip the duplicate elements. This works because with only the first element in the streak, it is enough to create
            /// the needed subset (we would still add more elements in the streak to temp as we go deeper, this can occur because we
            /// make sure we only skip the same elements in the same streak on the same level - this works due to i > start)
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            subsetsWithDupRecBetter(result, temp, i + 1, nums);
            temp.remove(temp.size() - 1);
        }
    }
}
