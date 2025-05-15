package HashMap.no0115;

import java.util.HashMap;
import java.util.Map;

public class DistinctSubsequences {
    // TODO - naive approach: Test every character in s and t to see if they are equal.
    //  If they are not, we skip one character in s. If they are, we either consume that character in t or don't
    //  This still causes a time limit exceeded. Now we use memoization to speed it up
    //  This is still really slow, since string concatenation needs O(n) time and substring also takes at worse case O(n) time
    private Map<String, Integer> map = new HashMap<>();

    public int numDistinct(String s, String t) {
        if (s.isEmpty() && !t.isEmpty()) {
            return 0;
        }
        if (s.length() < t.length()) {
            return 0;
        }
        if (t.isEmpty()) {
            return 1;
        }
        if (s.equals(t)) {
            return 1;
        }
        if (map.containsKey(s + "#" + t)) {
            return map.get(s + "#" + t);
        }
        if (s.charAt(0) == t.charAt(0)) {
            int result = numDistinct(s.substring(1), t.substring(1)) + numDistinct(s.substring(1), t);
            map.put(s + "#" + t, result);
            return result;
        } else {
            int result = numDistinct(s.substring(1), t);
            map.put(s + "#" + t, result);
            return result;
        }
    }

    // TODO - a much faster solution: incrementing the indices takes O(1) and we don't need to build the key ourselves, which would have taken extra O(n).
    //  Resort to this always if possible, since it is much faster than our traditional hashmap mindset
    //     private int recurse(String s, String t, int i, int j, Integer[][] mem) {
    //        int M = s.length();
    //        int N = t.length();
    //        // Base case: basically we have reached the end of s (i==M), or the end of t (j==N) or the length of whats left in s is smaller than that in t (M-i<N-j)
    //        if (i == M || j == N || M - i < N - j) {
    //            return j == t.length() ? 1 : 0;
    //        }
    //        // Check to see if the result for this recursive
    //        // call is already cached
    //        if (mem[i][j] != null) return mem[i][j];
    //        // Always calculate this result since it's
    //        // required for both the cases
    //        int ans = this.recurse(s, t, i + 1, j, mem);
    //        // If the characters match, then we make another
    //        // recursion call and add the result to "ans"
    //        if (s.charAt(i) == t.charAt(j)) {
    //            ans += this.recurse(s, t, i + 1, j + 1, mem);
    //        }
    //        // Cache the result
    //        mem[i][j] = ans;
    //        return ans;
    //    }
    //    public int numDistinct(String s, String t) {
    //        Integer[][] mem = new Integer[s.length()][t.length()];
    //        return this.recurse(s, t, 0, 0, mem);
    //    }
}
