public class LeetCode29 {
    public static void main(String[] args) {
        LeetCode29 leetcode = new LeetCode29();
        System.out.println(leetcode.divide(-2147483648, -1));
    }


    public int divide(int dividend, int divisor) {
        return (int) divideLong(dividend, divisor);
    }

    private long divideLong(long dividend, long divisor) {
        long counter = 0;
        boolean negative = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        if (dividend < divisor) {
            return 0;
        }
        if (divisor == 1) {
            long result = negative ? -dividend : dividend;
            if (result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            return result;
        }
        // can be improved with bit shifting, which enables dividing by 2 without using division
//        while (dividend >= 0) {
//            dividend -= divisor;
//            counter++;
//        }
        while (dividend >= divisor) {
            int exponent = 0;
            while (dividend >= (divisor << (exponent + 1))) {
                exponent++;
            }
            counter += (1L << exponent);
            dividend -= divisor << exponent;
        }
        long result = negative ? -counter : counter;
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return result;
    }
}

// Stolen solution
//     public int divide(int dividend, int divisor) {
//        if(divisor == dividend) return 1;
//
//        boolean sign = true;
//        if(dividend <= 0 && divisor > 0) sign = false;
//        else if(dividend >= 0 && divisor < 0) sign = false;
//
//        long a = dividend;
//        a = Math.abs(a);
//        long b = divisor;
//        b = Math.abs(b);
//        long quotient = 0;
//        while(a >= b){
//            int count = 0;
//            while( a >= (b<<(count+1))){
//                count += 1;
//            }
//            quotient += 1<<count;
//            a = a - (b<<count);
//        }
//        if(quotient == (1<<31) && sign) return (1<<31)-1;
//        if(quotient == (1<<31) && !sign) return -(1<<31);
//
//        return (sign) ? (int)quotient : -(int)quotient;
//    }