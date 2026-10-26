public class ReverseInteger {
    public static void main(String[] args) {
        ReverseIntegerSolution obj = new ReverseIntegerSolution();
        System.out.println(obj.reverse(123));
        System.out.println(obj.reverse(-123));
        System.out.println(obj.reverse(1534236469));
    }
}

class ReverseIntegerSolution {
    /*-
    Time Complexity: O(log10 |x|) - each iteration process one digit
    Space Complexity: O(1)
     */
    int MAX_VALUE = 2_147_483_647;
    int MIN_VALUE = -2_147_483_648;

    public int reverse(int x) {
        int rev = 0;

        while (x != 0) {
            int rem = x % 10;

            // checking for overflow before updating
            if (rev > MAX_VALUE / 10 || (rev == MAX_VALUE / 10 && rev % 10 > 7)) {
                return 0;
            }

            if (rev < MIN_VALUE / 10 || (rev == MIN_VALUE / 10 && rev % 10 < -8)) {
                return 0;
            }

            rev = rev * 10 + rem;
            x /= 10;
        }

        return rev;
    }
}
