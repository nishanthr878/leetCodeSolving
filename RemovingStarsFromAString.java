import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class RemovingStarsFromAString {
    /*
     * @param s: a string
     * @return: the string after removing stars
     * Algorithm: Stack (Deque)
     *
     * System Thinking
     * - A tream of character
     * - Two types of symobols: letters and *
     * - A rule that says
     *   - when a `*` is encountered, remove the closest non-star character to its left
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public String removeStars(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for(char ch : s.toCharArray()) {
            if(ch == '*') {
                stack.removeLast();
            } else {
                stack.addLast(ch);
            }
        }

        StringBuilder result = new StringBuilder();
        for(char ch : stack) {
            result.append(ch);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        RemovingStarsFromAString solution = new RemovingStarsFromAString();
        String s = "leet**cod*e";
        System.out.println(solution.removeStars(s)); // Output: "lecoe"
    }
}
