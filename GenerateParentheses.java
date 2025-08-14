import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    private void backtrack(int openN, int closedN, int n, List<String> res, StringBuilder stack) {
        if(openN == closedN && openN == n) {
            res.add(stack.toString());
            return;
        }

        if(openN < n) {
            stack.append('(');
            backtrack(openN + 1, closedN, n, res, stack);
            stack.deleteCharAt(stack.length() -1);
        }
        if (closedN < openN) {
            stack.append(')');
            backtrack(openN, closedN + 1, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }


    private boolean valid (String s) {
        int open = 0;
        for(char c : s.toCharArray()) {
            open += c == '(' ? 1 : -1;
            if(open < 0) {
                return false;
            }
        }
        return open == 0;
    }



    private void dfs(String s, List<String> res, int n) {
        if (n * 2 == s.length()) {
            if (valid(s)) res.add(s);
            return;
        }
        dfs(s+'(', res, n);
        dfs(s+')', res, n);
    }



    public List<String> generateParenthesisBruteForce(int n) {
        List<String> res = new ArrayList<>();
        dfs("", res, n);
        return res;
    }

    public List<String> generateParenthesisBacktracking(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        backtrack (0, 0, n, res, stack);
        return res;
    }

    public List<String> generateParenthesisDp(int n) {
        List<List<String>> res = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            res.add(new ArrayList<>());
        }
        res.get(0).add("");

        for(int k = 0; k <= n; k++) {
            for(int i = 0; i < k; i++) {
                for (String left : res.get(i)) {
                    for(String right : res.get(k - i - 1)) {
                        res.get(k).add('(' + left + ')' + right);
                    }
                }
            }
        }
        return res.get(n);

    }

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        List<String> result = gp.generateParenthesisBruteForce(3);
        System.out.println(result); // Output: ["((()))","(()())","(())()","()(())","()()()"]
        result = gp.generateParenthesisBacktracking(3);
        System.out.println(result); // Output: ["((()))","(()())","(())()
        result = gp.generateParenthesisDp(3);
        System.out.println(result); // Output: ["((()))","(()())","(())()
    }
}
