package no44;

public class WildcardMatching {
    public static void main(String[] args) {
        WildcardMatching leetcode = new WildcardMatching();
        System.out.println(leetcode.isMatch("a", "?"));
    }

    // TODO - naive approach - backtracking with recursion - takes a bit too long
    public boolean isMatchNaive(String s, String p) {
        if (s.equals(p)) {
            return true;
        }
        int i = 0;
        for (; i < p.length() && i < s.length(); i++) {
            if (p.charAt(i) == '?' || p.charAt(i) == s.charAt(i)) {
                continue;
            }
            if (p.charAt(i) != '?' && p.charAt(i) != '*' && p.charAt(i) != s.charAt(i)) {
                return false;
            }
            if (p.charAt(i) == '*') {
                for (int j = i; j <= s.length(); j++) {
                    if (isMatchNaive(s.substring(j), p.substring(i + 1))) {
                        return true;
                    }
                }
            }
        }
        if ((i >= s.length()) && i < p.length()) {
            while (i < p.length() && p.charAt(i) == '*') {
                if (i == p.length() - 1) {
                    return true;
                }
                i++;
            }
            return false;
        }
        return i >= s.length();
    }

    // TODO - Simple Traversal Solution – O(n) Time and O(1) Space
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int i = 0, j = 0, startIndex = -1, match = 0;

        while (i < n) {
            /// Characters match or '?' in pattern matches any character.
            if (j < m && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                i++;
                j++;
            } else if (j < m && p.charAt(j) == '*') {
                /// Wildcard character '*', mark the current position in the pattern and the text as a proper match.
                startIndex = j;
                match = i;
                j++;
            } else if (startIndex != -1) {
                /// No match, but a previous wildcard was found. Backtrack to the last '*' character position and try for a different match.
                j = startIndex + 1;
                match++;
                i = match;
            } else {
                /// If none of the above cases comply, the pattern does not match.
                return false;
            }
        }

        /// Consume any remaining '*' characters in the given pattern.
        while (j < m && p.charAt(j) == '*') {
            j++;
        }

        /// If we have reached the end of both the pattern and the text, the pattern matches the text.
        return j == m;
    }
}
