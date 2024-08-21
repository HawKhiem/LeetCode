public class LeetCode9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int palX = 0;
        int temp = x;
        while (temp != 0) {
            palX *= 10;
            palX += temp % 10;
            temp /= 10;
        }
        return palX == x;
    }
}
