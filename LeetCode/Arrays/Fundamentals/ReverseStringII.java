package Fundamentals;

public class ReverseStringII {
    /* Problem Link: 541. Reverse String II [https://leetcode.com/problems/reverse-string-ii/description/] */
    public static void main(String[] args) {
        ReverseStringIISolution obj = new ReverseStringIISolution();
        String s = "abcdefg";
        String s2 = "abcd";
        System.out.println(obj.reverseStr(s, 2));
        System.out.println(obj.reverseStr(s2, 2));
    }
}

class ReverseStringIISolution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] chars = s.toCharArray();

        for (int i = 0; i < n; i += 2 * k) {
            int right = Math.min(i + k - 1, n - 1);
            reverse(chars, i, right);
        }

        return new String(chars);
    }

    private void reverse(char[] chars, int left, int right) {
        while (left <= right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
