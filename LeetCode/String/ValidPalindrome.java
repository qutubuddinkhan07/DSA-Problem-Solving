public class ValidPalindrome {
    public static void main(String[] args) {
        // ValidPalindromeRecursiveSolution obj = new ValidPalindromeRecursiveSolution();
        ValidPalindromeIterativeSolution obj = new ValidPalindromeIterativeSolution();
        System.out.println(obj.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(obj.isPalindrome("race a car"));
        System.out.println(obj.isPalindrome("aaa"));
    }
}

class ValidPalindromeRecursiveSolution {
    public boolean isPalindrome(String s) {
        return checkPalindrome(s.toLowerCase(), 0, s.length() - 1);
    }

    private boolean checkPalindrome(String s, int left, int right) {
        while (left <= right && !isAlphanumeric(s.charAt(left)))
            left++;
        while (left <= right && !isAlphanumeric(s.charAt(right)))
            right--;
        if (left >= right)
            return true;
        if (s.charAt(left) != s.charAt(right))
            return false;
        return checkPalindrome(s, left + 1, right - 1);
    }

    private boolean isAlphanumeric(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
    }
}

class ValidPalindromeIterativeSolution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (!isAlphanumeric(s.charAt(left))) {
                left++;
                continue;
            }
            if (!isAlphanumeric(s.charAt(right))) {
                right--;
                continue;
            }

            char l = isLowerCase(s.charAt(left));
            char r = isLowerCase(s.charAt(right));
            if (l != r)
                return false;
            left++;
            right--;
        }
        return true;
    }

    private boolean isAlphanumeric(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
    }

    private char isLowerCase(char ch) {
        if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9'))
            return ch;

        int diff = 'a' - 'A';
        return (char) (diff + ch);
    }
}
