package no39;

import java.util.ArrayList;
import java.util.List;

public class LeetCode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSumRecursive(candidates, target, result, new ArrayList<>());
        return result;
    }

    private void combinationSumRecursive(int[] candidates, int target, List<List<Integer>> temp, List<Integer> list) {
        if (target == 0) {
            temp.add(new ArrayList<>(list));
        }
        for (int i : candidates) {
            if (target >= i) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(i);
                /// This one takes
                combinationSumRecursive(candidates, target - i, temp, newList);
                /// This one doesn't take
                combinationSumRecursive(candidates, target, temp, list);
            }
        }
    }
}
