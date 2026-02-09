import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateReversePolishNotation {
    /**
     * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
     * Valid operators are +, -, *, and /. Each operand may be an integer or another
     * When you see an operator:
     * 1. Pop the top value -> this is the second operand
     * 2. Pop the next value -> this is the first operand
     * 3. Commpute: first operand <operator> second operand
     * 4. Push the result back onto the stack
     *
     * Invariant (System thinking term)
     * After processing any prefix of tokens:
     * - The stack contains exactly the unresolved partial results.
     * - Each operator reduces stack size by 1.
     * - Each number increases stack size by 1.
     *
     * so the stack size after processing all tokens is 1.
     *
     * Time complexity: O(n) where n is the number of tokens.
     * Space complexity: O(n) for the stack in the worst case when all tokens are numbers.
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(String token : tokens) {
            if(isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();
                int result = apply(a, b, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private boolean isOperator(String s) {
        return s.length() == 1 && "+-*/".contains(s);
    }

    private int apply(int a, int b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation evaluator = new EvaluateReversePolishNotation();
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(evaluator.evalRPN(tokens)); // Output: 9
    }
}
