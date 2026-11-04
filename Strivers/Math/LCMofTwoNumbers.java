/*
 * Problem:    GFG LCM of Two Numbers
 * Link:       https://www.geeksforgeeks.org/problems/lcm-of-two-numbers/1
 * Pattern:    Maths
 * Key idea:   Using loop / using formula
 * Time:       O(?)
 * Space:      O(?)
 * Solved:     with hint
 * Date:       04/11/26 Wed 2026
 */
public class LCMofTwoNumbers {
    public static void main(String[] args) {
        // LCMofTwoNumbersSolutionI obj = new LCMofTwoNumbersSolutionI();
        LCMofTwoNumbersSolutionII obj = new LCMofTwoNumbersSolutionII();
        System.out.println(obj.LCM(4, 6));
    }
}

class LCMofTwoNumbersSolutionI {
    /*
    Time: O(log(min(a,b)))
    Space: O(1)
    */
    public int LCM(int n1, int n2) {
        int gcd = findGCD(n1, n2);
        return (n1 / gcd) * n2;
    }

    private int findGCD(int a, int b) {
        while (a > 0 && b > 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }

        if (a == 0) {
            return b;
        }

        return a;
    }
}

class LCMofTwoNumbersSolutionII {
    /*
    Time: O(min(a,b))
    Space: O(1)
     */
    public int LCM(int a, int b) {
        // code here
        int g = Math.max(a, b);
        int s = Math.min(a, b);

        for (int i = g; i <= a * b; i += g) {
            if (i % s == 0) {
                return i;
            }
        }

        return -1;
    }
}