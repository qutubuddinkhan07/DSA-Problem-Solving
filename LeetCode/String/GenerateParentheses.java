import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    /**
     *
     * Problem Link: https://leetcode.com/problems/generate-parentheses/description/
     */
    public static void main(String[] args) {
        // GenerateParenthesesBruteSolution obj = new GenerateParenthesesBruteSolution();
        GenerateParenthesesOptimalSolution obj = new GenerateParenthesesOptimalSolution();
        System.out.println(obj.generateParenthesis(3));
    }
}

class GenerateParenthesesBruteSolution {
    public List<String> generateParenthesis(int n) {    // O(1)
        List<String> res = new ArrayList<>();
        generateAll(n, "", res);
        return res;
    }

    private void generateAll(int n, String curr, List<String> result) { // O(2^2n) = 4^n x String-copy (n)
        if (curr.length() == 2 * n) {
            if (isValid(curr)) {
                result.add(curr);
            }
            return;
        }

        generateAll(n, curr + "(", result);
        generateAll(n, curr + ")", result);
    }

    private boolean isValid(String str) {   // called 2^2n --> 4^n times, O(n) each = O(4^n . n)
        int balance = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '(')
                balance++;
            else balance--;
            if (balance < 0)
                return false;
        }
        return balance == 0;
    }
    /**
     * Time Complexity: O(2^(2n) * n), due to the generation and validation of all 2^(2n) sequences
     * Space Complexity: O(n)
     */
}

class GenerateParenthesesOptimalSolution {
    /**
     * Time Complexity: O(2^n) (Catalan number): C(n) = (2n)! / (n!(n+1)!) is the number of valid sequences.
     * Each sequence takes O(n) to build.
     * So, total complexity: O(C(n) × n)
     * <p>
     * Space Complexity: O(n) recursion depth.
     * O(C(n) × n) to store results.\
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack("", 0, 0, n, res);
        return res;
    }

    private void backtrack(String curr, int open, int close, int n, List<String> res) {
        System.out.println(curr);
        System.out.println(res);
        if (curr.length() == 2 * n) {
            res.add(curr);
            return;
        }

        if (open < n)
            backtrack(curr + "(", open + 1, close, n, res);
        if (close < open)
            backtrack(curr + ")", open, close + 1, n, res);
    }
}