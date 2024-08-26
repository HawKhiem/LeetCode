import java.util.ArrayList;
import java.util.List;

public class LeetCode22 {
    public static void main(String[] args) {
        LeetCode22 leetCode22 = new LeetCode22();
        System.out.println(leetCode22.generateParenthesis(3).size());
    }

    public List<String> generateParenthesis(int n) {
        if (n == 1) {
            List<String> list = new ArrayList<>();
            list.add("()");
            return list;
        } else {
            List<String> res = new ArrayList<>();
            for (int i = 1; i <= n / 2; i++) {
                List<String> left = generateParenthesis(n - i);
                List<String> right = generateParenthesis(i);
                if (i == 1) {
                    for (String s : left) {
                        String newS1 = "()" + s;
                        String newS2 = s + "()";
                        String newS3 = "(" + s + ")";
                        if (!res.contains(newS1)) {
                            res.add(newS1);
                        }
                        if (!res.contains(newS2)) {
                            res.add(newS2);
                        }
                        if (!res.contains(newS3)) {
                            res.add(newS3);
                        }
                    }
                } else if (n - i == 1) {
                    for (String s : right) {
                        String newS1 = "()" + s;
                        String newS2 = s + "()";
                        String newS3 = "(" + s + ")";
                        if (!res.contains(newS1)) {
                            res.add(newS1);
                        }
                        if (!res.contains(newS2)) {
                            res.add(newS2);
                        }
                        if (!res.contains(newS3)) {
                            res.add(newS3);
                        }
                    }
                } else {
                    for (String s1 : left) {
                        for (String s2 : right) {
                            String newS1 = s1 + s2;
                            String newS2 = s2 + s1;
                            if (!res.contains(newS1)) {
                                res.add(newS1);
                            }
                            if (!res.contains(newS2)) {
                                res.add(newS2);
                            }
                        }
                    }
                }

            }
            return res;
        }
    }
}

// Stolen solution
//     public List<String> generateParenthesis(int n) {
//        StringBuilder sb = new StringBuilder();
//        List<String> combos = new ArrayList<>();
//        if (n == 1) {
//            combos.add("()");
//            return combos;
//        }
//        generateCombo(sb, n, n, combos);
//        return combos;
//    }
//
//    void generateCombo(StringBuilder sb, int open, int close, List<String> combos) {
//        if (open == 0 && close == 0) {
//            combos.add(sb.toString());
//            return;
//        }
//        if (open > 0) {
//            sb.append('(');
//            generateCombo(sb, open - 1, close, combos);
//            sb.setLength(sb.length() - 1);
//        }
//        if (close > open) {
//            sb.append(')');
//            generateCombo(sb, open, close - 1, combos);
//            sb.setLength(sb.length() - 1);
//        }
//    }
