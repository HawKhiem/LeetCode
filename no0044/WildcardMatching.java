package no0044;

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
        int stringIndex = 0, patternIndex = 0, startIndex = -1, match = 0;

        while (stringIndex < n) {
            /// Characters match or '?' in pattern matches any character.
            if (patternIndex < m && (p.charAt(patternIndex) == '?' || p.charAt(patternIndex) == s.charAt(stringIndex))) {
                stringIndex++;
                patternIndex++;
            } else if (patternIndex < m && p.charAt(patternIndex) == '*') {
                /// Wildcard character '*', mark the current position in the pattern and the text as a proper match.
                startIndex = patternIndex;
                /// start with the case where '*' match an empty string
                match = stringIndex;
                patternIndex++;
            }
            /// No match since all the above cases are not met
            else if (startIndex != -1) {
                /// No match, but a previous wildcard was found. Backtrack to the last '*' character position and try for a different match.
                patternIndex = startIndex + 1;
                /// gradually increment match then assign it to string index. Basically 'skip' some characters, more each time, until a match is found
                match++;
                stringIndex = match;
            } else {
                /// If none of the above cases comply, the pattern does not match.
                return false;
            }
        }

        /// Consume any remaining '*' characters in the given pattern.
        while (patternIndex < m && p.charAt(patternIndex) == '*') {
            patternIndex++;
        }

        /// If we have reached the end of both the pattern and the text, the pattern matches the text.
        return patternIndex == m;
    }
}
