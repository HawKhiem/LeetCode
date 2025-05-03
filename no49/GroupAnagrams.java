package no49;

import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    static final int MAX_CHAR = 26;

    public static void main(String[] args) {
        GroupAnagrams leetcode = new GroupAnagrams();
        System.out.println(leetcode.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    /// Function to generate hash of word s
    private String getHash(String s) {
        StringBuilder hash = new StringBuilder();
        int[] freq = new int[MAX_CHAR];

        /// Count frequency of each character
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        /// Append the frequency to construct the hash
        for (int i = 0; i < MAX_CHAR; i++) {
            hash.append(freq[i]);
            hash.append("$");
        }

        return hash.toString();
    }

    // TODO: using frequency as key for each anagram group – O(n*k) Time and O(n*k) Space
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new java.util.HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String hash = getHash(strs[i]);
            if (!map.containsKey(hash)) {
                map.put(hash, new java.util.ArrayList<>());
            }
            map.get(hash).add(strs[i]);
        }
        return new java.util.ArrayList<>(map.values());
    }

    /// Time Complexity: O(m + n), where m and n are length of string s1 and s2 respectively.
    /// Auxiliary Space: O(26) = O(1). The input strings can only have lowercase letters, so there can be at most 26 distinct characters in the hash map.
    private boolean isAnagram(String s1, String s2) {
        if (s1.isEmpty() || s2.isEmpty()) {
            return false;
        }

        if (s1.length() != s2.length()) {
            return false;
        }


        if (s1.equals(s2)) {
            return true;
        }


        Map<Character, Integer> frequencyMap = new java.util.HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) - 1);
        }

        for (int freq : frequencyMap.values()) {
            if (freq != 0) {
                return false;
            }
        }
        return true;

    }
}
