import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValidBruteForce(String s){
        while (s.contains("()") || s.contains("{}") || s.contains("[]")) {
            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");
        }
        return s.isEmpty();
    }

    public boolean isValidStack(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> closeToOpen = new HashMap<>();
        closeToOpen.put(')', '(');
        closeToOpen.put('}', '{');
        closeToOpen.put(']', '[');

        for(char c : s.toCharArray()){
            if (closeToOpen.containsKey(c)){
                if (!stack.isEmpty() && stack.peek() == closeToOpen.get(c)){
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String args[]){
        ValidParentheses vp = new ValidParentheses();
        String s1 = "({[]})";
        String s2 = "({[})";
        String s3 = "()[]{}";
        System.out.println("Brute Force: " + s1 + " is valid? "+ vp.isValidBruteForce(s1));
        System.out.println("Brute Force: " + s2 + " is valid? "+ vp.isValidBruteForce(s2));
        System.out.println("Brute Force: " + s3 + " is valid? "+ vp.isValidBruteForce(s3));
        System.out.println("Stack: " + s1 + " is valid? "+ vp.isValidStack(s1));
        System.out.println("Stack: " + s2 + " is valid? "+ vp.isValidStack(s2));
        System.out.println("Stack: " + s3 + " is valid? "+ vp.isValidStack(s3));
    }
}
