import java.util.ArrayList;
import java.util.List;

public class FindResultantArrayAfterRemovingAnagrams {
    /*  Problem Link: 2273. Find Resultant Array After Removing Anagrams
    [https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/description/]  */

    public static void main(String[] args) {
        // FindResultantArrayAfterRemovingAnagramsBruteSolution obj =
        new FindResultantArrayAfterRemovingAnagramsBruteSolution();
        FindResultantArrayAfterRemovingAnagramsBetterSolution obj =
                new FindResultantArrayAfterRemovingAnagramsBetterSolution();
        System.out.println(obj.removeAnagrams(new String[]{"abba", "baba", "bbaa", "cd", "cd"}));
        System.out.println(obj.removeAnagrams(new String[]{"a", "b", "c", "d", "e"}));
    }

    /*-
    n - number of strings
    L - is the length of a string

    Time Complexity: O(n)   [Both Approaches]
    Space Complexity: O(n x L) [Both Approaches]
     */
}

class FindResultantArrayAfterRemovingAnagramsBruteSolution {
    public List<String> removeAnagrams(String[] words) {
        int n = words.length;
        int i = 0;
        int j = 1;
        List<String> ans = new ArrayList<>();

        while (j < n) {
            String wordi = words[i];
            String wordj = words[j];

            if (isAnagram(wordi, wordj)) {
                j++;
            } else {
                ans.add(wordi);
                i = j;
                j++;
            }
        }
        ans.add(words[i]);

        return ans;
    }

    private boolean isAnagram(String s, String t) {
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
            if (x != 0)
                return false;
        }
        return true;
    }
}

class FindResultantArrayAfterRemovingAnagramsBetterSolution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (ans.isEmpty() || !isAnagram(ans.get(ans.size() - 1), word)) {
                ans.add(word);
            }
        }
        return ans;
    }

    private boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        int[] freq = new int[26];
        for (int i = 0; i < a.length(); i++) {
            freq[a.charAt(i) - 'a']++;
            freq[b.charAt(i) - 'a']--;
        }

        for (int count : freq) {
            if (count != 0)
                return false;
        }
        return true;
    }
}