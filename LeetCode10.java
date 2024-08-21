//Regular Expression Matching
public class LeetCode10 {
    public static void main(String[] args) {
        LeetCode10 leet = new LeetCode10();
        System.out.println(leet.isMatch("abaabcabac", ".*ab.a.*a*a*.*b*b*"));
    }

    public boolean isMatch(String s, String p) {
        char[] pattern = p.toCharArray();
        char[] string = s.toCharArray();
        if (pattern.length == 0 && string.length == 0) {
            return true;
        }
        int i = 0, j = 0;
        while (i < pattern.length && j < string.length) {
            // cover the stern case
            if (i + 1 < pattern.length && pattern[i + 1] == '*') {
                // can skip beliebig viele characters in the string
                if (pattern[i] == '.') {
                    // test out all possible sub string we can skip to see if there is any match
                    int k = 0;
                    for (; j + k < string.length; k++) {
                        if (isMatch(s.substring(j + k), p.substring(i + 2))) {
                            return true;
                        }
                    }
                    return isMatch(s.substring(j + k), p.substring(i + 2));
                }

                // the sterned character is not used, skip it
                else if (pattern[i] != string[j]) {
                    i += 2;
                }
                // the stern is being used, skip through all the characters possible
                else {
                    // test out all possible sub string we can skip to see if there is any match
                    char expected = pattern[i];
                    int k = 0;
                    for (; j + k < string.length && string[j + k] == expected; k++) {
                        if (isMatch(s.substring(j + k), p.substring(i + 2))) {
                            return true;
                        }
                    }
                    return isMatch(s.substring(j + k), p.substring(i + 2));
                }
            }
            // cover the normal cases
            else {
                if (pattern[i] != '.' && pattern[i] != string[j]) {
                    return false;
                } else {
                    i++;
                    j++;
                }
            }

        }
        while (i + 1 < pattern.length && pattern[i + 1] == '*' && j == string.length) {
            i += 2;
        }
        return j == string.length && i == pattern.length;
    }
}


// stolen solution:

//public boolean isMatch(String s, String p) {
//    boolean[][] mat = new boolean[s.length() + 1][p.length() + 1];
//
//    mat[0][0] = true;
//
//    for (int i = 1; i < mat[0].length; i++) {
//        if (p.charAt(i - 1) == '*') mat[0][i] = mat[0][i - 2];
//    }
//
//    for (int i = 1; i < mat.length; i++) {
//        for (int j = 1; j < mat[0].length; j++) {
//            if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
//                mat[i][j] = mat[i - 1][j - 1];
//            } else if (p.charAt(j - 1) == '*') {
//                mat[i][j] = mat[i][j - 2];
//                if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
//                    mat[i][j] = mat[i][j] | mat[i - 1][j];
//                }
//            } else {
//                mat[i][j] = false;
//            }
//        }
//    }
//
//    return mat[s.length()][p.length()];
//}


//Intuition
//*The problem requires implementing regular expression matching with support for . and :
//
//        `.` matches any single character.
//        `*` matches zero or more of the preceding element.
//Dynamic Programming (DP) is a suitable approach for this problem as it allows us to build a solution incrementally while considering various possible matches.
//
//Approach
//Initialize DP Table:
//
//Create a DP table mat with dimensions (len(s) + 1) x (len(p) + 1) initialized to False.
//        mat[i][j] will be True if the first i characters in s can match the first j characters in p.
//
//Base Case:
//
//mat[0][0] is True because an empty string matches an empty pattern.
//
//Pattern Initialization:
//
//Handle cases where the pattern p contains * that can match zero preceding elements.
//Update mat[0][i] to True if the pattern up to i can match an empty string.
//
//Fill DP Table:
//
//Iterate through each character in s and p.
//For each pair (i, j), update the DP table based on the characters in s and p:
//If p[j-1] is . or matches s[i-1], mat[i][j] is set to mat[i-1][j-1].
//If p[j-1] is *, it can match zero or more of the preceding element:
//Check if * matches zero elements: mat[i][j] = mat[i][j-2].
//Check if * matches one or more elements: mat[i][j] is updated to mat[i][j] or mat[i-1][j] if the preceding element matches s[i-1].
//
//Return Result:
//
//The result is mat[len(s)][len(p)], indicating whether the entire string s matches the pattern p.
//
//Complexity
//Time complexity:
//The time complexity is O(n×m) where n is the length of the string s and m is the length of the pattern p. This is because we fill in an (n+1) x (m+1) DP table.
//
//Space complexity:
//The space complexity is O(n×m) for the DP table used to store match results.