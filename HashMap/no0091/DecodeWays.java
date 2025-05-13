package HashMap.no0091;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {
    public Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        DecodeWays leetcode = new DecodeWays();
        System.out.println(leetcode.numDecodings("06"));
        System.out.println(leetcode.numDecodings("11106"));
    }

    // TODO - naive approach: Solve using recursion and memoization
    public int numDecodings(String s) {
        if (s.isEmpty()) {
            return 1;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }
        int value = Integer.parseInt(s.substring(0, 2));
        if (value >= 10 && value <= 26) {
            String s1 = s.substring(1);
            String s2 = s.substring(2);
            int first, second;
            if (map.containsKey(s1)) {
                first = map.get(s1);
            } else {
                first = numDecodings(s1);
                map.put(s1, first);
            }
            if (map.containsKey(s2)) {
                second = map.get(s2);
            } else {
                second = numDecodings(s2);
                map.put(s2, first);
            }
            int result = first + second;
            map.put(s, result);
            return result;
        } else {
            String s1 = s.substring(1);
            int first;
            if (map.containsKey(s1)) {
                first = map.get(s1);
            } else {
                first = numDecodings(s1);
                map.put(s1, first);
            }
            return first;
        }
    }

    // TODO - solve using dynamic programming:
    //    Set<Character> set = Set.of('0','1','2','3','4','5','6');
    //    public int numDecodings(String s) {
    //        return helper(0, s, new Integer[s.length()]);
    //    }
    //    private int helper(int i, String s, Integer[] dp) {
    //        if(i >= s.length()) return 1;
    //        char c = s.charAt(i);
    //        if('0' == c) return 0;
    //        if(dp[i] != null) return dp[i];
    //        int res = helper(i + 1, s, dp);
    //        if((i + 1) < s.length() && (c == '1' ||(c == '2' && set.contains(s.charAt(i + 1))))) {
    //            res += helper(i + 2, s, dp);
    //        }
    //        return dp[i] = res;
    //    }
}
