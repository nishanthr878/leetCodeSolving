import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class ReversePolishNotation {
    public int evalRpnStack(String tokens[]) {
        Stack<Integer> stack = new Stack<>();
        for(String c : tokens) {
            if (c.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (c.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (c.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if(c.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b/a);
            } else {
                stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop();
    }

    public int evalRPNRecursion(String[] tokens) {
        List<String> toeknList = new ArrayList<>(Arrays.asList(tokens));
        return dfs(toeknList);
    }

    private int dfs(List<String> tokens) {
        String token = tokens.remove(tokens.size() -1);

        if(!"+-*/".contains(token)) {
            return Integer.parseInt(token);
        }

        int right = dfs(tokens);
        int left = dfs(tokens);


        switch (token) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                return left / right;
            default:
                throw new IllegalArgumentException("Invalid operator: " + token);
        }
    }

    public int evalRPN(String tokens[]){
        List<String> tokenList = new ArrayList<>(Arrays.asList(tokens));

        while (tokenList.size() > 1) {
            for(int i = 0; i < tokenList.size(); i++) {
                String token = tokenList.get(i);
                if("+-*/".contains(token)) {
                    int a = Integer.parseInt(tokenList.get(i - 2));
                    int b = Integer.parseInt(tokenList.get(i - 1));

                    int result = 0;
                    if(token.equals("+")) {
                        result = a + b;
                    } else if(token.equals("-")) {
                        result = a - b;
                    } else if(token.equals("*")) {
                        result = a * b;
                    } else if(token.equals("/")) {
                        result = a / b;
                    }

                    tokenList.set(i - 2, String.valueOf(result));
                    tokenList.remove(i);
                    tokenList.remove(i - 1);
                    break;
                }
            }
        }
        return Integer.parseInt(tokenList.get(0));
    }

    public int evalRPNDoubleLinkedList(String tokens[]) {
        DoublyLinkedList head = new DoublyLinkedList(tokens[0], null, null);
        DoublyLinkedList curr = head;

        for(int i = 1; i < tokens.length; i++) {
            curr.next = new DoublyLinkedList(tokens[i], null, curr);
            curr = curr.next;
        }

        int ans = 0;
        while (head != null) {
            if ("+-*/".contains(head.val)){
                int l = Integer.parseInt(head.prev.prev.val);
                int r = Integer.parseInt(head.prev.val);

                int res = 0;
                if (head.val.equals("+")) {
                    res = l + r;
                } else if (head.val.equals("-")) {
                    res = l - r;
                } else if (head.val.equals("*")) {
                    res = l * r;
                } else if (head.val.equals("/")) {
                    res = l / r;
                }

                head.val = String.valueOf(res);
                head.prev = head.prev.prev.prev;
                if (head.prev != null) {
                    head.prev.next = head;
                }
            }
            ans = Integer.parseInt(head.val);
            head = head.next;
        }
        return ans;
    }




    public static void main(String[] args) {
        ReversePolishNotation rpn = new ReversePolishNotation();

        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(rpn.evalRPN(tokens)); // Output: 9
        System.out.println(rpn.evalRPNDoubleLinkedList(tokens));
        System.out.println(rpn.evalRPNRecursion(tokens)); // Output: 9
        System.out.println(rpn.evalRpnStack(tokens));

        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println(rpn.evalRPN(tokens2)); // Output: 6
        System.out.println(rpn.evalRPNDoubleLinkedList(tokens2));
        System.out.println(rpn.evalRPNRecursion(tokens2)); // Output: 6
        System.out.println(rpn.evalRpnStack(tokens2));

        String[] tokens3 = {"10", "6", "9", "3", "/", "-11", "*", "+", "*"};
        System.out.println(rpn.evalRPN(tokens3)); // Output: 81
        System.out.println(rpn.evalRPNDoubleLinkedList(tokens3));
        System.out.println(rpn.evalRPNRecursion(tokens3)); // Output: 81
        System.out.println(rpn.evalRpnStack(tokens3));
    }
}
