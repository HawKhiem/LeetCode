package BackTracking.no40;

import java.util.ArrayList;
import java.util.List;


public class CombinationSumII {

    public static void main(String[] args) {
        CombinationSumII leetcode = new CombinationSumII();
        System.out.println(leetcode.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        selectionSort(candidates);
        backtrack(new ArrayList<>(), result, target, candidates, -1);
        return result;
    }

    // TODO: same idea with Combination Sum, only difference is that we start at candidateIndex + 1 to avoid reuse the current candidate
    private void backtrack(List<Integer> temp, List<List<Integer>> result, int target, int[] candidates, int candidateIndex) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = candidateIndex + 1; i < candidates.length; i++) {
            temp.add(candidates[i]);
            backtrack(temp, result, target - candidates[i], candidates, i);
            temp.remove(temp.size() - 1);

            /// somehow comparision here makes it run faster than putting it in the for loop condition
            if (candidates[i] > target) break;
            /// skip all the same elements, we know that the array of candidates is now sorted, so all the same elements will produce the same temp list
            while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) {
                i++;
            }
        }
    }

    /// somehow selection Sort works better than the built in Arrays.sort function
    private void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            // Swap
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }
}

// TODO: one can also use AbstractList to improve time complexity
// class Solution {
//    public List<List<Integer>> combinationSum2(int[] arr, int val) {
//        return new java.util.AbstractList<List<Integer>>() {
//            List<List<Integer>> res;
//            List<Integer> temp;
//
//            @Override
//            public List<Integer> get(int index) {
//                return res.get(index);
//            }
//
//            @Override
//            public int size() {
//                if (res == null) {
//                    init();
//                }
//                return res.size();
//            }
//
//            public void init() {
//                if (res == null) {
//                    res = new ArrayList<>();
//                    temp = new ArrayList<>();
//                    Arrays.sort(arr);
//                    backtrack(0, val);
//                }
//            }
//
//            private void backtrack(int index, int tar) {
//                if (tar == 0) {
//                    res.add(new ArrayList<>(temp));
//                    return;
//                }
//                for (int i = index; i < arr.length; i++) {
//                    if ((i > index && arr[i] == arr[i - 1]))
//                        continue;
//                    if (tar - arr[i] >= 0) {
//                        temp.add(arr[i]);
//                        backtrack(i + 1, tar - arr[i]);
//                        temp.remove(temp.size() - 1);
//
//                    }
//                }
//            }
//
//        };
//    }
//}
