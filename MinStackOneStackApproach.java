import java.util.Stack;

public class MinStackOneStackApproach {
    /**
     * One stack approach.
     * Please refer the MinStack.java for the explanation.
     */
    private static class Node {
        int val;
        int min;

        Node(int val, int min) {
            this.min = min;
            this.val = val;
        }
    }

    private Stack<Node> stack;

    public MinStackOneStackApproach() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if(stack.isEmpty()) {
            stack.push(new Node(val, val));
        } else {
            int currentMin = stack.peek().min;
            stack.push(new Node(val, Math.min(val, currentMin)));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }

    public static void main(String[] args) {
        MinStackOneStackApproach minStack = new MinStackOneStackApproach();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // Returns -3
        minStack.pop();
        System.out.println(minStack.top());    // Returns 0
        System.out.println(minStack.getMin()); // Returns -2
    }
}
