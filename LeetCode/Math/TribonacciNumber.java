/*
 * Problem:    LC 1137 - N-th Tribonacci Number
 * Link:       https://leetcode.com/problems/n-th-tribonacci-number/description/
 * Pattern:    recursion / memoization / dp
 * Key idea:   One sentence: the trick that makes it work.
 * Solved:     with hint / after editorial
 * Date:       10/11/26 Tue 2026
 */
public class TribonacciNumber {
    public static void main(String[] args) {
        TribonacciNumberApproachI obj = new TribonacciNumberApproachI();
        System.out.println(obj.tribonacci(5));
    }
}

class TribonacciNumberApproachI {
    /*
     * Time:       O(3^n)
     * Space:      O(n), auxiliary space complexity
     */
    public int tribonacci(int n) {
        if (n == 0)
            return 0;

        if (n == 1 || n == 2)
            return 1;

        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }
}
