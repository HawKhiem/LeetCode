package no0069;

public class Sqrt {
    public static void main(String[] args) {
        Sqrt leetcode = new Sqrt();
        System.out.println(leetcode.mySqrt(Integer.MAX_VALUE));
        System.out.println(Math.pow(2, 15));
        System.out.println((int) Math.sqrt(Integer.MAX_VALUE));
    }

    public int mySqrt(int x) {
        int exponent = 0;
        while (x > 0) {
            x /= 2;
            exponent++;
        }
        return exponent;
    }
}
