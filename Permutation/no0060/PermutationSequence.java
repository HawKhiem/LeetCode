package Permutation.no0060;

import java.util.Arrays;

public class PermutationSequence {
    public static void main(String[] args) {
        PermutationSequence leetcode = new PermutationSequence();
        System.out.println(leetcode.getPermutation(3, 5));
    }

    public String getPermutation(int n, int k) {
        // TODO: formulate k-1 = an.n! + an-1.(n-1)! + ... a2.2!+ a1.1!
        //  we use k-1 instead of k to simplify the algorithm
        //  since k is maximum n!, we practically don't need to care about an.n!
        //  but for the sake of completeness it is added in
        //  k-1 is >= 0 so it is 0-indexed
        //  We will deal with the coefficients from left to right
        //  We denote the indices of characters in the string from left to right, starting from 0 (0-indexed)
        //  let start = 0 and end = n-1
        //  1.1! means we have to swap the characters at indices end-1 and end
        //  There is no 2.1!
        //  1.2! means we have to swap the characters at indices end-2 and end-1
        //  2.2! means we have to swap the characters at indices end-2 and end
        //  There is no 3.2!
        //  1.3! means we have to swap the characters at indices end-3 and end-2
        //  2.3! means we have to swap the characters at indices end-3 and end-1
        //  3.3! means we have to swap the characters at indices end-3 and end
        //  There is no 3.3!
        //  After each swap, we need to sort the the whole array starting from end-i+1 with i being the base of the factorial
        //  The algorithm continues for larger factorial
        //  Remember we have to deal with the larger factorial first
        //  Time: O(n*log(n)) - n*log(n) for sorting the subarray. Other than that we only have to iterate through the array once
        //  Space: O(n) - for the result array

        /// Precompute all the needed factorials
        int kthIndex = k - 1;
        int[] factorials = new int[]{362880, 40320, 5040, 720, 120, 24, 6, 2, 1};
        int index = 0;
        for (; index < factorials.length; index++) {
            if (kthIndex >= factorials[index]) {
                break;
            }
        }
        int[] coefficients = new int[factorials.length - index];
        int i = 0;
        while (kthIndex >= 1) {
            if (kthIndex >= factorials[index]) {
                kthIndex -= factorials[index];
                coefficients[i] += 1;
            } else {
                index++;
                i++;
            }
        }
        int[] result = new int[n];
        for (int j = 0; j < n; j++) {
            result[j] = j + 1;
        }
        int end = n - 1;
        for (int j = 0; j < coefficients.length; j++) {
            int factorialBase = coefficients.length - j;
            int coefficient = coefficients[j];
            swap(result, end - factorialBase, end - factorialBase + coefficient);
            /// sort the array starting from end-factorialBase+1 to end
            Arrays.sort(result, end - factorialBase + 1, end + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) {
            sb.append(result[j]);
        }
        return sb.toString();
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
