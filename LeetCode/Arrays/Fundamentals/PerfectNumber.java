package fundamentals;

/*
 * Problem:    LC 507 - Perfect Number
 * Link:       https://leetcode.com/problems/perfect-number/description/
 * Pattern:    Maths
 * Key idea:   Brute is checking divisors, but optimal is counting the divisor which that appears in pairs
 * Solved:     alone
 * Date:       04/11/26 Wed 2026
 */
public class PerfectNumber {
    public static void main(String[] args) {
        // PerfectNumberApproachI obj = new PerfectNumberApproachI();
        PerfectNumberApproachII obj = new PerfectNumberApproachII();
        System.out.println(obj.checkPerfectNumber(6));
        System.out.println(obj.checkPerfectNumber(28));
        System.out.println(obj.checkPerfectNumber(7));
    }
}

class PerfectNumberApproachI {
    /*
    Time: O(N), because every number from 1 to N - 1 may be checked.
    Space: O(1), because no extra data structure is needed.
     */
    public boolean checkPerfectNumber(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }

        return sum == num;
    }
}

class PerfectNumberApproachII {
    /*
    Time: O(sqrt(N)), because only divisors up to the square root are checked.
    Space: O(1), because no extra data structure is needed.
     */
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) {
            return false;
        }

        int sum = 1;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                if (i * i == num) {
                    sum += i;
                } else {
                    sum += i + (num / i);
                }
            }
        }

        return sum == num;
    }
}
