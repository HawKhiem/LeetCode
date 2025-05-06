package BinarySearch.no0069;

public class Sqrt {
    public static void main(String[] args) {
        Sqrt leetcode = new Sqrt();
        System.out.println(leetcode.mySqrt(Integer.MAX_VALUE));
        System.out.println(Math.pow(2, 15));
        System.out.println((int) Math.sqrt(Integer.MAX_VALUE));
    }

    public int mySqrt(int x) {
        int left = 0, right = x;
        int result = 0;
        while (left <= right) {
            /// This avoids overflow
            int mid = left + (right - left) / 2;
            /// Too big
            if (Math.pow(mid, 2) > x) {
                right = mid - 1;
                result = mid - 1;
            }
            /// Too small
            else if (Math.pow(mid, 2) < x) {
                left = mid + 1;
                result = mid;
            } else {
                return mid;
            }
        }
        return result;
    }
}
