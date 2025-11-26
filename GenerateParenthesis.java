import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);


        // Alternatively, using StringBuilder for better performance
         backtrackUsingStringTemplate(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String current, int open, int close, int n) {
        if(open == n && close == n) {
            result.add(current);
            return;
        }
        if(open < n) {
            backtrack(result, current + "(", open+1, close, n);
        }
        if(close < open) {
            backtrack(result, current+ ")", open, close+1, n);
        }
    }

    private void backtrackUsingStringTemplate(List<String> result, StringBuilder current, int open, int close, int n) {
        if(open == n && close == n) {
            result.add(current.toString());
            return;
        }

        if(open < n ) {
            current.append('(');
            backtrackUsingStringTemplate(result, current, open +1, close, n);
            current.deleteCharAt(current.length() -1);
        }
        if(close < open) {
            current.append(')');
            backtrackUsingStringTemplate(result, current, open, close +1, n);
            current.deleteCharAt(current.length() -1);
        }
    }

    public static void  main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        int n = 8; // Example input
        List<String> parentheses = gp.generateParenthesis(n);
        System.out.println(parentheses);
    }
}
