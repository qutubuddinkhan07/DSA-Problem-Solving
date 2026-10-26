public class GCDofTwoNumbers {
    /*  https://takeuforward.org/practice/dsa/gcd-of-two-numbers */

    public static void main(String[] args) {
        // GCDofTwoNumbersBrute obj = new GCDofTwoNumbersBrute();
        GCDofTwoNumbersOptimal obj = new GCDofTwoNumbersOptimal();
        System.out.println(obj.GCD(4, 2));
        System.out.println(obj.GCD(4, 3));
    }
}

class GCDofTwoNumbersBrute {
    /*-
    Time Complexity: O(min(n1, n2))
     */
    public int GCD(int n1, int n2) {
        int ans = 0;

        for (int i = 1; i <= Math.min(n1, n2); i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                ans = i;
            }
        }
        return ans;
    }
}

class GCDofTwoNumbersOptimal {
    /*-
    Euclidean Algorithm
    Time Complexity: O(log(min(a,b)))
     */
    public int GCD(int a, int b) {
        while (a > 0 && b > 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }

        if (a == 0) {
            return b;
        } else {
            return a;
        }
    }
}
