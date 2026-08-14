import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        ValidParenthesesSolution obj = new ValidParenthesesSolution();
        System.out.println(obj.isValid("()[]{}")); // true
        System.out.println(obj.isValid("()")); // true
        System.out.println(obj.isValid("(]")); // false
        System.out.println(obj.isValid("([])")); // true
        System.out.println(obj.isValid("(ds[23]43)")); // true
        System.out.println(obj.isValid("([)]")); // false
        System.out.println(obj.isValid("as(d[f)]")); // false
    }
}

class ValidParenthesesSolution {
    /**
     *
     * Time Complexity: O(n) (array conversion) + O(n) × O(1) (loop) = O(n).
     * Space Complexity: O(n)
     */
    public boolean isValid(String s) {
        char[] chars = s.toCharArray(); // O(n)
        Stack<Character> stack = new Stack<>();
        for (char ch : chars) { // O(n)
            if (ch == '(' || ch == '{' || ch == '[')
                stack.push(ch);

                // for ignoring characters other than parentheses
            else if (!(ch == ')' || ch == '}' || ch == ']')) {
                continue;
            } else {
                if (stack.isEmpty())
                    return false;
                char top = stack.peek();
                if ((ch == ')' && top == '(') || (ch == '}' && top == '{') || (ch == ']' && top == '['))
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
