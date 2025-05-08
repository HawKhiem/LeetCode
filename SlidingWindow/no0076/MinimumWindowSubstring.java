package SlidingWindow.no0076;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        System.out.println(minimumWindowSubstring.minWindow("a", "aa"));
    }

    public String minWindow(String s, String t) {
        if (t.isEmpty()) {
            return "";
        }
        int left = 0, right = 0;
        int l = 0, r = 0;
        int resLength = Integer.MAX_VALUE;
        Map<Character, Integer> sFrequency = new HashMap<>();
        Map<Character, Integer> tFrequency = new HashMap<>();
        /// put all the occurrences of each character in each word in their respective maps
        for (int i = 0; i < t.length(); i++) {
            tFrequency.put(t.charAt(i), tFrequency.getOrDefault(t.charAt(i), 0) + 1);
        }
        /// have counts the number of letters that has been satisfied, need are the number of letters that we still need to satisfy
        /// by satisfying, it means we need to match its occurrences
        int have = 0, need = tFrequency.size();
        for (; r < s.length(); r++) {
            char c = s.charAt(r);
            sFrequency.put(c, 1 + sFrequency.getOrDefault(c, 0));
            if (tFrequency.containsKey(c) && tFrequency.get(c).equals(sFrequency.get(c))) {
                have++;
            }
            while (have == need) {
                /// update result
                if (r - l + 1 < resLength) {
                    resLength = r - l + 1;
                    left = l;
                    right = r;
                }
                ///  pop from left window
                sFrequency.put(s.charAt(l), sFrequency.get(s.charAt(l)) - 1);
                /// if after popping, the number of occurrences of that specific letter are not the same anymore, we reduce have
                if (tFrequency.containsKey(s.charAt(l)) && sFrequency.get(s.charAt(l)) < tFrequency.get(s.charAt(l))) {
                    have--;
                }
                /// popping means shrinking the window to the left
                l++;
            }
        }
        return resLength == Integer.MAX_VALUE ? "" : s.substring(left, right + 1);
    }
}
