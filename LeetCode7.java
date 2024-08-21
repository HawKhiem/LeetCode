public class LeetCode7 {
    public int reverse(int x) {
        StringBuilder s = new StringBuilder();
        if (x == 0) return 0;
        if (x < 0) {
            s.append("-");
        }
        String str = Integer.toString(x);
        String abs = x > 0 ? str : str.substring(1);
        long temp = Long.parseLong(abs);
        while (temp != 0) {
            s.append(temp % 10);
            temp /= 10;
        }
        long result = Long.parseLong(s.toString());
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return 0;
        return (int) result;
    }
}
