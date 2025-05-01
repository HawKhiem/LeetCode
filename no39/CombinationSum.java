package no39;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum leetcode = new CombinationSum();
        System.out.println(leetcode.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(temp, result, target, candidates, 0);
        return result;
    }

    private void backtrack(List<Integer> temp, List<List<Integer>> result, int target, int[] candidates, int candidateIndex) {
        // TODO - Question: Why don't we need to check if the list is already in result (disregarding the order)?
        //  Intuition: Backtracking helps us find a solution. Basically for every candidate, it tries to find whether the solution can be found when we take in
        //  the current candidate. As we are iterating the array, all the candidates that are in the front of the array will be tried first, and they have also tested
        //  the candidates that are in the back of the array to see if together they sum up to the target.
        //  Hence, we can assume that the candidates that are in the back of the array have already been tested with the ones in the front of the array.
        //  That's why we don't need to look back
        /// if target is reached then add the temp list into result
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = candidateIndex; i < candidates.length; i++) {
            temp.add(candidates[i]);
            /// check to see if a solution can be found using the current candidate. If yes the solution would be added into the result list
            backtrack(temp, result, target - candidates[i], candidates, i);
            /// removing the candidate helps us resetting the temp list
            temp.remove(temp.size() - 1);
        }
    }


}
