public class PalindromeNumber {
    public static void main() {
        PalindromeNumberSolution obj = new PalindromeNumberSolution();
        System.out.println(obj.isPalindrome(121));
        System.out.println(obj.isPalindrome(-121));
        System.out.println(obj.isPalindrome(10));
    }
}

class PalindromeNumberSolution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int rev = 0, temp = x;
        while (temp != 0) {
            int rem = temp % 10;
            rev = rev * 10 + rem;
            temp /= 10;
        }

        return rev == x;
    }
}

