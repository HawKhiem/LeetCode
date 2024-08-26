import java.util.Stack;

public class LeetCode20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}

// Stolen solution
//     public boolean isValid(String s) {
//     int i = -1;
//        char[] stack = new char[s.length()];
//        for (char ch : s.toCharArray()) {
//            if (ch == '(' || ch == '{' || ch == '[')
//                stack[++i] = ch;
//            else {
//                if (i >= 0
//                    && ((stack[i] == '(' && ch == ')')
//                        || (stack[i] == '{' && ch == '}')
//                        || (stack[i] == '[' && ch == ']')))
//                    i--;
//                else
//                    return false;
//            }
//        }
//        return i == -1;
