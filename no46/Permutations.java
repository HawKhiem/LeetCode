package no46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Permutations {

    public static void main(String[] args) {
        Permutations leetcode = new Permutations();
        System.out.println(leetcode.permute(new int[]{1, 2, 3}));
    }

    // TODO - naive approach: fix an index and generate all the permutations of the rest of the array. Then add the fixed index to the beginning of each permutation.
    public List<List<Integer>> permuteNaive(int[] nums) {
        List<Integer> numsList = IntStream.of(nums).boxed().toList();
        return permuteRecNaive(numsList, new ArrayList<>());
    }

    private List<List<Integer>> permuteRecNaive(List<Integer> nums, List<List<Integer>> result) {
        if (nums.size() == 2) {
            result.add(new ArrayList<>(Arrays.asList(nums.get(0), nums.get(1))));
            result.add(new ArrayList<>(Arrays.asList(nums.get(1), nums.get(0))));
            return result;
        }

        if (nums.size() == 1) {
            result.add(new ArrayList<>(Collections.singletonList(nums.get(0))));
            return result;
        }

        for (int i = 0; i < nums.size(); i++) {
            List<Integer> tempNums = new ArrayList<>(nums);
            tempNums.remove(i);
            List<List<Integer>> tempResult = permuteRecNaive(tempNums, new ArrayList<>());
            for (List<Integer> temp : tempResult) {
                temp.add(0, nums.get(i));
            }
            result.addAll(tempResult);
        }
        return result;
    }


    // TODO - a better approach: swap the fixed index to the front and then generate all the permutations of the rest of the array.
    //  Then swap the fixed index back to the original position.
    //  Why do we have to swap the fixed index to the front? Because we would only generate the permutations of all the other numbers in the array.
    //  Without swapping we will end up with a permutation already achieved or worse, mess up the whole array
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteRec(nums, result, 0);
        return result;
    }

    private void permuteRec(int[] nums, List<List<Integer>> result, int fixedIndex) {
        if (fixedIndex == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num);
            }
            result.add(temp);
            return;
        }

        for (int i = fixedIndex; i < nums.length; i++) {
            /// swap the fixed index back to the front.
            swap(nums, i, fixedIndex);
            /// generate the permutations of the rest of the array.
            permuteRec(nums, result, fixedIndex + 1);
            /// swap the fixed index back to the original position.
            swap(nums, i, fixedIndex);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
