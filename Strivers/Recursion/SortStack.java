import java.util.Stack;

public class SortStack {
    // Strivers Link: https://takeuforward.org/plus/dsa/problems/sort-a-stack
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(1);
        stack.push(3);
        stack.push(2);
        SortStack obj = new SortStack();
        obj.sortStack(stack);

        System.out.println("Sorted stack in (desccending order): ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public void sortStack(Stack<Integer> st) {
        if (!st.isEmpty()) {
            int temp = st.pop();
            sortStack(st);
            insert(st, temp);
        }
    }

    private void insert(Stack<Integer> stack, int temp) {
        if (stack.isEmpty() || stack.peek() <= temp) {
            stack.push(temp);
            return;
        }
        int val = stack.pop();
        insert(stack, temp);

        stack.push(val);
    }
}
