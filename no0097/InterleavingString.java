package no0097;

import java.util.HashMap;

public class InterleavingString {

    private HashMap<String, Boolean> memo = new HashMap<>();

    public static void main(String[] args) {
        InterleavingString leetcode = new InterleavingString();
        System.out.println(leetcode.isInterleave("aa", "ab", "abaa"));
    }

    // TODO - naive approach: use memoization
    public boolean isInterleaveNaive(String s1, String s2, String s3) {
        if (s1.isEmpty() && s2.isEmpty() && s3.isEmpty()) {
            return true;
        } else if ((!s1.isEmpty() || !s2.isEmpty()) && s3.isEmpty()) {
            return false;
        } else if (s1.isEmpty() && !s2.equals(s3)) {
            return false;
        } else if (s2.isEmpty() && !s1.equals(s3)) {
            return false;
        }
        if (memo.containsKey(s1 + "#" + s2 + "#" + s3)) {
            return memo.get(s1 + "#" + s2 + "#" + s3);
        }
        if (!s1.isEmpty() && !s2.isEmpty() && s1.charAt(0) == s3.charAt(0) && s2.charAt(0) == s3.charAt(0)) {
            boolean result = isInterleaveNaive(s1.substring(1), s2, s3.substring(1)) || isInterleaveNaive(s1, s2.substring(1), s3.substring(1));
            memo.put(s1 + "#" + s2 + "#" + s3, result);
            return result;
        } else if (!s1.isEmpty() && s1.charAt(0) == s3.charAt(0)) {
            boolean result = isInterleaveNaive(s1.substring(1), s2, s3.substring(1));
            memo.put(s1 + "#" + s2 + "#" + s3, result);
            return result;
        } else if (!s2.isEmpty() && s2.charAt(0) == s3.charAt(0)) {
            boolean result = isInterleaveNaive(s1, s2.substring(1), s3.substring(1));
            memo.put(s1 + "#" + s2 + "#" + s3, result);
            return result;
        }
        memo.put(s1 + "#" + s2 + "#" + s3, false);
        return false;
    }

    // TODO - use dynamic programming
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        Boolean[][] dp = new Boolean[s1.length() + 1][s2.length() + 1];

        return backtrack(s1, s2, s3, 0, 0, dp);
    }

    private boolean backtrack(String s1, String s2, String s3, int i, int j, Boolean[][] dp) {
        /// this means we have matched every character in s3
        if (i + j == s3.length()) {
            return true;
        }
        /// we could use dynamic programming since the strings in one test case remain unchanged and some patterns could repeat
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        /// i, j denotes the indices, the pointers to characters being considered in s1 and s2 respectively
        int k = i + j;
        boolean result = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            result = backtrack(s1, s2, s3, i + 1, j, dp);
        }
        if (!result && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            result = backtrack(s1, s2, s3, i, j + 1, dp);
        }
        dp[i][j] = result;
        return result;
    }

    // TODO - Follow up: Could you solve it using only O(s2.length) additional memory space?
}
