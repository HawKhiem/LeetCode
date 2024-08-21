public class LeetCode8 {
    public int myAtoi(String s) {
        char[] arr = s.toCharArray();
        boolean digitRead = false;
        boolean leedingNull = false;
        boolean signRead = false;
        boolean neg = false;
        long result = 0;
        for (char c : arr) {
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) break;
            if (c == ' ' && !digitRead && !signRead) continue;
            if (c == '0' && !digitRead) leedingNull = true;
            if (leedingNull && (c == '-' || c == '+')) break;
            if (c == '-' && !digitRead && !signRead) {
                signRead = true;
                neg = true;
                continue;
            }
            if (c == '+' && !digitRead && !signRead) {
                signRead = true;
                continue;
            }
            if (c >= '0' && c <= '9') {
                result *= 10;
                result += c - '0';
                digitRead = true;
            }
            if (c < '0' || c > '9') break;
        }
        if (neg) result = -result;
        if (result >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (result <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) result;
    }
}
