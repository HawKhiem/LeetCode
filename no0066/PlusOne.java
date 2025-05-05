package no0066;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        PlusOne leetcode = new PlusOne();
        System.out.println(Arrays.toString(leetcode.plusOne(new int[]{9, 9, 9})));
    }

    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int temp = digits[i] + carry;
            if (temp >= 10) {
                carry = 1;
                temp -= 10;
            } else {
                carry = 0;
            }
            digits[i] = temp;
        }
        if (carry == 1) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, result.length - 1);
            return result;
        }
        return digits;
    }
}

