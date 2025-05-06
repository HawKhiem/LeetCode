package no0071;

import java.util.Stack;

public class SimplifyPath {
    // TODO: Use a stack to handle the ..
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder cur = new StringBuilder();
        path += "/";
        for (int i = 0; i < path.length(); i++) {
            /// we ignore the / for now, i.e, we don't add them to cur
            if (path.charAt(i) == '/') {
                /// move up one directory
                if (cur.toString().equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                }
                /// . means the current directory, which means we don't have to push anything
                else if ((!cur.isEmpty()) && !cur.toString().equals(".")) {
                    stack.push(cur.toString());
                }
                /// reset cur
                cur = new StringBuilder();
            }
            /// simply add the character to cur otherwise
            else {
                cur.append(path.charAt(i));
            }
        }
        return "/" + String.join("/", stack);
    }
}
