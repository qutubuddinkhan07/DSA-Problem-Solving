package Fundamentals;

public class ReverseVowelsofaString {
    public static void main(String[] args) {
        ReverseVowelsofaStringSolution obj = new ReverseVowelsofaStringSolution();
        String s = "IceCreAm";
        String s2 = "leetcode";

        System.out.println(obj.reverseVowels(s));
        System.out.println(obj.reverseVowels(s2));
    }
}

class ReverseVowelsofaStringSolution {
    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] chars = s.toCharArray();

        while (i < j) {
            while (i < j && !checkVow(chars[i])) {
                i++;
            }
            while (i < j && !checkVow(chars[j])) {
                j--;
            }

            if (i < j) {
                swap(chars, i, j);
                i++;
                j--;
            }
        }

        return new String(chars);
    }

    private boolean checkVow(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
            return true;
        }
        return false;
    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
