package HashMap.no0087;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ScrambleString {
    public Map<String, Boolean> map = new HashMap<>();

    public static void main(String[] args) {
        ScrambleString leetcode = new ScrambleString();
        System.out.println(leetcode.isScramble("great", "rgeat"));
        System.out.println(leetcode.isScramble("abcde", "caebd"));
        System.out.println(leetcode.isScramble("a", "a"));
    }

    // TODO - naive approach: Test for each case. This could be done since the concatenation of two scrambled substrings is also a scrambled string
    //  for example rg is a scrambled substring of gr. ate is a scrambled substring of ear, therefore rgate is also a scrambled string a great
    public boolean isScrambleNaive(String s1, String s2) {
        if (s1.length() == 1) {
            return s1.equals(s2);
        }
        if (s1.equals(s2)) {
            return true;
        }
        int n = s1.length();
        /// for every possible split index
        for (int i = 1; i < n; i++) {
            /// the two substrings are not swapped
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            /// the two substrings are swapped
            if (isScramble(s1.substring(0, i), s2.substring(n - i)) && isScramble(s1.substring(i), s2.substring(0, n - i))) {
                return true;
            }
        }
        return false;
    }

    // TODO - memoization. Use a map to store the result of previous comparisons between two substrings. Key could be the s1#s2 and value
    //  is the result of isScramble(s1, s2). For this we use a hashmap
    public boolean isScrambleMemoization(String s1, String s2) {
        if (s1.length() == 1) {
            return s1.equals(s2);
        }
        if (s1.equals(s2)) {
            return true;
        }
        if (map.containsKey(s1 + "#" + s2)) {
            return map.get(s1 + "#" + s2);
        }
        int n = s1.length();
        /// for every possible split index
        for (int i = 1; i < n; i++) {
            /// the two substrings are not swapped
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) {
                map.put(s1 + "#" + s2, true);
                return true;
            }
            /// the two substrings are swapped
            if (isScramble(s1.substring(0, i), s2.substring(n - i)) && isScramble(s1.substring(i), s2.substring(0, n - i))) {
                map.put(s1 + "#" + s2, true);
                return true;
            }
        }
        map.put(s1 + "#" + s2, false);
        return false;
    }

    // TODO - memoization. Use a map to store the result of previous comparisons between two substrings. Key could be the s1#s2 and value
    //  is the result of isScramble(s1, s2). For this we use a hashmap. Apart from that we can also check for the frequency of each character
    //  in the two words before performing the recursion
    public boolean isScramble(String s1, String s2) {
        if (s1.length() == 1) {
            return s1.equals(s2);
        }
        if (s1.equals(s2)) {
            return true;
        }
        if (map.containsKey(s1 + "#" + s2)) {
            return map.get(s1 + "#" + s2);
        }
        int n = s1.length();
        /// frequency array to count the frequency of each character
        int[] f1 = new int[26], f2 = new int[26];
        for (int i = 0; i < n; i++) {
            f1[s1.charAt(i) - 'a'] += 1;
            f2[s2.charAt(i) - 'a'] += 1;
        }
        if (!Arrays.equals(f1, f2)) {
            map.put(s1 + "#" + s2, false);
            return false;
        }
        /// for every possible split index
        for (int i = 1; i < n; i++) {
            /// the two substrings are not swapped
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) {
                map.put(s1 + "#" + s2, true);
                return true;
            }
            /// the two substrings are swapped
            if (isScramble(s1.substring(0, i), s2.substring(n - i)) && isScramble(s1.substring(i), s2.substring(0, n - i))) {
                map.put(s1 + "#" + s2, true);
                return true;
            }
        }
        map.put(s1 + "#" + s2, false);
        return false;
    }
}
