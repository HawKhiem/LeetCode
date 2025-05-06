package DynamicProgramming.no0070;

public class ClimbingStairs {

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(3));
    }

    // TODO - Intuition: The idea is to use bottom up dynamic programming. For example we want to climb up to level 5.
    //  We know we can reach level 5 directly from level 4 and level 3 (Since we can only climb one or two steps at a time).
    //  This means the number of ways we can climb to level is equal to the sum of number of ways to climb to level 3 and 4
    //  We continue doing that till we reach level 0. We avoid using an extra array for this.
    public int climbStairs(int n) {
        /// we are at level 0, so there is one way to get there
        int zero = 1;
        /// to climb to level 1, so there is one way to get there from level 0
        int one = 1;
        /// this essentially becomes the Fibonacci problem
        for (int i = 0; i < n - 1; i++) {
            int temp = zero;
            zero = one + zero;
            one = temp;
        }
        return zero;
    }
}
