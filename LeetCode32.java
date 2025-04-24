import java.util.Stack;

public class LeetCode32 {
    public static void main(String[] args) {
        LeetCode32 leetcode = new LeetCode32();
//        leetcode.longestValidParentheses("(((()()()(((()()())(())()())(())()()())(())())))))))");
        System.out.println("***********************************************".length());
        System.out.println(leetcode.longestValidParentheses("()(()"));
    }

    // TODO: increment counter if see ( and decrement if see ). Ignore ) when counter is negative. Consider appending
    //  counter into a test string and perhaps use a separator to know differentiate between 1, 0 and 10.
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            // The closing brackets will consume the index of the opening bracket. '
            // So to include the may be consumed opening bracket when the stack is empty,
            // we have to push the buffer index onto the stack!
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
