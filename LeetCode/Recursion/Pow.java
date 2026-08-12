/*
 * ================================================================
 * Problem: Pow(x, n) (LeetCode 50)
 * ================================================================
 * Implement the power function pow(x, n) , which calculates the x
 * raised to n i.e. xn
 *
 * Two implementations of the same idea are given below: one
 * iterative, one recursive.
 * ================================================================
 */

public class Pow {
    public static void main(String[] args) {
        RecursivePowSolution obj = new RecursivePowSolution();
        double n1 = 2.00000;
        int n2 = 10;

        double n3 = 2;
        int n4 = -2;
        System.out.printf("%.4f\n", obj.myPow(n1, n2));
        System.out.printf("%.4f\n", obj.myPow(n3, n4));
    }
}

// ---------------------------------------------------------------
// Iterative approach
// ---------------------------------------------------------------
// Description:
//   Here it checks base case: any number to the power of 0 is 1
//   it handles overflow, also handles negative exponents then
//   calculate the answer
//
// Time Complexity:  O(n) — where n is the absolute value of the exponent.
//                      This is because we multiply the base x, n times
// Space Complexity: O(1) — as we are using constant amount of space for
//                      the variables used in the computation.
class IterativeSolution {
    public double myPow(double x, int n) {
        if (x == 1.0 || n == 0)
            return 1;

        long temp = n;
        if (n < 0) {
            x = 1 / x;
            temp = -1L * n;
        }

        double ans = 1.0;
        for (long i = 0; i < temp; i++)
            ans *= x;
        return ans;
    }
}

// ---------------------------------------------------------------
// Recursive approach
// ---------------------------------------------------------------
// Description:
//   Defined a helper function that handles the recursive
//   calculation of the power. And from the myPow() checks for the
//   n positivity.
//
// Time Complexity:  O(log n) — where n is the absolute value of the
//                   exponent. This is because we reduce the problem
//                   size by half in each recursive call when n is even.
// Space Complexity: O(log n) — due to recursive call stack. In the
//                   worst case, the depth of the recursion can go up to
//                   log(n) when n is even.
class RecursivePowSolution {
    private double pow(double x, long n) {
        if (n == 0)
            return 1.0;
        if (n == 1)
            return x;

        // if n is even
        if (n % 2 == 0)
            return pow(x * x, n / 2);

        // if n is odd
        return x * pow(x, n - 1);
    }

    public double myPow(double x, int n) {
        long N = n;
        // if n is negative
        if (N < 0)
            return 1.0 / pow(x, -N);

        // if n is positive
        return pow(x, N);
    }
}
