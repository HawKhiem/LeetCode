package TwoPointers.no32;

import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        LongestValidParentheses leetcode = new LongestValidParentheses();
//        leetcode.longestValidParentheses("(((()()()(((()()())(())()())(())()()())(())())))))))");
        System.out.println("***********************************************".length());
        System.out.println(leetcode.longestValidParentheses("()(()"));
    }

    // TODO: use a stack to keep track of the index of the opening bracket. Every time we see a closing bracket, we pop the index of the opening bracket.
    //  To ensure we also include the opening bracket when the stack is empty, we have to push the buffer index onto the stack!
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            // TODO: The closing brackets will consume the index of the opening bracket.
            //  So to include the may be consumed opening bracket when the stack is empty,
            //  we have to push the buffer index onto the stack!
            if (stack.isEmpty() && s.charAt(i) == '(') {
                stack.push(i - 1);
                stack.push(i);
            } else if (!stack.isEmpty() && s.charAt(i) == '(') {
                stack.push(i);
            }
            // skip the closing brackets when then stack is already empty
            else if (!stack.isEmpty() && s.charAt(i) == ')') {
                stack.pop();
                if (!stack.isEmpty()) {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }
}

// TODO: Another approach - Two Traversals: The idea is to solve the problem using two traversals of the string, one from left to right and one from right to left,
//  while keeping track of the number of open and close parentheses using two counters: open and close. Why there is a Two Traversals?
//  Left to right traversal ensures that every valid substring that ends at the rightmost closing parenthesis is counted.
//  Right to left traversal ensures that every valid substring that starts from the leftmost opening parenthesis is counted.
//        int maxLen = 0;
//        // Left to Right Traversal
//        int open = 0, close = 0;
//        for (char ch : s.toCharArray()) {
//            if (ch == '(') {
//                open++;
//            } else if (ch == ')') {
//                close++;
//            }
//            if (open == close) {
//                maxLen = Math.max(maxLen, 2 * close);
//            } else if (close > open) {
//                open = close = 0;
//            }
//        }
//        // Right to Left Traversal
//        open = close = 0;
//        for (int i = s.length() - 1; i >= 0; i--) {
//            if (s.charAt(i) == '(') {
//                open++;
//            } else if (s.charAt(i) == ')') {
//                close++;
//            }
//            if (open == close) {
//                maxLen = Math.max(maxLen, 2 * open);
//            } else if (open > close) {
//                open = close = 0;
//            }
//        }
//        return maxLen;
