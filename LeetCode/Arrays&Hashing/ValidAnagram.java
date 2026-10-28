public class ValidAnagram {
    /* Problem Link: Valid Anagram [https://leetcode.com/problems/valid-anagram/description/] */
    public static void main(String[] args) {
        ValidAnagramSolution obj = new ValidAnagramSolution();
        System.out.println(obj.isAnagram("anagram", "nagaram"));
        System.out.println(obj.isAnagram("rat", "cat"));
    }
}

class ValidAnagramSolution {
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            int val = ch - 'a';
            freq[val]++;
        }

        for (char ch : t.toCharArray()) {
            int val = ch - 'a';
            freq[val]--;
        }

        for (int x : freq) {
            if (x != 0) return false;
        }

        return true;
    }
}
