package DivideAndConquer.no50;

public class PowXN {
    // TODO: Using Divide and Conquer – O(log n) Time and O(log n) Space
    //  If n is even: power(x, n) = power(x, n / 2) * power(x, n / 2);
    //  If n is odd: power(x, n) = x * power(x, n - 1);
    public double myPow(double x, int n) {
        if (n == 0 || x == 1) {
            return 1;
        }

        if (x == 0) {
            return 0;
        }

        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return 1 / (x * myPow(x, Integer.MAX_VALUE));
            }
            return 1 / myPow(x, -n);
        }
        /// if n is even
        if (n % 2 == 0) {
            double temp = myPow(x, n / 2);
            return temp * temp;
        }
        /// if n is odd
        else {
            return x * myPow(x, n - 1);
        }
    }
}
