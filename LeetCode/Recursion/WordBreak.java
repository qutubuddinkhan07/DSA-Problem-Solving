import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        // WordBreakBruteSolution obj = new WordBreakBruteSolution();
        WordBreakOptimalSolution obj = new WordBreakOptimalSolution();
        System.out.println(obj.wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(obj.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(obj.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
}

class WordBreakBruteSolution {
    /*-
    Time Complexity: O(2^n), this might lead to TLE in longer strings
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        return solve(0, s, wordDict);
    }

    private boolean solve(int index, String s, List<String> wordDict) {
        if (index == s.length()) {
            return true;
        }

        // if it finds the last word directly then returns true
        if (wordDict.contains(s.substring(index)))
            return true;

        for (int i = index + 1; i <= s.length(); i++) {
            String temp = s.substring(index, i);
            if (wordDict.contains(temp) && solve(i, s, wordDict))
                return true;
        }
        return false;
    }
}

class WordBreakOptimalSolution {
    /*-
    TimeComplexity: O(N^2 . K), where N is the length of the string 's' and K is the maximum length of a word in "wordDict"
    -   There are N unique subproblems (one for each "index" from 0 to N-1)
    -   For each index, the "for" loop runs up to N times
    -   Inside the loop, "s,substring(index, i) takes O(N) time, and searching "List.containes(...) takes O(N.M) time in worst-case (where M is list length). Using a "Hashset" reduces the search lookup to O(K) for string hashing.

    Space Complexity: O(N)
    -   "memo" array takes O(N) space.
    -   The recursion call stack goes up to a maximum depth of N.
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length()];
        return solve(0, s, memo, wordDict);
    }

    private boolean solve(int index, String s, Boolean[] memo, List<String> wordDict) {
        if (index == s.length())
            return true;

        if (memo[index] != null)
            return memo[index];

        for (int i = index + 1; i <= s.length(); i++) {
            String temp = s.substring(index, i);
            if (wordDict.contains(temp) && solve(i, s, memo, wordDict))
                return memo[index] = true;
        }
        return memo[index] = false;
    }
}