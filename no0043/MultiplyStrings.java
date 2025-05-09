package no0043;

public class MultiplyStrings {
    public static void main(String[] args) {
        MultiplyStrings leetcode = new MultiplyStrings();
        System.out.println(leetcode.multiply("13", "40"));
    }

    public String multiply(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        if (n1 == 0 || n2 == 0 || num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        /// index by num1
        int i1 = 0;

        /// index by num2
        int i2;

        /// store the result in reverse
        int[] result = new int[n1 + n2];

        /// go from right to left by num1
        for (int i = n1 - 1; i >= 0; i--) {
            int carry = 0;
            int n1Digit = num1.charAt(i) - '0';
            i2 = 0;

            /// go from right to left by num2
            for (int j = n2 - 1; j >= 0; j--) {
                int n2Digit = num2.charAt(j) - '0';

                /// multiply and add this result
                /// to the existing result
                int sum = n1Digit * n2Digit + result[i1 + i2] + carry;

                /// carry for next iteration
                carry = sum / 10;

                /// store result
                result[i1 + i2] = sum % 10;

                i2++;
            }

            /// store carry in next cell
            if (carry > 0) {
                result[i1 + i2] += carry;
            }

            i1++;
        }
        /// ignore '0's from the right
        int i = result.length - 1;
        while (i >= 0 && result[i] == 0) {
            i--;
        }
        StringBuilder s = new StringBuilder();
        while (i >= 0) {
            s.append(result[i--]);
        }
        return s.toString();
    }
}
