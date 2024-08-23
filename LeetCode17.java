import java.util.ArrayList;
import java.util.List;

public class LeetCode17 {
    // Backtracking
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();

        // If the input is empty, immediately return an empty answer array
        if (digits.isEmpty()) {
            return combinations;
        }

        // Mapping the digits to their corresponding letters
        String[] digitMapping = new String[]{
                "", // 0
                "", // 1
                "abc", // 2
                "def", // 3
                "ghi", // 4
                "jkl", // 5
                "mno", // 6
                "pqrs", // 7
                "tuv", // 8
                "wxyz" // 9
        };

        // Initiate backtracking with an empty path and starting index of 0
        backtrack(0, new StringBuilder(), digits, digitMapping, combinations);

        return combinations;
    }

    // Use backtrack function to generate all possible combinations
    private void backtrack(int index, StringBuilder path, String digits, String[] letters, List<String> combinations) {
        // If the length of path and digits is the same, we have a complete combination
        if (path.length() == digits.length()) {
            // Add the current combination to the result list
            combinations.add(path.toString());
            return; // Backtrack
        }

        // Get the list of letters using the current index and digits[index]
        String possibleLetters = letters[digits.charAt(index) - '0'];

        if (possibleLetters != null) {
            for (int i = 0; i < possibleLetters.length(); i++) {
                // Add the current letter to the path
                path.append(possibleLetters.charAt(i));
                // Recursively explore the next digit
                backtrack(index + 1, path, digits, letters, combinations);
                // Remove the current letter from the path before backtracking to explore other
                // combinations
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
