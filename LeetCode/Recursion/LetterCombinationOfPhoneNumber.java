import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhoneNumber {
    /*-
    Problem Link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
     */
    public static void main(String[] args) {
        LetterCombinationOfPhoneNumberSolution obj = new LetterCombinationOfPhoneNumberSolution();
        System.out.println(obj.letterCombinations("23"));
    }
}

class LetterCombinationOfPhoneNumberSolution {
    private final String[] MPP;

    LetterCombinationOfPhoneNumberSolution() {
        MPP = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        helper(0, "", digits, ans);
        return ans;
    }

    private void helper(int index, String current, String digits, List<String> ans) {
        if (index == digits.length()) {
            ans.add(current);
            return;
        }

        String s = MPP[digits.charAt(index) - '0'];
        for (int i = 0; i < s.length(); i++) {
            helper(index + 1, current + s.charAt(i), digits, ans);
        }
    }
    /*-
    Time Complexity: O(4^N * N), where 'N' is the length of the input digits.
            This is because each digit can map to up to 4 letters, and are 'N' digits
    Space Complexity: O(N), where 'N' is the length of the input digits. This is due
            to the recursion stack depth.
     */
}
