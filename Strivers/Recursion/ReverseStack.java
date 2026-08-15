import java.util.Stack;

public class ReverseStack {
    /**
     *
     * TakeUForward Link: <a href="https://takeuforward.org/plus/dsa/problems/reverse-a-stack">Reverse Stack</a>
     * Time Complexity: O(n^2), as each element is popped and inserted at the bottom (O(n) per element)
     * Space Complexity: O(n), recursion stack space
     */
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(1);
        stack.push(3);
        stack.push(2);

        // Stack<Integer> newStack = (Stack<Integer>) stack.clone();
        Stack<Integer> stack2 = new Stack<>();
        stack2.addAll(stack);
        System.out.print("Original Stack: ");
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop() + " ");
        }
        System.out.println();

        ReverseStackSolution obj = new ReverseStackSolution();
        obj.reverseStack(stack);

        System.out.print("Reversed Stack: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}

class ReverseStackSolution {
    public void reverseStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            reverseStack(stack);
            insert(stack, temp);
        }
    }

    private void insert(Stack<Integer> stack, int temp) {
        if (stack.isEmpty()) {
            stack.push(temp);
            return;
        }

        int val = stack.pop();
        insert(stack, temp);
        stack.push(val);
    }
}
