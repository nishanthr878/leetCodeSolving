import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val){
        stack.push(val);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        Stack<Integer> tmp = new Stack<>();
        int mini = stack.peek();

        while(!stack.isEmpty()){
            mini = Math.min(mini, stack.peek());
            tmp.push(stack.pop());
        }

        while (!stack.isEmpty()){
            stack.push(tmp.pop());
        }
        return mini;
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
