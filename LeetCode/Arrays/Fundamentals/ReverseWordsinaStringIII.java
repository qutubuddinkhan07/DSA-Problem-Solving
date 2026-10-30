package Fundamentals;

public class ReverseWordsinaStringIII {
    /* Problem Link: 557. Reverse Words in a String III [https://leetcode.com/problems/reverse-words-in-a-string-iii/description/] */

    public static void main(String[] args) {
        ReverseWordsinaStringIIISolution obj = new ReverseWordsinaStringIIISolution();
        String s1 = "Let's take LeetCode contest";
        String s2 = "Mr Ding";
        System.out.println(obj.reverseWords(s1));
        System.out.println(obj.reverseWords(s2));
    }
}

class ReverseWordsinaStringIIISolution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder res = new StringBuilder();
        int n = words.length;

        for (int i = 0; i < n; i++) {
            char[] chars = words[i].toCharArray();
            reverse(chars, 0, chars.length - 1);
            res.append(new String(chars));
            if (i != n - 1) {
                res.append(" ");
            }
        }

        return res.toString();
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
