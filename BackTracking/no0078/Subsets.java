package BackTracking.no0078;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsetsRec(nums, result, new ArrayList<>(), 0);
        return result;
    }

    private void subsetsRec(int[] nums, List<List<Integer>> result, List<Integer> temp, int start) {
        result.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            subsetsRec(nums, result, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
