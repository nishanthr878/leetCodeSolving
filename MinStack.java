import java.util.Stack;

public class MinStack {
    /**
     * real proble is for getMin in O(1) time
     * System thinking: if an operation must be constant time, the information it needs must already be stored.
     * when I push a new element, I also push the minimum value up to that point onto a second stack.
     *
     * lets say a1, a2, a3, ... ak
     * minmum will be defined as m(k) = min(a1, a2, a3, ... ak)
     * m(k) = min(ak, m(k-1)) i.e prefix minimum.
     *
     * Below is the two stack approach.
     *
     * the other approach is to use a single stack with encoded values.
     */
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty()) {
            minStack.push(val);
        } else {
            minStack.push(Math.min(val, minStack.peek()));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStackTwoStack minStack = new MinStackTwoStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // Returns -3
        minStack.pop();
        System.out.println(minStack.top());    // Returns 0
        System.out.println(minStack.getMin()); // Returns -2
    }
}
