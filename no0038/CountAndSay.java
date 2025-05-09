package no0038;

public class CountAndSay {
    public static void main(String[] args) {
        CountAndSay leetcode = new CountAndSay();
        System.out.println(leetcode.countAndSay(6));
    }

    public String countAndSay(int n) {
        if (n < 1) {
            return null;
        }
        String result = "1";
        for (int i = 1; i < n; i++) {
            result = rle(result);
        }
        return result;
    }

    private String rle(String s) {
        if (s.isEmpty()) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        char lastChar = s.charAt(0);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (lastChar == s.charAt(i)) {
                count++;
            } else {
                res.append(count);
                res.append(lastChar);
                count = 1;
                lastChar = s.charAt(i);
            }
        }
        res.append(count);
        res.append(lastChar);
        return res.toString();
    }
}
